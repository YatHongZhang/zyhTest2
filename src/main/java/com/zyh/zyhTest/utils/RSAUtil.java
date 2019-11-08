package com.zyh.zyhTest.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

import com.sun.deploy.net.URLEncoder;
import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.JDKKeyFactory;

/**
 * RSA加解密工具
 */
public class RSAUtil {

    public static final String KEY_ALGORITHM = "RSA";
    /**
     * 填充方式
     */
    public static final String CIPHER_ALGORITHM = "RSA/ECB/PKCS1Padding";
    //public static final String CIPHER_ALGORITHM = "RSA";
    //public static final String CIPHER_ALGORITHM = "RSA/ECB/OAEPWITHSHA-256ANDMGF1PADDING";
    /**
     * 指定位数
     */
    private static final int KEY_SIZE = 2048;
    /**
     * RSA最大解密密文字节数
     */
    private static final int MAX_DECRYPT_BLOCK = KEY_SIZE/8;
    /**
     * RSA最大加密明文字节数
     */
    private static final int MAX_ENCRYPT_BLOCK = MAX_DECRYPT_BLOCK - 11;



    /**
     * 获取密钥对
     * @return 密钥对
     */
    public static KeyPair getKeyPair() throws Exception {
        KeyPairGenerator generator = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        generator.initialize(KEY_SIZE);
        return generator.generateKeyPair();
    }

