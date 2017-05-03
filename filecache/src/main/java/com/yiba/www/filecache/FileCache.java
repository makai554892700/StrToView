package com.yiba.www.filecache;

import android.content.Context;
import android.util.Log;

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
    private final HashMap<String, ArrayList<CallBack>> loadingFiles = new HashMap<String, ArrayList<CallBack>>();
    private File rootFile;

    private FileCache() {
    }

    public static FileCache getInstance() {
        if (fileCache == null) {
            fileCache = new FileCache();
        }
        return fileCache;
    }

    public void init(Context context) {
        if (rootFile == null) {
            rootFile = FileUtils.getInstance().getRootFile(context);
            SettingUtils.getInstance().init(context);
        }
    }

    public String getFilePathNow(String url) {
        final String key = getKey(url);
        if (key == null) {
            return null;
        }
        final File tempFile = new File(rootFile, key);
        if (tempFile.exists() && SettingUtils.getInstance().getBoolean(key)) {
            return tempFile.getAbsolutePath();
        } else {
            while (loadingFiles.containsKey(key)) {
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                }
            }
            addLoadingFile(key, callBackToCallBacks(new CallBack() {
                @Override
                public void onFail(int code) {
                }

                @Override
                public void onSucceed(byte[] data, File file) {
                }
            }));
            if (tempFile.exists()) {
                tempFile.delete();
            }
            byte[] result;
            try {
                tempFile.createNewFile();
            } catch (Exception e) {
                delLoadingFile(key, null, tempFile, FAIL_ERROR1);
                return null;
            }
            result = FileUtils.getInstance().urlToByteSave(tempFile, url);
            delLoadingFile(key, result, tempFile, FAIL_ERROR1);
            if (result != null) {
                return tempFile.getAbsolutePath();
            }
        }
        return null;
    }

    public byte[] getFileNow(String url) {
        final String key = getKey(url);
        if (key == null) {
            return null;
        }
        byte[] result;
        final File tempFile = new File(rootFile, key);
        if (tempFile.exists() && SettingUtils.getInstance().getBoolean(key)) {
            result = FileUtils.getInstance().fileToBytes(tempFile);
        } else {
            while (loadingFiles.containsKey(key)) {
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                }
            }
            addLoadingFile(key, callBackToCallBacks(new CallBack() {
                @Override
                public void onFail(int code) {
                }

                @Override
                public void onSucceed(byte[] data, File file) {
                }
            }));
            if (tempFile.exists()) {
                tempFile.delete();
            }
            try {
                tempFile.createNewFile();
                result = FileUtils.getInstance().urlToByteSave(tempFile, url);
            } catch (Exception e) {
                result = null;
            }
            delLoadingFile(key, result, tempFile, FAIL_ERROR1);
        }
        return result;
    }

    public void getFile(final String url, CallBack callBack) {
        final String key = getKey(url);
        if (key == null) {
            if (callBack != null) {
                callBack.onFail(FAIL_ERROR1);
            }
            return;
        }
        final File tempFile = new File(rootFile, key);
        if (tempFile.exists() && SettingUtils.getInstance().getBoolean(key)) {
            delLoadingFile(key, FileUtils.getInstance().fileToBytes(tempFile), tempFile, FAIL_ERROR3);
        } else {
            if (loadingFiles.containsKey(key)) {
                addLoadingFile(key, callBackToCallBacks(callBack));
            } else {
                addLoadingFile(key, callBackToCallBacks(callBack));
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

    private String getKey(String url) {
        if (url == null || url.isEmpty() || !url.startsWith(HTTP)) {
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
