package com.yiba.www.filecache.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by marking on 2017/2/13.
 */

public class SettingUtils {

    private static final String SETTING = "marking_setting";
    private static SettingUtils settingUtils;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor edit;

    private SettingUtils() {
    }

    public static SettingUtils getInstance() {
        if (settingUtils == null) {
            settingUtils = new SettingUtils();
        }
        return settingUtils;
    }

    public void init(Context context) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(SETTING, Context.MODE_PRIVATE);
            edit = sharedPreferences.edit();
        }
    }

    public void saveString(String key, String value) {
        edit.putString(key, value).commit();
    }

    public String getString(String key) {
        return sharedPreferences.getString(key, null);
    }

    public void saveBoolean(String key, boolean value) {
        edit.putBoolean(key, value).commit();
    }

    public boolean getBoolean(String key) {
        return sharedPreferences.getBoolean(key, false);
    }

    public void saveLong(String key, long value) {
        edit.putLong(key, value).commit();
    }

    public long getLong(String key) {
        return sharedPreferences.getLong(key, 0L);
    }
}
