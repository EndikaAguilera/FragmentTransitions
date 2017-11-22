package com.thisobeystudio.fragmenttransitionstemplate;

import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Button;

import com.thisobeystudio.fragmenttransitionstemplate.fragments.FragmentFour;
import com.thisobeystudio.fragmenttransitionstemplate.fragments.FragmentOne;
import com.thisobeystudio.fragmenttransitionstemplate.fragments.FragmentThree;
import com.thisobeystudio.fragmenttransitionstemplate.fragments.FragmentTwo;

/**
 * Created by Endika Aguilera (thisobeystudio) on 15/11/17.
 * Contact: thisobeystudio@gmail.com
 */

public class MainActivity extends AppCompatActivity {

    private Button mPrevButton;
    private Button mNextButton;

    private String mTag = "";

    private int mDefaultColor;
    private int mColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mPrevButton = findViewById(R.id.prev_btn);
        mNextButton = findViewById(R.id.next_btn);

        mPrevButton.setOnClickListener(view -> {
            if (!getTag().equals(FragmentOne.FRAGMENT_TAG)) {
                super.onBackPressed();
            }
        });

        mNextButton.setOnClickListener(view -> {
            switch (getTag()) {
                case FragmentOne.FRAGMENT_TAG: {
                    loadFragment(FragmentTwo.FRAGMENT_TAG);
                    break;
                }
                case FragmentTwo.FRAGMENT_TAG: {
                    loadFragment(FragmentThree.FRAGMENT_TAG);
                    break;
                }
                case FragmentThree.FRAGMENT_TAG: {
                    loadFragment(FragmentFour.FRAGMENT_TAG);
                    break;
                }
            }
        });

        mDefaultColor = mPrevButton.getCurrentTextColor();
        mColor = ContextCompat.getColor(MainActivity.this, R.color.colorAccent);

        loadFragment(FragmentOne.FRAGMENT_TAG);

    }

    public void updateButtonTextColor() {
        switch (getTag()) {
            case FragmentOne.FRAGMENT_TAG:
                mPrevButton.setTextColor(mColor);
                mNextButton.setTextColor(mDefaultColor);
                break;
            case FragmentFour.FRAGMENT_TAG:
                mPrevButton.setTextColor(mDefaultColor);
                mNextButton.setTextColor(mColor);
                break;
            case "":
            case FragmentTwo.FRAGMENT_TAG:
            case FragmentThree.FRAGMENT_TAG:
            default:
                mPrevButton.setTextColor(mDefaultColor);
                mNextButton.setTextColor(mDefaultColor);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    /**
     * @param tag fragment tag
     */
    private void loadFragment(@NonNull String tag) {

        if (!tag.equals(getTag())) {

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

            switch (tag) {
                case FragmentOne.FRAGMENT_TAG: {
                    FragmentOne mf = FragmentOne.newInstance();
                    ft.replace(R.id.frame_layout, mf);
                    break;
                }
                case FragmentTwo.FRAGMENT_TAG: {
                    FragmentTwo mf = FragmentTwo.newInstance();
                    ft.replace(R.id.frame_layout, mf);
                    break;
                }
                case FragmentThree.FRAGMENT_TAG: {
                    FragmentThree mf = FragmentThree.newInstance();
                    ft.replace(R.id.frame_layout, mf);
                    break;
                }
                case FragmentFour.FRAGMENT_TAG: {
                    FragmentFour mf = FragmentFour.newInstance();
                    ft.replace(R.id.frame_layout, mf);
                    break;
                }
            }

            try {
                ft.addToBackStack(tag);
                ft.commit();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
    }

    private String getTag() {
        return mTag;
    }

    public void setTag(String mTag) {
        this.mTag = mTag;
    }

}
