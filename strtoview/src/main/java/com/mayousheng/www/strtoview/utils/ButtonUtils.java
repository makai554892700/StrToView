package com.mayousheng.www.strtoview.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
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
        if (context == null || buttonDesc == null) {
            return null;
        }
        Button button = new Button(context);
        if (buttonDesc.id != 0) {
            button.setId(buttonDesc.id);
        }
        if (buttonDesc.text != null) {
            button.setText(buttonDesc.text);
        }
        if (buttonDesc.params != null) {
            button.setLayoutParams(LayoutParamsUtils.getInstance().getLayoutParams(buttonDesc.params));
        }
        if (buttonDesc.padding != null) {
            button.setPadding(buttonDesc.padding.left, buttonDesc.padding.top, buttonDesc.padding.right, buttonDesc.padding.bottom);
        }
        if (buttonDesc.onClick != null) {
            button.setOnTouchListener(OnClickUtils.getInstance().getOnClickListener(context, buttonDesc.onClick));
        }
        return button;
    }

}
