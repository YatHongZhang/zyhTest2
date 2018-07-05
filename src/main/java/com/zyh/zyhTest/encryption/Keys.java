package com.zyh.zyhTest.encryption;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

/**
 * 生成RSA公钥私钥
 */
public class Keys {
    public static final String KEY_ALGORITHM = "RSA";
    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";
    /** 貌似默认是RSA/NONE/PKCS1Padding，未验证 */
    public static final String CIPHER_ALGORITHM = "RSA/ECB/PKCS1Padding";
    private static final String PUBLIC_KEY = "RSAPublicKey";
    private static final String PRIVATE_KEY = "RSAPrivateKey";

    /**
     * 生成公钥私钥
     */
    public static Map<String, Object> initKey() throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        keyPairGen.initialize(1024);
        KeyPair keyPair = keyPairGen.generateKeyPair();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        Map<String, Object> keyMap = new HashMap<String, Object>(2);
        keyMap.put(PUBLIC_KEY, publicKey);
        keyMap.put(PRIVATE_KEY, privateKey);
        return keyMap;
    }

    /**
     * 密钥转为String
     */
    public static String getKeyString(Key key) throws Exception {
        byte[] publicKey = key.getEncoded();
        return encryptBASE64(publicKey);
    }



    /**
     * 字节数组转为公钥, X509EncodedKeySpec 用于构建公钥的规范
     */
    public static PublicKey restorePublicKey(byte[] keyBytes) throws InvalidKeySpecException, NoSuchAlgorithmException {
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes);
        try {
            KeyFactory factory = KeyFactory.getInstance(KEY_ALGORITHM);
            PublicKey publicKey = factory.generatePublic(x509EncodedKeySpec);
            return publicKey;
        } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 字节数组转为私钥  PKCS8EncodedKeySpec 用于构建私钥的规范
     */
    public static PrivateKey restorePrivateKey(byte[] keyBytes) throws InvalidKeySpecException, NoSuchAlgorithmException {
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);
        try {
            KeyFactory factory = KeyFactory.getInstance(KEY_ALGORITHM);
            PrivateKey privateKey = factory.generatePrivate(pkcs8EncodedKeySpec);
            return privateKey;
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * BASE64解码
     */
    public static byte[] decryptBASE64(String key) throws Exception {
        return (new BASE64Decoder()).decodeBuffer(key);
    }

    /**
     * BASE64编码
     */
    public static String encryptBASE64(byte[] key) throws Exception {
        return (new BASE64Encoder()).encodeBuffer(key);
    }

    /**
     * 加密
     */
    public static byte[] RSAEncode(PublicKey key, byte[] plainText) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        try {
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            return cipher.doFinal(plainText);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException
                | InvalidKeyException | IllegalBlockSizeException
                | BadPaddingException e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 解密
     */
    public static String RSADecode(PrivateKey key, byte[] encodedText) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        try {
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key);
            return new String(cipher.doFinal(encodedText));
        } catch (NoSuchAlgorithmException | NoSuchPaddingException
                | InvalidKeyException | IllegalBlockSizeException
                | BadPaddingException e) {
            e.printStackTrace();
            throw e;
        }
    }


    /**
     * 例子
     * 生成公钥私钥,并对字符串加解密
     */
    private void test1(){
        Map<String, Object> keyMap;
        try {
            keyMap = initKey();
            RSAPublicKey rsaPublicKey = (RSAPublicKey)keyMap.get(PUBLIC_KEY);
            RSAPrivateKey rsaPrivateKey = (RSAPrivateKey)keyMap.get(PRIVATE_KEY);

            String text = "红红火火恍恍惚惚哈哈哈哈";
            System.out.println("加密前:"+text);
            byte[] encryptText = RSAEncode(rsaPublicKey,text.getBytes());
            System.out.println("加密后:"+encryptText);
            String decrypText = RSADecode(rsaPrivateKey,encryptText);
            System.out.println("解密后:"+decrypText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 例子
     * 生成公钥私钥, 转为String
     */
    private void test2(){
        Map<String, Object> keyMap;
        try {
            keyMap = initKey();
            System.out.println("公钥String:");
            System.out.println(getKeyString((PublicKey) keyMap.get(PUBLIC_KEY)));
            System.out.println("私钥String:");
            System.out.println(getKeyString((PrivateKey) keyMap.get(PRIVATE_KEY)));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 例子
     * 生成公钥私钥,转为String,再从String转为公钥私钥
     */
    public void test3(){
        Map<String, Object> keyMap;
        try {
            keyMap = initKey();
            String publicKeyString = getKeyString((PublicKey) keyMap.get(PUBLIC_KEY));
            String privateKeyString = getKeyString((PrivateKey) keyMap.get(PRIVATE_KEY));
            System.out.println(publicKeyString);
            System.out.println(privateKeyString);

            PublicKey publickey = restorePublicKey(decryptBASE64(publicKeyString));
            PrivateKey privateKey = restorePrivateKey(decryptBASE64(privateKeyString));
            String publicKeyString2 = getKeyString(publickey);
            String privateKeyString2 = getKeyString(privateKey);
            System.out.println(publicKeyString2);
            System.out.println(privateKeyString2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new Keys().test3();
    }

}
