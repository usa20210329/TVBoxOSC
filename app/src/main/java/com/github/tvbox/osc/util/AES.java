package com.github.tvbox.osc.util;

import android.annotation.TargetApi;
import android.os.Build;
import android.util.Base64;

import com.github.catvod.crawler.SpiderDebug;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.spec.AlgorithmParameterSpec;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES {

    public static String rightPadding(String key, String replace, int Length) {
        String strReturn = "";
        String strtemp = "";
        int curLength = key .trim().length();
        if (key  != null && curLength > Length) {
            strReturn = key .trim().substring(0, Length);
        } else if (key  != null && curLength == Length) {
            strReturn = key .trim();
        } else {
            for (int i = 0; i < (Length - curLength); i++) {
                strtemp = strtemp + replace;
            }
            strReturn = key .trim() + strtemp;
        }
        return strReturn;
    }

    public static String ECB(String data, String key) {
        try {
            key = rightPadding(key, "0", 16);
            byte[] data2 = toBytes(data);
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding");
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            return new String(cipher.doFinal(data2));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String CBC(String data, String key, String iv) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
            AlgorithmParameterSpec paramSpec = new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, keySpec, paramSpec);
            return new String(cipher.doFinal(toBytes(data)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean isJson(String content) {
        try {
            new JSONObject(content);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static byte[] toBytes(String src) {
        int l = src.length() / 2;
        byte[] ret = new byte[l];
        for (int i = 0; i < l; i++) {
            ret[i] = Integer.valueOf(src.substring(i * 2, i * 2 + 2), 16).byteValue();
        }
        return ret;
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public static byte[] decodeSpider(String data) {

        try {
            int startedPoint = data.indexOf("**");
            if (startedPoint > 0) {
                return Base64.decode(data.substring(startedPoint + 2), 0);
            }
            return data.getBytes(StandardCharsets.UTF_8);
        }catch (Exception ex) {
            SpiderDebug.log("Failed to decrypt jar: " + ex.getMessage());
        }
        return null;
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private static String getMD5(String data) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(data.getBytes(StandardCharsets.UTF_8));
        byte[] digest = md.digest();
        return String.format("%032x", new BigInteger(1, digest)).toLowerCase();
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len/2];

        for(int i = 0; i < len; i+=2){
            data[i/2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i+1), 16));
        }

        return data;
    }
}
