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
        int strokeWidth = 5; // 3dp 边框宽度
        int roundRadius = 15; // 8dp 圆角半径
        int strokeColor = Color.parseColor("#44FFFFFF");//边框颜色
        int fillColor = Color.parseColor("#44000000");//内部填充颜色
        int fillColor2 = Color.parseColor("#44FFFF00");//内部填充颜色
        int fillColor3 = Color.parseColor("#44FF00FF");//内部填充颜色
        int fillColor4 = Color.parseColor("#4400FFFF");//内部填充颜色
        int fillColor5 = Color.parseColor("#4400FF00");//内部填充颜色

        GradientDrawable gd = new GradientDrawable();//创建drawable
        gd.setColor(fillColor);
        gd.setCornerRadius(roundRadius);
        gd.setStroke(strokeWidth, strokeColor);

        GradientDrawable gd2 = new GradientDrawable();//创建drawable
        gd2.setColor(fillColor2);
        gd2.setCornerRadius(roundRadius);
        gd2.setStroke(strokeWidth, strokeColor);

        GradientDrawable gd3 = new GradientDrawable();//创建drawable
        gd3.setColor(fillColor3);
        gd3.setCornerRadius(roundRadius);
        gd3.setStroke(strokeWidth, strokeColor);

        GradientDrawable gd4 = new GradientDrawable();//创建drawable
        gd4.setColor(fillColor4);
        gd4.setCornerRadius(roundRadius);
        gd4.setStroke(strokeWidth, strokeColor);

        GradientDrawable gd5 = new GradientDrawable();//创建drawable
        gd5.setColor(fillColor5);
        gd5.setCornerRadius(roundRadius);
        gd5.setStroke(strokeWidth, strokeColor);

        StateListDrawable stalistDrawable = new StateListDrawable();
        int pressed = android.R.attr.state_pressed;
        int window_focused = android.R.attr.state_window_focused;
        int focused = android.R.attr.state_focused;
        int selected = android.R.attr.state_selected;

        stalistDrawable.addState(new int[]{pressed, window_focused}, gd);
        stalistDrawable.addState(new int[]{pressed, -focused}, gd2);
        stalistDrawable.addState(new int[]{selected}, gd3);
        stalistDrawable.addState(new int[]{focused}, gd4);
        stalistDrawable.addState(new int[]{}, gd5);

        button.setBackground(stalistDrawable);

        return button;
    }

}
