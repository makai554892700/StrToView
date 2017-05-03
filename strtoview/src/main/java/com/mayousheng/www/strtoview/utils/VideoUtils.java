package com.mayousheng.www.strtoview.utils;

import android.content.Context;
import android.widget.VideoView;

import com.mayousheng.www.strtoview.pojo.VideoDesc;

/**
 * Created by marking on 2017/4/28.
 */

public class VideoUtils {

    public static final String HTTP = "http";

    private static VideoUtils videoUtils;

    private VideoUtils() {
    }

    public static VideoUtils getInstance() {
        if (videoUtils == null) {
            videoUtils = new VideoUtils();
        }
        return videoUtils;
    }

    public VideoView getVideoView(Context context, VideoDesc videoDesc) {
        if (context == null || videoDesc == null || videoDesc.url == null || !videoDesc.url.startsWith(HTTP)) {
            return null;
        }
        final VideoView result = new VideoView(context);
        if (videoDesc.id != 0) {
            result.setId(videoDesc.id);
        }
        if (videoDesc.params != null) {
            result.setLayoutParams(LayoutParamsUtils.getInstance().getLayoutParams(videoDesc.params));
        }
        if (videoDesc.padding != null) {
            result.setPadding(videoDesc.padding.left, videoDesc.padding.top, videoDesc.padding.right, videoDesc.padding.bottom);
        }
        PlayVideoUtils.getInstance().playVideo(context, result, videoDesc.url);
        if (videoDesc.onClick != null) {
            result.setOnTouchListener(OnClickUtils.getInstance().getOnClickListener(context, videoDesc.onClick));
        }
        return result;
    }

}
