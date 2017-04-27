package com.mayousheng.www.strtoview.utils;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.mayousheng.www.strtoview.pojo.LayoutParamsDesc;
import com.mayousheng.www.strtoview.pojo.RuleDesc;

/**
 * Created by marking on 2017/4/26.
 */

public class LayoutParamsUtils {

    private static LayoutParamsUtils layoutParamsUtils;

    private LayoutParamsUtils() {
    }

    public static LayoutParamsUtils getInstance() {
        if (layoutParamsUtils == null) {
            layoutParamsUtils = new LayoutParamsUtils();
        }
        return layoutParamsUtils;
    }

    public ViewGroup.LayoutParams getLayoutParams(LayoutParamsDesc layoutParamsDesc) {
        if (layoutParamsDesc == null) {
            return null;
        }
        switch (layoutParamsDesc.type) {
            case LayoutParamsDesc.TYPE_RELATIVE:
                RelativeLayout.LayoutParams rlp = new RelativeLayout.LayoutParams(layoutParamsDesc.width, layoutParamsDesc.height);
                if (layoutParamsDesc.rules != null) {
                    for (RuleDesc rule : layoutParamsDesc.rules) {
                        rlp.addRule(rule.key, rule.value);
                    }
                }
                if (layoutParamsDesc.margins != null) {
                    rlp.setMargins(layoutParamsDesc.margins.left, layoutParamsDesc.margins.top
                            , layoutParamsDesc.margins.right, layoutParamsDesc.margins.bottom);
                }
                return rlp;
            case LayoutParamsDesc.TYPE_FRAME:
                FrameLayout.LayoutParams flp = new FrameLayout.LayoutParams(layoutParamsDesc.width, layoutParamsDesc.height);
                if (layoutParamsDesc.weight != 0) {
                    flp.width = layoutParamsDesc.weight;
                }
                if (layoutParamsDesc.gravity != 0) {
                    flp.gravity = layoutParamsDesc.gravity;
                }
                if (layoutParamsDesc.margins != null) {
                    flp.setMargins(layoutParamsDesc.margins.left, layoutParamsDesc.margins.top
                            , layoutParamsDesc.margins.right, layoutParamsDesc.margins.bottom);
                }
                return flp;
            case LayoutParamsDesc.TYPE_LINEAR:
                LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(layoutParamsDesc.width, layoutParamsDesc.height);
                if (layoutParamsDesc.weight != 0) {
                    llp.weight = layoutParamsDesc.weight;
                }
                if (layoutParamsDesc.gravity != 0) {
                    llp.gravity = layoutParamsDesc.gravity;
                }
                if (layoutParamsDesc.margins != null) {
                    llp.setMargins(layoutParamsDesc.margins.left, layoutParamsDesc.margins.top
                            , layoutParamsDesc.margins.right, layoutParamsDesc.margins.bottom);
                }
                return llp;
        }
        return null;
    }

}
