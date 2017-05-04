package com.mayousheng.www.strtoview.utils;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;

import com.mayousheng.www.strtoview.pojo.TextViewDesc;

/**
 * Created by marking on 2017/5/4.
 */

public class TextButtonUtils {


    private static TextButtonUtils textButtonUtils;

    private TextButtonUtils() {
    }

    public static TextButtonUtils getInstance() {
        if (textButtonUtils == null) {
            textButtonUtils = new TextButtonUtils();
        }
        return textButtonUtils;
    }

    public Button getButton(Context context, TextViewDesc textViewDesc) {
        if (context == null || textViewDesc == null) {
            return null;
        }
        return commontGet(new Button(context), context, textViewDesc);
    }

    public TextView getTextView(Context context, TextViewDesc textViewDesc) {
        if (context == null || textViewDesc == null) {
            return null;
        }
        return commontGet(new TextView(context), context, textViewDesc);
    }

    private <T extends TextView> T commontGet(T t, Context context, TextViewDesc textViewDesc) {
        t = CommonViewUtils.getInstance().updateView(context, t, textViewDesc);
        if (textViewDesc.text != null) {
            t.setText(textViewDesc.text);
        }
        if (textViewDesc.textSize != 0) {
            t.setTextSize(textViewDesc.textSize);
        }
        if (textViewDesc.gravity != 0) {
            t.setGravity(textViewDesc.gravity);
        }
        if (textViewDesc.textColor != null && !textViewDesc.textColor.isEmpty()) {
            t.setTextColor(Color.parseColor(textViewDesc.textColor));
        }
        if (textViewDesc.stateListDesc != null) {
            t.setBackgroundDrawable(StateListUtils.getInstance().getStateListDrawable(context, textViewDesc.stateListDesc));
        }
        if (textViewDesc.minLine != 0) {
            t.setMaxLines(textViewDesc.minLine);
        }
        if (textViewDesc.maxLine != 0) {
            t.setMaxLines(textViewDesc.maxLine);
        }
        if (textViewDesc.ellipsize != null && !textViewDesc.ellipsize.isEmpty()) {
            try {
                t.setEllipsize(TextUtils.TruncateAt.valueOf(textViewDesc.ellipsize));
            } catch (Exception e) {
            }
        }
        return t;
    }

}
