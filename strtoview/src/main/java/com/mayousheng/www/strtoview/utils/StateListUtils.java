package com.mayousheng.www.strtoview.utils;

import android.content.Context;
import android.graphics.drawable.StateListDrawable;

import com.mayousheng.www.strtoview.pojo.StateListDesc;

/**
 * Created by marking on 2017/5/4.
 */

public class StateListUtils {

    private static StateListUtils stateListUtils;

    private StateListUtils() {
    }

    public static StateListUtils getInstance() {
        if (stateListUtils == null) {
            stateListUtils = new StateListUtils();
        }
        return stateListUtils;
    }

    public StateListDrawable getStateListDrawable(Context context, StateListDesc stateListDesc) {
        if (context == null || stateListDesc == null) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        if (stateListDesc.selected != null) {
            stateListDrawable.addState(new int[]{android.R.attr.state_selected}
                    , GradientUtils.getInstance().getGradientDrawable(context, stateListDesc.selected));
        }
        if (stateListDesc.pressed != null) {
            stateListDrawable.addState(new int[]{android.R.attr.state_pressed}
                    , GradientUtils.getInstance().getGradientDrawable(context, stateListDesc.pressed));
        }
        if (stateListDesc.normal != null) {
            stateListDrawable.addState(new int[]{}
                    , GradientUtils.getInstance().getGradientDrawable(context, stateListDesc.normal));
        }
        return stateListDrawable;
    }

}
