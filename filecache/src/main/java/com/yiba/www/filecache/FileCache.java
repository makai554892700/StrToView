package com.yiba.www.filecache;

import android.content.Context;

import com.yiba.www.filecache.utils.FileUtils;
import com.yiba.www.filecache.utils.MD5Utils;
import com.yiba.www.filecache.utils.SettingUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by marking on 2017/5/2.
 */

public class FileCache {

    private static FileCache fileCache;
    private static final String HTTP = "http";
    private static final int FAIL_ERROR1 = 1;
    private static final int FAIL_ERROR2 = 2;
    private static final int FAIL_ERROR3 = 3;
    private static final HashMap<String, ArrayList<CallBack>> loadingFiles = new HashMap<String, ArrayList<CallBack>>();

    private FileCache() {
    }

    public static FileCache getInstance() {
        if (fileCache == null) {
            fileCache = new FileCache();
        }
        return fileCache;
    }

    public void getFile(Context context, final String url, CallBack callBack) {
        final String key = getKey(context, url);
        if (key == null) {
            if (callBack != null) {
                callBack.onFail(FAIL_ERROR1);
            }
            return;
        }
        if (loadingFiles.containsKey(key)) {
            addLoadingFile(key, callBackToCallBacks(callBack));
        } else {
            addLoadingFile(key, callBackToCallBacks(callBack));
            SettingUtils.getInstance().init(context);
            final File tempFile = new File(FileUtils.getInstance().getRootFile(context), key);
            if (tempFile.exists() && SettingUtils.getInstance().getBoolean(key)) {
                delLoadingFile(key, FileUtils.getInstance().fileToBytes(tempFile), tempFile, FAIL_ERROR3);
            } else {
                if (tempFile.exists()) {
                    tempFile.delete();
                }
                try {
                    tempFile.createNewFile();
                } catch (Exception e) {
                    delLoadingFile(key, null, tempFile, FAIL_ERROR2);
                    return;
                }
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        delLoadingFile(key, FileUtils.getInstance().urlToByteSave(tempFile, url), tempFile, FAIL_ERROR3);
                    }
                }).start();
            }
        }
    }

    private String getKey(Context context, String url) {
        if (context == null || url == null || url.isEmpty() || !url.startsWith(HTTP)) {
            return null;
        }
        return MD5Utils.getInstance().getMD5(url);
    }

    private void delLoadingFile(String key, byte[] data, File file, int code) {
        if (loadingFiles.containsKey(key)) {
            ArrayList<CallBack> callBacks = loadingFiles.get(key);
            loadingFiles.remove(key);
            for (CallBack callBack : callBacks) {
                if (data != null) {
                    callBack.onSucceed(data, file);
                } else {
                    callBack.onFail(code);
                }
            }
        }
        SettingUtils.getInstance().saveBoolean(key, data != null);
    }

    private void addLoadingFile(String key, ArrayList<CallBack> callBacks) {
        if (loadingFiles.containsKey(key)) {
            callBacks.addAll(loadingFiles.get(key));
        }
        loadingFiles.put(key, callBacks);
    }

    private ArrayList<CallBack> callBackToCallBacks(CallBack callBack) {
        ArrayList<CallBack> callBacks = new ArrayList<CallBack>();
        callBacks.add(callBack);
        return callBacks;
    }

    public static interface CallBack {
        public void onFail(int code);

        public void onSucceed(byte[] data, File file);
    }

}
