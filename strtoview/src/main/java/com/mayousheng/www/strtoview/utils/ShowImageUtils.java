package com.mayousheng.www.strtoview.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import com.yiba.www.filecache.FileCache;

/**
 * Created by marking on 2017/5/3.
 */

public class ShowImageUtils {

    private static ShowImageUtils showImageUtils;

    private ShowImageUtils() {
    }

    public static ShowImageUtils getInstance() {
        if (showImageUtils == null) {
            showImageUtils = new ShowImageUtils();
        }
        return showImageUtils;
    }

    public void ShowImage(Context context, ImageView imageView, String imgUrl) {
        FileCache.getInstance().init(context);
        new ShowImageTask(imageView, imgUrl).execute(imgUrl);
    }

    private class ShowImageTask extends AsyncTask<String, Void, Bitmap> {
        private String imgUrl;
        private ImageView imageView;

        private ShowImageTask(ImageView imageView, String imgUrl) {
            this.imgUrl = imgUrl;
            this.imageView = imageView;
            if (imageView != null && imgUrl != null) {
                imageView.setTag(imgUrl);
            }
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            Bitmap result = null;
            if (params != null && params.length > 0) {
                byte[] data = FileCache.getInstance().getFileNow(params[0]);
                if (data != null) {
                    result = BitmapFactory.decodeByteArray(data, 0, data.length);
                }
            }
            return result;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            if (imageView != null && bitmap != null && imgUrl != null) {
                String tag = (String) imageView.getTag();
                if (imgUrl.equals(tag)) {
                    imageView.setImageBitmap(bitmap);
                }
            }
        }
    }

}
