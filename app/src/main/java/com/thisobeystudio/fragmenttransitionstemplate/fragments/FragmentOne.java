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
public class FragmentOne extends BaseFragment {

    public final static String FRAGMENT_TAG = "fragment_one";

    public FragmentOne() {
    }

    public static FragmentOne newInstance() {
        Bundle args = new Bundle();
        FragmentOne fragment = new FragmentOne();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mContext == null || mMainActivity == null) return null;
        // this is the first fragment to show and I don't want it to start animated so...
        mAnimateOpenEnter = false;
        mMainActivity.setTag(FragmentOne.FRAGMENT_TAG);
        mMainActivity.updateButtonTextColor();
        return inflater.inflate(R.layout.fragment_one, container, false);
    }

}
