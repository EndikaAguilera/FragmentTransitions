package com.thisobeystudio.fragmenttransitionstemplate.fragments;

import android.os.Bundle;
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
public class FragmentThree extends BaseFragment {

    public final static String FRAGMENT_TAG = "fragment_three";

    public FragmentThree() {
    }

    public static FragmentThree newInstance() {
        Bundle args = new Bundle();
        FragmentThree fragment = new FragmentThree();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mContext == null || mMainActivity == null) return null; // fixme create an error layout??
        mMainActivity.setTag(FragmentThree.FRAGMENT_TAG);
        mMainActivity.updateButtonTextColor();
        return inflater.inflate(R.layout.fragment_three, container, false);
    }

}
