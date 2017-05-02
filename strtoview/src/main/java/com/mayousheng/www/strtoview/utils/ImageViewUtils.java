package com.mayousheng.www.strtoview.utils;

import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;

import com.mayousheng.www.strtoview.pojo.ImageViewDesc;

import com.mayousheng.www.imgcache.ShowImageUtils;

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
        if (imageViewDesc.id != 0) {
            imageView.setId(imageViewDesc.id);
        }
        if (imageViewDesc.params != null) {
            imageView.setLayoutParams(LayoutParamsUtils.getInstance().getLayoutParams(imageViewDesc.params));
        }
        if (imageViewDesc.url != null && !imageViewDesc.url.isEmpty()) {
            ShowImageUtils.getInstance().ShowImage(imageView, imageViewDesc.url);
        }
        if (imageViewDesc.color != null && !imageViewDesc.color.isEmpty()) {
            imageView.setBackgroundColor(Color.parseColor(imageViewDesc.color));
        }
        if (imageViewDesc.padding != null) {
            imageView.setPadding(imageViewDesc.padding.left, imageViewDesc.padding.top, imageViewDesc.padding.right, imageViewDesc.padding.bottom);
        }
        if (imageViewDesc.onClick != null) {
            imageView.setOnTouchListener(OnClickUtils.getInstance().getOnClickListener(context, imageViewDesc.onClick));
        }
        return imageView;
    }

}
