package com.thisobeystudio.fragmenttransitionstemplate.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thisobeystudio.fragmenttransitionstemplate.R;
import com.thisobeystudio.fragmenttransitionstemplate.base.BaseFragment;

/**
 * Created by Endika Aguilera (thisobeystudio) on 15/11/17.
 * Contact: thisobeystudio@gmail.com
 *
 * A placeholder fragment containing a simple view.
 */
public class FragmentTwo extends BaseFragment {

    public final static String FRAGMENT_TAG = "fragment_two";

    public FragmentTwo() {
    }

    public static FragmentTwo newInstance() {
        Bundle args = new Bundle();
        FragmentTwo fragment = new FragmentTwo();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mContext == null || mMainActivity == null) return null;
        mMainActivity.setTag(FragmentTwo.FRAGMENT_TAG);
        mMainActivity.updateButtonTextColor();
        return inflater.inflate(R.layout.fragment_two, container, false);
    }

}