    /**
     * 私钥字符串获取PrivateKey对象
     * @param privateKey 私钥字符串
     * @return
     */
    public static PrivateKey getPrivateKey(String privateKey) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        byte[] decodedKey = Base64.decodeBase64(privateKey.getBytes());
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(decodedKey);
        return keyFactory.generatePrivate(keySpec);
    }

    /**
     * 公钥字符串获取PublicKey对象
     * @param publicKey 公钥字符串
     * @return
     */
    public static PublicKey getPublicKey(String publicKey) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        byte[] decodedKey = Base64.decodeBase64(publicKey.getBytes());
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(decodedKey);
        return keyFactory.generatePublic(keySpec);
    }

    /**
     * RSA加密
     * @param data 待加密数据
     * @param publicKey 公钥
     * @return
     */
    public static String encrypt(String data, PublicKey publicKey) {
        ByteArrayOutputStream out = null;

        try{
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);

            //编码 防止前端解密后有乱码
            data = URLEncoder.encode(data,"UTF-8");
            //加号替换为20%
            data = data.replaceAll("\\+","20%");

            int inputLen = data.getBytes().length;
            out = new ByteArrayOutputStream();
            int offset = 0;
            byte[] cache;
            int i = 0;
            // 对数据分段加密
            while (inputLen - offset > 0) {
                if (inputLen - offset > MAX_ENCRYPT_BLOCK) {
                    cache = cipher.doFinal(data.getBytes("UTF-8"), offset, MAX_ENCRYPT_BLOCK);
                } else {
                    cache = cipher.doFinal(data.getBytes("UTF-8"), offset, inputLen - offset);
                }
                out.write(cache, 0, cache.length);
                i++;
                offset = i * MAX_ENCRYPT_BLOCK;
            }
            byte[] encryptedData = out.toByteArray();
            // 获取加密内容使用base64进行编码, 返回加密后的字符串
            return Base64.encodeBase64String(encryptedData);
        }catch (Exception e){
            //do something...
            throw new RuntimeException(e);
        }finally {
            if(out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    //do something...
                }
            }
        }
    }

    /**
     * RSA解密
     * @param data 待解密数据
     * @param privateKey 私钥
     * @return
     */
    public static String decrypt(String data, PrivateKey privateKey)  {
        ByteArrayOutputStream out = null;
        try{
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, privateKey);

            //base64 decode
            byte[] dataBytes = Base64.decodeBase64(data);
            int inputLen = dataBytes.length;
            out = new ByteArrayOutputStream();
            int offset = 0;
            byte[] cache;
            int i = 0;
            // 对数据分段解密
            while (inputLen - offset > 0) {
                if (inputLen - offset > MAX_DECRYPT_BLOCK) {
                    cache = cipher.doFinal(dataBytes, offset, MAX_DECRYPT_BLOCK);
                } else {
                    cache = cipher.doFinal(dataBytes, offset, inputLen - offset);
                }
                out.write(cache, 0, cache.length);
                i++;
                offset = i * MAX_DECRYPT_BLOCK;
            }
            byte[] decryptedData = out.toByteArray();
            // 解密后的内容
            String str = new String(decryptedData, "UTF-8");
            // URLdecode
            return URLDecoder.decode(str,"UTF-8");
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            if (out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 签名
     * @param data 待签名数据
     * @param privateKey 私钥
     * @return 签名
     */
    public static String sign(String data, PrivateKey privateKey) throws Exception {
        byte[] keyBytes = privateKey.getEncoded();
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PrivateKey key = keyFactory.generatePrivate(keySpec);
        Signature signature = Signature.getInstance("MD5withRSA");
        signature.initSign(key);
        signature.update(data.getBytes());
        return new String(Base64.encodeBase64(signature.sign()));
    }

    /**
     * 验签
     * @param srcData 原始字符串
     * @param publicKey 公钥
     * @param sign 签名
     * @return 是否验签通过
     */
    public static boolean verify(String srcData, PublicKey publicKey, String sign) throws Exception {
        byte[] keyBytes = publicKey.getEncoded();
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PublicKey key = keyFactory.generatePublic(keySpec);
        Signature signature = Signature.getInstance("MD5withRSA");
        signature.initVerify(key);
        signature.update(srcData.getBytes());
        return signature.verify(Base64.decodeBase64(sign.getBytes()));
    }

    public static void main(String[] args) {
        try {
            // 生成密钥对
            KeyPair keyPair = getKeyPair();
            String privateKey = new String(Base64.encodeBase64(keyPair.getPrivate().getEncoded()));
            String publicKey = new String(Base64.encodeBase64(keyPair.getPublic().getEncoded()));
            //String privateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCLz3UP070Ogzr4ykwFP7EQMrSj63mgEPNcUaQ1uy8LFUxaIvfdxz0sfLCMf6DryMlBFNfZ9+jvbW9H0R2ngzgJ2UHu5o/lCHGhHC7ugzKuTj0t6+ZyCU3sr3+UfRrsJ/rgVadf4SSfEOsGrpbwBZ7rThm2qov0wmMrhZCi5QKn0E82DmHCxa4JvdoawQc3ey9EDan+0c8UzHsRa8GhfjVuWR+5TgzapIwXcZ3pRm2FfkhwnO6pRgaXakSwdCqbTWHArCk3jnoT1dRtaGnCEslQgaSPqbN54e9G+r+Gt1NK2d8auORF6myG9qQuH2LiA840MF1qnk986RFPcRdR3lsFAgMBAAECggEAHj1V5YF3r87kj3E59hyrkIRXG+lPmjZwXLRv3wtIho4pwIk1sWtpqNijWxAz3yvDk+cNNODxKfAylIb/cf7ovQCXyTNnRjOIWD9/SylnadoUU31lj57BkwL2hkh07UVMdv8vv4Yz5I/FNeHHVczxbZWr7B2BPgRZbM1r1j/QTjlnQbGVoHLE242YxgMPhgZPV11YRt/p5eSHDBv3qzW6WNWdWKyqrpqACWntOYbc1xoQK4Q8qMI2S3/9qWRZfOxQv8kNEHA0Pt/XZ0weyLBR6A1PbRbF07lgIl+QhPHyDQDzi9l8djFXITMHXN6xe/paEezzVuAyAhkrZCRlpWPN4QKBgQC9VU8MUtSqjvDcI8CzeUxA05Mo+Zoqp8vq8SgrufogQzpnK0J78l7lT8RgOscIy2aSK+9pGSaXqNo0FNvoGIWlVOJKH6GhByFGVMFctWdGO3GlrNlQ06l4Yf2TacwVB4FzuCwCW6FRAEKJYyNeiJBI+g63vO3p+3QjiSwPyd6h2QKBgQC9ChuKySspQVyilqeEQBwWl7FADgJVWD5dgrDHteXnSTVmpc/V1lpx64bC/fpbbTstReFno0AoMjpwjbA6QKXvBfO4F9kdMD7oTaYqISXpZz/dLcueeRXGF4tTAUK+auDswIimnK97z+pv22+hZ6GbzAmaxfz0bUxylPOjEUhbDQKBgCu3MtVJmsj20C5EIw5Nh4nAUE45s5r9u1u36uqNum8Qlr+TgXpU8AxKarE9YQ9qx3ggpNrDb+G8nwU/e7cPUmxmOQmcXBluKASxNSROzlWtDASQ8Gx1MsAVABO1beW9IeqyL5cryQeG49YNCfGd3pK7CgLqoJRR9vLtjTroBXuhAoGBALf6LE/n9O+TwzohcSsO0cdTHph+idrRpPCRDsduyi9MWoJqAVnV4fRZCrCfSZbNOfiXuAWLJhd4utNrsgUfgd6cZlPWMeFsYOzpFTyPQjxj1g3GUhMLORuvMlM4OOLlVb5Uqymr+EWBVmJCp+Pn3aqo6vgMlGC2Nt6VBIDBgy/JAoGAKw6fmqoSIYBNe53wnqaIF7XKyHzZBaX59FTqSLZXTwr0GeGHzyYrbouUZlPJn8IYV0GgcOXaPB9JQDvN7JcWsMXHBr1s6N2X7q5qhw80ZR7MFBDTlaNQ/rspTvnzq+971T4rfbs4lKBxo8o5LimFE1nmWcybcfZYA/rjdetLK1c=";
            //String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAi891D9O9DoM6+MpMBT+xEDK0o+t5oBDzXFGkNbsvCxVMWiL33cc9LHywjH+g68jJQRTX2ffo721vR9Edp4M4CdlB7uaP5QhxoRwu7oMyrk49LevmcglN7K9/lH0a7Cf64FWnX+EknxDrBq6W8AWe604ZtqqL9MJjK4WQouUCp9BPNg5hwsWuCb3aGsEHN3svRA2p/tHPFMx7EWvBoX41blkfuU4M2qSMF3Gd6UZthX5IcJzuqUYGl2pEsHQqm01hwKwpN456E9XUbWhpwhLJUIGkj6mzeeHvRvq/hrdTStnfGrjkRepshvakLh9i4gPONDBdap5PfOkRT3EXUd5bBQIDAQAB";
            System.out.println("私钥:" + privateKey);
            System.out.println("公钥:" + publicKey);
            // RSA加密
            String data = "待加密的文字内容待加密的文字内容待加密的文字内容待加密的文字内容待加密的文字内容待加密的文字内容待加密的文字内容待加密的文字内容待加密的文字内容待加密的文字内容待加密的文字内容待加密的文字内容待加密的文字内容待加密的文字内容待加密的文字内容待加密的文字内容待加密的文字内容待加密的文字内容待加密的文字内容待加密的文字内容待加密的文字内容待加密的文字内容待加密的文字内容待加密的文字内容待加密的文字内容待加密的文字内容待加密的文字内容待加密的文字内容待加密的文字内容待加密的文字内容待加密的文字内容待加密的文字内容待加密的文字内容待加密的文字内容待加密的文字内容待加密的文字内容待加密的文字内容待加密的文字内容待加密的文字内容待加密的文字内容待加密的文字内容";
            System.out.println("加密前字节数:" + data.getBytes().length);
            String encryptData = encrypt(data, getPublicKey(publicKey));
            System.out.println("加密后内容:" + encryptData);
            // RSA解密
            String decryptData = decrypt(encryptData, getPrivateKey(privateKey));
            System.out.println("解密后内容:" + decryptData);

            // RSA签名
            String sign = sign(data, getPrivateKey(privateKey));
            // RSA验签
            boolean result = verify(data, getPublicKey(publicKey), sign);
            System.out.print("验签结果:" + result);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("加解密异常");
        }
    }



}
