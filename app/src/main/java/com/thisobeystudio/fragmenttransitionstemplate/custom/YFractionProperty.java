package com.thisobeystudio.fragmenttransitionstemplate.custom;

import android.util.Property;
import android.view.View;

/**
 * Created by Endika Aguilera (thisobeystudio) on 15/11/17.
 * Contact: thisobeystudio@gmail.com
 *
 * source code from:
 * https://gist.github.com/devunwired/ccc6487a1e3fed9c79e0
 *
 */

public class YFractionProperty extends Property<View, Float> {

    public YFractionProperty() {
        super(Float.class, "fractionY");
    }

    @Override
    public Float get(View object) {
        final int viewHeight = object.getHeight();
        if (viewHeight == 0) {
            return 0f;
        }

        return object.getTranslationY() / viewHeight;
    }

    @Override
    public void set(View object, Float value) {
        final int viewHeight = object.getHeight();
        //Avoid flickers on entering views until they are measured
        float translation = viewHeight > 0 ? viewHeight * value : Float.MAX_VALUE;

        object.setTranslationY(translation);
    }
}