package com.mayousheng.www.strtoview.utils;

import android.content.Context;
import android.view.View;

import com.mayousheng.www.strtoview.pojo.LayoutDesc;

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

}