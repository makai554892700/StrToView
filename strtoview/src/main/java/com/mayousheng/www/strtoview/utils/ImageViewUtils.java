package com.mayousheng.www.strtoview.utils;

import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;

import com.mayousheng.www.strtoview.pojo.ImageViewDesc;

/**
 * Created by marking on 2017/4/27.
 */

public class ImageViewUtils {

    private static ImageViewUtils imageViewUtils;

    private ImageViewUtils() {
    }

    public static ImageViewUtils getInstance() {
        if (imageViewUtils == null) {
            imageViewUtils = new ImageViewUtils();
        }
        return imageViewUtils;
    }

    public ImageView getImageView(Context context, ImageViewDesc imageViewDesc) {
        if (context == null || imageViewDesc == null) {
            return null;
        }
        ImageView imageView = new ImageView(context);
        imageView = CommonViewUtils.getInstance().updateView(context, imageView, imageViewDesc);
        if (imageViewDesc.url != null && !imageViewDesc.url.isEmpty()) {
            ShowImageUtils.getInstance().ShowImage(context, imageView, imageViewDesc.url);
        }
        return imageView;
    }

}
