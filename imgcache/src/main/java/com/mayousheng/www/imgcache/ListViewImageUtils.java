package com.mayousheng.www.imgcache;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by marking on 2017/4/11.
 */

public class ListViewImageUtils {

    private ListView listView;
    private Set<ShowImageTask> showImageTasks;
    private String[] urls;

    public ListViewImageUtils(Context context, ListView listView) {
        ImageCacheUtils.getInstance().init(context);
        this.listView = listView;
        showImageTasks = new HashSet<ShowImageTask>();
    }

    public String[] getUrls() {
        return urls;
    }

    public void setUrls(String[] urls) {
        this.urls = urls;
    }

    public void loadImage(int start, int end) {
        if (urls != null) {
            for (int i = start; i < end; i++) {
                if (urls.length > i) {
                    String url = urls[i];
                    Bitmap tempBitmap = ImageCacheUtils.getInstance().getBitmapByDisk(url);
                    if (tempBitmap == null) {
                        ShowImageTask showImageTask = new ShowImageTask(url);
                        showImageTask.execute(url);
                        showImageTasks.add(showImageTask);
                    } else {
                        setImageViewByUrl(tempBitmap, url);
                    }
                }
            }
        }
    }

    public void stopAllTasks() {
        if (showImageTasks != null) {
            for (ShowImageTask showImageTask : showImageTasks) {
                showImageTask.cancel(false);
            }
        }
    }

    private class ShowImageTask extends AsyncTask<String, Void, Bitmap> {
        private String imgUrl;

        private ShowImageTask(String imgUrl) {
            this.imgUrl = imgUrl;
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
            setImageViewByUrl(bitmap, imgUrl);
            showImageTasks.remove(this);
        }
    }

    public void setImageViewByUrl(Bitmap bitmap, String imgUrl) {
        ImageView imageView = (ImageView) listView.findViewWithTag(imgUrl);
        if (imageView != null && bitmap != null) {
            imageView.setImageBitmap(bitmap);
        }
    }

}
