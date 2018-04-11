package com.thisobeystudio.fragmenttransitionstemplate.base;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Property;

import com.thisobeystudio.fragmenttransitionstemplate.MainActivity;
import com.thisobeystudio.fragmenttransitionstemplate.custom.XFractionProperty;
import com.thisobeystudio.fragmenttransitionstemplate.custom.YFractionProperty;

/**
 * Created by Endika Aguilera (thisobeystudio) on 15/11/17.
 * Contact: thisobeystudio@gmail.com
 */

public class BaseFragment extends Fragment {

    // animator orientation options
    private enum ANIMATOR_ORIENTATION {
        HORIZONTAL,
        VERTICAL
    }

    // determines the animator orientation mode
    private final ANIMATOR_ORIENTATION mAnimatorOrientation = ANIMATOR_ORIENTATION.HORIZONTAL;

    // context
    protected Context mContext;

    // parent activity
    protected MainActivity mMainActivity;

    // a flag to handle if each fragment will be animated or not
    // if want all fragments to be animated, this param can be removed
    private boolean mAnimate = true;

    // required mAnimate = true to work
    // if this is false only will animate on
    // (transit == FragmentTransaction.TRANSIT_FRAGMENT_OPEN && !enter)
    // and
    // (transit == FragmentTransaction.TRANSIT_FRAGMENT_CLOSE && enter)
    protected boolean mAnimateOpenEnter = true;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        if (mContext != null)
            mMainActivity = ((MainActivity) mContext);
        else return;

        //float was = Settings.Global.getFloat(mContext.getContentResolver(),
        //        Settings.Global.WINDOW_ANIMATION_SCALE, 0.75f);
        //float tas = Settings.Global.getFloat(mContext.getContentResolver(),
        //        Settings.Global.TRANSITION_ANIMATION_SCALE, 0.75f);

        // since we are using animators we must check devices ANIMATOR_DURATION_SCALE value
        // if Settings > Developer options > Animator duration scale = Animation off
        // we must disable animators, otherwise app user wont be able to see fragments views
        float deviceAnimatorDurationScale = Settings.Global.getFloat(mContext.getContentResolver(),
                Settings.Global.ANIMATOR_DURATION_SCALE, 0.13f);

        // if any of these two checks are true, disable animators if not,
        // user wont be able to see fragments views, so app Animators must be disabled
        // if (deviceAnimatorDurationScale == 0.0f)
        // means that ANIMATOR_DURATION_SCALE is set to Animation off, app Animators must be disabled
        // if (deviceAnimatorDurationScale == 0.13f)
        // means that an error occurred while extracting ANIMATOR_DURATION_SCALE so...
        // to prevent unexpected results we disable, app Animators must be disabled
        if (deviceAnimatorDurationScale == 0.0f || deviceAnimatorDurationScale == 0.13f) {
            mAnimate = false;
        }

    }

    @Override
    public Animator onCreateAnimator(int transit, boolean enter, int nextAnim) {
        Property<?, Float> property = null;
        switch (mAnimatorOrientation) {
            case HORIZONTAL:
                property = new XFractionProperty();
                break;
            case VERTICAL:
                property = new YFractionProperty();
                break;
        }
        // if true set animators to fragment transitions
        if (mAnimate) {
            if (!mAnimateOpenEnter) {
                if (transit == FragmentTransaction.TRANSIT_FRAGMENT_OPEN && !enter) {
                    return ObjectAnimator.ofFloat(null, property, 0f, -1f);
                } else if (transit == FragmentTransaction.TRANSIT_FRAGMENT_CLOSE && enter) {
                    return ObjectAnimator.ofFloat(null, property, -1f, 0f);
                } else return super.onCreateAnimator(transit, enter, nextAnim);
            } else {
                switch (transit) {
                    case FragmentTransaction.TRANSIT_FRAGMENT_OPEN:
                        return enter ? ObjectAnimator.ofFloat(null, property, 1f, 0f)
                                : ObjectAnimator.ofFloat(null, property, 0f, -1f);
                    case FragmentTransaction.TRANSIT_FRAGMENT_CLOSE:
                        return enter ? ObjectAnimator.ofFloat(null, property, -1f, 0f)
                                : ObjectAnimator.ofFloat(null, property, 0f, 1f);
                    default:
                        return super.onCreateAnimator(transit, enter, nextAnim);
                }
            }
        } else return super.onCreateAnimator(transit, enter, nextAnim);
    }

}
