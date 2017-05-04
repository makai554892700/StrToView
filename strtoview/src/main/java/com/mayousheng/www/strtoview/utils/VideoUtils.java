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
        VideoView result = new VideoView(context);
        result = CommonViewUtils.getInstance().updateView(context, result, videoDesc);
        PlayVideoUtils.getInstance().playVideo(context, result, videoDesc.url);
        return result;
    }

}
