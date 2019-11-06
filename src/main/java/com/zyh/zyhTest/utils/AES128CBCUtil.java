package com.zyh.zyhTest.utils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.UUID;

/**
 * 不需要另外的包, 有16进制转换
 */
public class AES128CBCUtil {
    /**
     * 填充方式
     */
    private static final String PADDING = "AES/CBC/PKCS5PADDING";

    private static final int LENGTH = 128;

    /**
     * 字符串转换成十六进制字符串
     */
    public static String str2HexStr(String str) {
        char[] chars = "0123456789ABCDEF".toCharArray();
        StringBuilder sb = new StringBuilder("");
        byte[] bs = str.getBytes();
        int bit;
        for (int i = 0; i < bs.length; i++) {
            bit = (bs[i] & 0x0f0) >> 4;
            sb.append(chars[bit]);
            bit = bs[i] & 0x0f;
            sb.append(chars[bit]);
        }
        return sb.toString();
    }


    /**
     * 十六进制字符串转字节数组
     */
    public static byte[] hexStr2Bytes(String hexStr) {
        System.out.println("in len :" + hexStr.length());
        String str = "0123456789ABCDEF";
        char[] hexs = hexStr.toCharArray();
        byte[] bytes = new byte[hexStr.length() / 2];
        int n;
        for (int i = 0; i < bytes.length; i++) {
            n = str.indexOf(hexs[2 * i]) * 16;
            n += str.indexOf(hexs[2 * i + 1]);
            bytes[i] = (byte) (n & 0xff);
        }
        System.out.println("out len :" + bytes.length);
        System.out.println("ddd" + Arrays.toString(bytes));
        return bytes;
    }


    /**
     * 字节数组转换成十六进制字符串
     */
    public static String byte2HexStr(byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;
            }
            else{
                hs = hs + stmp;
            }
            // if (n<b.length-1) hs=hs+":";
        }
        return hs.toUpperCase();
    }

    /**
     *
     * @param key 密钥
     * @param initVector 初始向量
     * @param value
     * @return
     */
    public static String encrypt(String key, String initVector, String value) {
        try {
            //System.out.println("key:\t" + Arrays.toString(key.getBytes("UTF-8")));
            //System.out.println("iv:\t" + Arrays.toString(initVector.getBytes("UTF-8")));
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(LENGTH, new SecureRandom(key.getBytes()));
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec skeySpec = new SecretKeySpec(enCodeFormat, "AES");


            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            //SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");


            Cipher cipher = Cipher.getInstance(PADDING);
            //Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(value.getBytes());
            //System.out.println(Arrays.toString(encrypted));
            //System.out.println("encrypted string: "
            //        + Base64.encodeBase64String(encrypted));

            return byte2HexStr(encrypted);
            //return Base64.encodeBase64String(encrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }


    public static String decrypt(String key, String initVector, String encrypted) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            kgen.init(128, new SecureRandom(key.getBytes()));
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            //SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
            SecretKeySpec skeySpec = new SecretKeySpec(enCodeFormat, "AES");


            Cipher cipher = Cipher.getInstance(PADDING);
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);


            //byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));
            byte[] original = cipher.doFinal(hexStr2Bytes(encrypted));


            return new String(original);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {
        //String key = "17b8b383-db07-43bd-9969-f5ca17c6b36c"; // 128 bit key
        //String initVector = "dc8a8df1e9ea4ce4"; // 16 bytes IV
        String key = "c07840c3-53c9-4f2d-8490-602833a1aa88"; // 128 bit key
        String initVector = "55c0c3cb1aa2432a"; // 16 bytes IV
        String originText = "你好世界hello world, cryptopp";

        String en = encrypt(key, initVector, originText);
        System.out.println("加密后:"+en);
        System.out.println("解密后:"+decrypt(key, initVector, en));
        System.out.println(UUID.randomUUID().toString());
    }
}

