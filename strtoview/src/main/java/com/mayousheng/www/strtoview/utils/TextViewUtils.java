package com.mayousheng.www.strtoview.utils;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.widget.TextView;

import com.mayousheng.www.strtoview.pojo.TextViewDesc;

/**
 * Created by marking on 2017/4/27.
 */

public class TextViewUtils {

    private static TextViewUtils textViewUtils;

    private TextViewUtils() {
    }

    public static TextViewUtils getInstance() {
        if (textViewUtils == null) {
            textViewUtils = new TextViewUtils();
        }
        return textViewUtils;
    }

    public TextView getTextView(Context context, TextViewDesc textViewDesc) {
        return TextButtonUtils.getInstance().getTextView(context, textViewDesc);
    }

}
