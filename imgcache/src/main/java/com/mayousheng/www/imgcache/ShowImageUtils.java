package com.mayousheng.www.imgcache;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;

/**
 * Created by marking on 2017/4/27.
 * 调用前务必对ImageCacheUtils初始化
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

    public void ShowImage(ImageView imageView, String imgUrl) {
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
                result = ImageCacheUtils.getInstance().getBitmapAnyWay(params[0]);
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
