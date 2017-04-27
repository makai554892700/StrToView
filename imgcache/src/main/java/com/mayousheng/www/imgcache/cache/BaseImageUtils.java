package com.mayousheng.www.imgcache.cache;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by marking on 2017/4/27.
 */

public abstract class BaseImageUtils {

    protected Bitmap getBitmap(DiskLruCache diskLruCache, String key) {
        if (diskLruCache == null || key == null) {
            return null;
        }
        Bitmap result = null;
        do {
            DiskLruCache.Snapshot snapShot;
            try {
                snapShot = diskLruCache.get(key);
            } catch (IOException e) {
                break;
            }
            if (snapShot != null) {
                InputStream is = snapShot.getInputStream(0);
                result = BitmapFactory.decodeStream(is);
            }
        } while (false);
        return result;
    }

    protected File getDiskCacheDir(Context context, String uniqueName) {
        if (context == null || uniqueName == null || uniqueName.isEmpty()) {
            return null;
        }
        String cachePath;
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                || !Environment.isExternalStorageRemovable()) {
            cachePath = context.getExternalCacheDir().getPath();
        } else {
            cachePath = context.getCacheDir().getPath();
        }
        return new File(cachePath + File.separator + uniqueName);
    }

    protected int getAppVersion(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return info.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            return 1;
        }
    }

    protected boolean downloadUrlToStream(String urlString, OutputStream outputStream) {
        if (outputStream == null || urlString == null || urlString.isEmpty()) {
            return false;
        }
        HttpURLConnection urlConnection = null;
        BufferedOutputStream out = null;
        BufferedInputStream in = null;
        try {
            URL url = new URL(urlString);
            urlConnection = (HttpURLConnection) url.openConnection();
            in = new BufferedInputStream(urlConnection.getInputStream(), 8 * 1024);
            out = new BufferedOutputStream(outputStream, 8 * 1024);
            int b;
            while ((b = in.read()) != -1) {
                out.write(b);
            }
            return true;
        } catch (final IOException e) {
            return false;
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            closeSilently(out);
            closeSilently(in);
        }
    }

    protected String hashKeyForDisk(String key) {
        if (key == null || key.isEmpty()) {
            return null;
        }
        String cacheKey;
        MessageDigest mDigest = null;
        try {
            mDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
        }
        if (mDigest == null) {
            cacheKey = String.valueOf(key.hashCode());
        } else {
            mDigest.update(key.getBytes());
            cacheKey = bytesToHexString(mDigest.digest());
        }
        return cacheKey;
    }

    private String bytesToHexString(byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(0xFF & bytes[i]);
            if (hex.length() == 1) {
                sb.append('0');
            }
            sb.append(hex);
        }
        return sb.toString();
    }

    private void closeSilently(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
            }
        }
    }

}
