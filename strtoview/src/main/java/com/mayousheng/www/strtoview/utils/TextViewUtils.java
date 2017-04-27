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
        if (context == null || textViewDesc == null) {
            return null;
        }
        TextView textView = new TextView(context);
        if (textViewDesc.id != 0) {
            textView.setId(textViewDesc.id);
        }
        if (textViewDesc.text != null) {
            textView.setText(textViewDesc.text);
        }
        if (textViewDesc.color != null && !textViewDesc.color.isEmpty()) {
            textView.setTextColor(Color.parseColor(textViewDesc.color));
        }
        if (textViewDesc.backColor != null && !textViewDesc.backColor.isEmpty()) {
            textView.setBackgroundColor(Color.parseColor(textViewDesc.backColor));
        }
        if (textViewDesc.size != 0) {
            textView.setTextSize(textViewDesc.size);
        }
        if (textViewDesc.params != null) {
            textView.setLayoutParams(LayoutParamsUtils.getInstance().getLayoutParams(textViewDesc.params));
        }
        if (textViewDesc.maxLine != 0) {
            textView.setMaxLines(textViewDesc.maxLine);
        }
        if (textViewDesc.ellipsize != null && !textViewDesc.ellipsize.isEmpty()) {
            textView.setEllipsize(TextUtils.TruncateAt.valueOf(textViewDesc.ellipsize));
        }
        if (textViewDesc.gravity != 0) {
            textView.setGravity(textViewDesc.gravity);
        }
        if (textViewDesc.padding != null) {
            textView.setPadding(textViewDesc.padding.left, textViewDesc.padding.top, textViewDesc.padding.right, textViewDesc.padding.bottom);
        }
        return textView;
    }

}
