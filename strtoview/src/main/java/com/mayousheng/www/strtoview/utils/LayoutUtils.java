package com.mayousheng.www.strtoview.utils;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.mayousheng.www.strtoview.pojo.ButtonDesc;
import com.mayousheng.www.strtoview.pojo.ChildDesc;
import com.mayousheng.www.strtoview.pojo.ImageViewDesc;
import com.mayousheng.www.strtoview.pojo.LayoutDesc;
import com.mayousheng.www.strtoview.pojo.TextViewDesc;
import com.mayousheng.www.strtoview.pojo.VideoDesc;

/**
 * Created by marking on 2017/4/27.
 */

public class LayoutUtils {

    private static LayoutUtils layoutUtils;

    private LayoutUtils() {
    }

    public static LayoutUtils getInstance() {
        if (layoutUtils == null) {
            layoutUtils = new LayoutUtils();
        }
        return layoutUtils;
    }

    public ViewGroup getLayout(Context context, LayoutDesc layoutDesc) {
        if (context == null || layoutDesc == null || layoutDesc.type == 0) {
            return null;
        }
        switch (layoutDesc.type) {
            case LayoutDesc.TYPE_FRAME:
                FrameLayout frameLayout = new FrameLayout(context);
                if (layoutDesc.id != 0) {
                    frameLayout.setId(layoutDesc.id);
                }
                if (layoutDesc.params != null) {
                    frameLayout.setLayoutParams(LayoutParamsUtils.getInstance().getLayoutParams(layoutDesc.params));
                }
                if (layoutDesc.color != null && !layoutDesc.color.isEmpty()) {
                    frameLayout.setBackgroundColor(Color.parseColor(layoutDesc.color));
                }
                if (layoutDesc.children != null) {
                    for (ChildDesc child : layoutDesc.children) {
                        View childView = getChildByDesc(context, child);
                        if (childView != null) {
                            frameLayout.addView(childView);
                        }
                    }
                }
                if (layoutDesc.onClick != null) {
                    frameLayout.setOnTouchListener(OnClickUtils.getInstance().getOnClickListener(context, layoutDesc.onClick));
                }
                return frameLayout;
            case LayoutDesc.TYPE_RELATIVE:
                RelativeLayout relativeLayout = new RelativeLayout(context);
                if (layoutDesc.id != 0) {
                    relativeLayout.setId(layoutDesc.id);
                }
                if (layoutDesc.gravity != 0) {
                    relativeLayout.setGravity(layoutDesc.gravity);
                }
                if (layoutDesc.params != null) {
                    relativeLayout.setLayoutParams(LayoutParamsUtils.getInstance().getLayoutParams(layoutDesc.params));
                }
                if (layoutDesc.color != null && !layoutDesc.color.isEmpty()) {
                    relativeLayout.setBackgroundColor(Color.parseColor(layoutDesc.color));
                }
                if (layoutDesc.children != null) {
                    for (ChildDesc child : layoutDesc.children) {
                        View childView = getChildByDesc(context, child);
                        if (childView != null) {
                            relativeLayout.addView(childView);
                        }
                    }
                }
                if (layoutDesc.onClick != null) {
                    relativeLayout.setOnTouchListener(OnClickUtils.getInstance().getOnClickListener(context, layoutDesc.onClick));
                }
                return relativeLayout;
            case LayoutDesc.TYPE_LINEAR:
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(layoutDesc.orientation);
                if (layoutDesc.id != 0) {
                    linearLayout.setId(layoutDesc.id);
                }
                if (layoutDesc.gravity != 0) {
                    linearLayout.setGravity(layoutDesc.gravity);
                }
                if (layoutDesc.params != null) {
                    linearLayout.setLayoutParams(LayoutParamsUtils.getInstance().getLayoutParams(layoutDesc.params));
                }
                if (layoutDesc.color != null && !layoutDesc.color.isEmpty()) {
                    linearLayout.setBackgroundColor(Color.parseColor(layoutDesc.color));
                }
                if (layoutDesc.children != null) {
                    for (ChildDesc child : layoutDesc.children) {
                        View childView = getChildByDesc(context, child);
                        if (childView != null) {
                            linearLayout.addView(childView);
                        }
                    }
                }
                if (layoutDesc.onClick != null) {
                    linearLayout.setOnTouchListener(OnClickUtils.getInstance().getOnClickListener(context, layoutDesc.onClick));
                }
                return linearLayout;
        }
        return null;
    }

    private View getChildByDesc(Context context, ChildDesc child) {
        if (child == null || child.type <= 0 || child.str == null || child.str.isEmpty()) {
            return null;
        }
        View result = null;
        switch (child.type) {
            case ChildDesc.TYPE_FRAME:
            case ChildDesc.TYPE_LINEAR:
            case ChildDesc.TYPE_RELATIVE:
                LayoutDesc frame = new LayoutDesc(child.str);
                result = LayoutUtils.getInstance().getLayout(context, frame);
                break;
            case ChildDesc.TYPE_IMG:
                ImageViewDesc imageViewDesc = new ImageViewDesc(child.str);
                result = ImageViewUtils.getInstance().getImageView(context, imageViewDesc);
                break;
            case ChildDesc.TYPE_TEXT:
                TextViewDesc textViewDesc = new TextViewDesc(child.str);
                result = TextViewUtils.getInstance().getTextView(context, textViewDesc);
                break;
            case ChildDesc.TYPE_BUTTON:
                ButtonDesc buttonDesc = new ButtonDesc(child.str);
                result = ButtonUtils.getInstance().getButton(context, buttonDesc);
                break;
            case ChildDesc.TYPE_VIDEO:
                VideoDesc videoDesc = new VideoDesc(child.str);
                result = VideoUtils.getInstance().getVideoView(context, videoDesc);
                break;
        }
        return result;
    }

}
