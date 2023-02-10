package com.wuxin.utils;

import org.springframework.util.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author: wuxin001
 * @date: 2022/7/20 3:31
 * @Description: 密码加密
 */
public class MD5Util {

    public static String getMD5Str(String str) {
        byte[] digest = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            digest = md5.digest(str.getBytes("utf-8"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //16是表示转换为16进制数
        String md5Str = new BigInteger(1, digest).toString(16);
        return md5Str;
    }

    /**
     * spring 封装
     */
    public static String md5DigestAsHex(String str) {
        return StringUtil.isEmpty(str) ? null : DigestUtils.md5DigestAsHex(str.getBytes());
    }


}
