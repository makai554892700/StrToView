package com.yiba.www.filecache.utils;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

/**
 * Created by marking on 2017/5/2.
 */

public class FileUtils {
    private static final String CACHE_FILE_PATH = "CacheFilePath";

    private static FileUtils fileUtils;

    private FileUtils() {
    }

    public static FileUtils getInstance() {
        if (fileUtils == null) {
            fileUtils = new FileUtils();
        }
        return fileUtils;
    }

    public byte[] fileToBytes(File file) {
        Log.e("-----1", "fileToBytes");
        return inputStreamToByte(fileToInputStream(file));
    }

    public byte[] urlToByteSave(File outFile, String urlStr) {
        Log.e("-----1", "urlToByteSave");
        OutputStream outputStream = fileOutputStream(outFile);
        if (outputStream == null) {
            return null;
        }
        byte[] result = inputStreamToByte(urlToInputStream(urlStr));
        if (result == null) {
            return null;
        }
        try {
            outputStream.write(result);
        } catch (Exception e) {
            Log.e("-----1", "e=" + e);
            return null;
        } finally {
            closeSilently(outputStream);
        }
        return result;
    }

    private OutputStream fileOutputStream(File file) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (Exception e) {
            Log.e("-----1", "e=" + e);
        }
        return fileOutputStream;
    }

    private InputStream fileToInputStream(File file) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
        } catch (Exception e) {
            Log.e("-----1", "e=" + e);
        }
        return inputStream;
    }

    private InputStream urlToInputStream(String urlStr) {
        InputStream inputStream = null;
        try {
            inputStream = new URL(urlStr).openStream();
        } catch (Exception e) {
            Log.e("-----1", "e=" + e);
        }
        return inputStream;
    }

    private byte[] inputStreamToByte(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] temp = new byte[1024];
        int len;
        byte[] result = null;
        try {
            while ((len = inputStream.read(temp)) != -1) {
                byteArrayOutputStream.write(temp, 0, len);
            }
            result = byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            Log.e("-----1", "e=" + e);
        } finally {
            closeSilently(inputStream);
            closeSilently(byteArrayOutputStream);
        }
        return result;
    }

    public File getRootFile(Context context) {
        if (context == null) {
            return null;
        }
        String cachePath;
        if (sdCardCanUse()) {
            cachePath = context.getExternalCacheDir().getPath();
        } else {
            cachePath = context.getCacheDir().getPath();
        }
        File result = new File(cachePath + File.separator + CACHE_FILE_PATH);
        if (!result.exists()) {
            result.mkdir();
        }
        return result;
    }

    private boolean sdCardCanUse() {
        return Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                || !Environment.isExternalStorageRemovable();
    }

    private void closeSilently(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                Log.e("-----1", "e=" + e);
            }
        }
    }

}
