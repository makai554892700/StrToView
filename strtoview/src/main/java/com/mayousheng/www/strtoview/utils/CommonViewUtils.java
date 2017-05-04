package com.mayousheng.www.strtoview.utils;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mayousheng.www.strtoview.pojo.BaseViewDesc;
import com.mayousheng.www.strtoview.pojo.LayoutDesc;
import com.mayousheng.www.strtoview.pojo.MMDesc;

/**
 * Created by marking on 2017/4/26.
 */

public class CommonViewUtils {

    private static CommonViewUtils commonViewUtils;

    private CommonViewUtils() {
    }

    public static CommonViewUtils getInstance() {
        if (commonViewUtils == null) {
            commonViewUtils = new CommonViewUtils();
        }
        return commonViewUtils;
    }

    public View getViewByStr(Context context, String response) {
        if (context == null || response == null || response.isEmpty()) {
            return null;
        }
        return LayoutUtils.getInstance().getLayout(context
                , new LayoutDesc(response));
    }

    public <T extends View> T updateView(Context context, T view, BaseViewDesc baseViewDesc) {
        if (view != null && baseViewDesc != null) {
            if (baseViewDesc.id != 0) {
                view.setId(baseViewDesc.id);
            }
            if (baseViewDesc.backColor != null && !baseViewDesc.backColor.isEmpty()) {
                try {
                    view.setBackgroundColor(Color.parseColor(baseViewDesc.backColor));
                } catch (Exception e) {
                }
            }
            if (baseViewDesc.params != null) {
                view.setLayoutParams(LayoutParamsUtils.getInstance().getLayoutParams(baseViewDesc.params));
            }
            if (baseViewDesc.padding != null) {
                view.setPadding(baseViewDesc.padding.left, baseViewDesc.padding.top, baseViewDesc.padding.right, baseViewDesc.padding.bottom);
            }
            view = updateView(view, baseViewDesc.mmDesc);
            if (baseViewDesc.onClick != null) {
                view.setOnTouchListener(OnClickUtils.getInstance().getOnClickListener(context, baseViewDesc.onClick));
            }
        }
        return view;
    }

    public <T extends View> T updateView(T view, MMDesc mmDesc) {
        if (view != null && mmDesc != null) {
            if (mmDesc.minWidth != 0) {
                view.setMinimumWidth(mmDesc.minWidth);
            }
            if (mmDesc.minHeight != 0) {
                view.setMinimumWidth(mmDesc.minWidth);
            }
            if (mmDesc.maxHeight != 0) {
                if (view instanceof Button) {
                    ((Button) view).setMaxHeight(mmDesc.maxHeight);
                } else if (view instanceof TextView) {
                    ((TextView) view).setMaxHeight(mmDesc.maxHeight);
                } else if (view instanceof ImageView) {
                    ((ImageView) view).setMaxHeight(mmDesc.maxHeight);
                }
            }
            if (mmDesc.maxWidth != 0) {
                if (view instanceof Button) {
                    ((Button) view).setMaxWidth(mmDesc.maxWidth);
                } else if (view instanceof TextView) {
                    ((TextView) view).setMaxWidth(mmDesc.maxWidth);
                } else if (view instanceof ImageView) {
                    ((ImageView) view).setMaxWidth(mmDesc.maxWidth);
                }
            }
        }
        return view;
    }

}