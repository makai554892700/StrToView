package com.mayousheng.www.strtoview.utils;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.VideoView;

import com.yiba.www.filecache.FileCache;

/**
 * Created by marking on 2017/5/3.
 */

public class PlayVideoUtils {


    private static PlayVideoUtils playVideoUtils;

    private PlayVideoUtils() {
    }

    public static PlayVideoUtils getInstance() {
        if (playVideoUtils == null) {
            playVideoUtils = new PlayVideoUtils();
        }
        return playVideoUtils;
    }

    public void playVideo(Context context, VideoView videoView, String url) {
        FileCache.getInstance().init(context);
        new PlayVideoTask(videoView, url).execute(url);
    }

    private class PlayVideoTask extends AsyncTask<String, Void, String> {
        private String url;
        private VideoView videoView;

        private PlayVideoTask(VideoView videoView, String url) {
            this.url = url;
            this.videoView = videoView;
            if (videoView != null && url != null) {
                videoView.setTag(url);
            }
        }

        @Override
        protected String doInBackground(String... params) {
            String result = null;
            if (params != null && params.length > 0) {
                result = FileCache.getInstance().getFilePathNow(params[0]);
            }
            return result;
        }

        @Override
        protected void onPostExecute(String path) {
            if (videoView != null && path != null && url != null) {
                String tag = (String) videoView.getTag();
                if (url.equals(tag)) {
                    videoView.setVideoPath(path);
                    videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {//play finish
                            Log.e("-----1", "onCompletion");
                        }
                    });
                    videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                        @Override
                        public boolean onError(MediaPlayer mp, int what, int extra) {
                            Log.e("-----1", "onError");
                            return false;
                        }
                    });
                    videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mp) {//load ok
                            Log.e("-----1", "onPrepared");
                            videoView.start();
                        }
                    });
                }
            }
        }
    }

}
