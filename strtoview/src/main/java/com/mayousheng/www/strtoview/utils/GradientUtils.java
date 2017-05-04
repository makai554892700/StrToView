package com.mayousheng.www.strtoview.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;

import com.mayousheng.www.strtoview.pojo.GradientDesc;

/**
 * Created by marking on 2017/5/4.
 */

public class GradientUtils {

    private static GradientUtils gradientUtils;

    private GradientUtils() {
    }

    public static GradientUtils getInstance() {
        if (gradientUtils == null) {
            gradientUtils = new GradientUtils();
        }
        return gradientUtils;
    }

    public GradientDrawable getGradientDrawable(Context context, GradientDesc gradientDesc) {
        if (context == null || gradientDesc == null) {
            return null;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (gradientDesc.fillColor != null && !gradientDesc.fillColor.isEmpty()) {
            gradientDrawable.setColor(Color.parseColor(gradientDesc.fillColor));
        }
        if (gradientDesc.strokeColor != null && !gradientDesc.strokeColor.isEmpty()) {
            gradientDrawable.setStroke(gradientDesc.strokeWidth, Color.parseColor(gradientDesc.strokeColor));
        }
        if (gradientDesc.roundRadius != 0) {
            gradientDrawable.setCornerRadius(gradientDesc.roundRadius);
        }
        return gradientDrawable;
    }

}
