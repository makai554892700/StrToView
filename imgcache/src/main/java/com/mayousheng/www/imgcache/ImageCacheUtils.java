package com.mayousheng.www.imgcache;

import android.content.Context;
import android.graphics.Bitmap;

import java.io.IOException;
import java.io.OutputStream;

import com.mayousheng.www.imgcache.cache.BaseImageUtils;
import com.mayousheng.www.imgcache.cache.DiskLruCache;

/**
 * Created by marking on 2017/4/12.
 */

public class ImageCacheUtils extends BaseImageUtils {

    private static final String CACHE_PATH = "mayousheng_bitmap";

    private static ImageCacheUtils imageCacheUtils;
    private DiskLruCache diskLruCache;

    private ImageCacheUtils() {
    }

    public static ImageCacheUtils getInstance() {
        if (imageCacheUtils == null) {
            imageCacheUtils = new ImageCacheUtils();
        }
        return imageCacheUtils;
    }

    public void init(Context context) {
        if (imageCacheUtils.diskLruCache == null && context != null) {
            try {
                imageCacheUtils.diskLruCache = DiskLruCache.open(getDiskCacheDir(context
                        , CACHE_PATH), getAppVersion(context), 1, 10 * 1024 * 1024);
            } catch (IOException e) {
            }
        }
    }

    //调用前务必对ImageCacheUtils初始化
    public Bitmap getBitmapByDisk(String imageUrl) {
        return getBitmapByDisk(null, imageUrl);
    }

    //调用前务必对ImageCacheUtils初始化
    public Bitmap getBitmapAnyWay(String imageUrl) {
        return getBitmapAnyWay(null, imageUrl);
    }

    public Bitmap getBitmapByDisk(Context context, String imageUrl) {
        if ((imageCacheUtils.diskLruCache == null && context == null)
                || imageUrl == null || imageUrl.isEmpty()) {
            return null;
        } else {
            init(context);
            String key = hashKeyForDisk(imageUrl);
            return getBitmap(diskLruCache, key);
        }
    }

    public Bitmap getBitmapAnyWay(Context context, String imageUrl) {
        Bitmap result = getBitmapByDisk(context, imageUrl);
        if (result == null) {
            do {
                DiskLruCache.Editor editor;
                String key = hashKeyForDisk(imageUrl);
                try {
                    editor = diskLruCache.edit(key);
                } catch (Exception e) {
                    break;
                }
                if (editor == null) {
                    break;
                }
                OutputStream outputStream;
                try {
                    outputStream = editor.newOutputStream(0);
                } catch (Exception e) {
                    break;
                }
                if (downloadUrlToStream(imageUrl, outputStream)) {
                    try {
                        editor.commit();
                    } catch (Exception e) {
                        break;
                    }
                } else {
                    try {
                        editor.abort();
                    } catch (Exception e) {
                        break;
                    }
                }
                try {
                    diskLruCache.flush();
                } catch (Exception e) {
                    break;
                }
                result = getBitmap(diskLruCache, key);
            } while (false);
        }
        return result;
    }

}
