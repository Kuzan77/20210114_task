package com.northsea.jdbc.util;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加密
 * @author ：mmzs
 * @date ：Created in 2021/1/23 20:17
 */
public class MyEncrypt {

    /**
     * MD5加密
     * @param message
     * @return
     */
    public static String md5(String message) {
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte[] bymd5 = md.digest(message.getBytes());
            BASE64Encoder base64 = new BASE64Encoder();   //以BASE64 显示，不然MD5后会查码
            return base64.encode(bymd5).toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}

