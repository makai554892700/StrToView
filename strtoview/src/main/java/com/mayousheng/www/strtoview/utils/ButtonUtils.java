package com.mayousheng.www.strtoview.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.widget.Button;

import com.mayousheng.www.strtoview.pojo.ButtonDesc;

/**
 * Created by marking on 2017/4/27.
 */

public class ButtonUtils {

    private static ButtonUtils buttonUtils;

    private ButtonUtils() {
    }

    public static ButtonUtils getInstance() {
        if (buttonUtils == null) {
            buttonUtils = new ButtonUtils();
        }
        return buttonUtils;
    }

    public Button getButton(Context context, ButtonDesc buttonDesc) {
        return TextButtonUtils.getInstance().getButton(context, buttonDesc);
    }

}
