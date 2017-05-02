package com.yiba.www.filecache.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by marking on 2017/5/2.
 */

public class MD5Utils {

    private static MD5Utils md5Utils;

    private MD5Utils() {
    }

    public static MD5Utils getInstance() {
        if (md5Utils == null) {
            md5Utils = new MD5Utils();
        }
        return md5Utils;
    }

    public String getMD5(String key) {
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

}
