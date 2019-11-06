package com.zyh.zyhTest;


import com.seebon.shabao.commons.utils.MessageDigestUtil;
import com.zyh.zyhTest.utils.GroupEnum;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.math.BigDecimal;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by YatHong on 2018/6/4/0004.
 */
public class Test {

    public static void main(String[] args) throws Exception{
        System.out.println((new BigDecimal(0.0).setScale(2, BigDecimal.ROUND_HALF_UP)).toString());
        System.out.println((new BigDecimal(333).setScale(2, BigDecimal.ROUND_HALF_UP)).toString());
        System.out.println((new BigDecimal(41.2).setScale(2, BigDecimal.ROUND_HALF_UP)).toString());
        System.out.println((new BigDecimal(993.29).setScale(2, BigDecimal.ROUND_HALF_UP)).toString());
        System.out.println((new BigDecimal(1426.095).setScale(2, BigDecimal.ROUND_HALF_UP)).toString());
    }

    public void testCloseStream() throws Exception{
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128, new SecureRandom("asdfasdfasdfasdf".getBytes()));
        SecretKey secretKey = kgen.generateKey();
        byte[] enCodeFormat = secretKey.getEncoded();
        SecretKeySpec skeySpec = new SecretKeySpec(enCodeFormat, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.ENCRYPT_MODE,secretKey);

        InputStream in = new FileInputStream("D:\\aaa.txt");
        CipherInputStream cipherInputStream = new CipherInputStream(in,cipher);
        cipherInputStream.close();
        in.close();
    }

    public void testLength(){
        String str = "你好机器人好了好了我知道了";
        System.out.println(str.length());
        System.out.println(str.getBytes().length);
    }

    public void testEnum(){
        String str = "gg";
        GroupEnum ee = GroupEnum.valueOf(str);
        System.out.println(ee.toString());
        System.out.println(GroupEnum.Gj.toString());
        System.out.println(ee.name());
        System.out.println(GroupEnum.Gj.name());
        System.out.println(ee.getGroupId());
        System.out.println(ee.getGroupIdCn());
    }


    public void testReplace(){
        String str ="https://api.tongdun.cn/adssdfdfdf";
        System.out.println(str);
        str = str.replaceAll("https://api.tongdun.cn","http://11.111.11.1:8883/cs-api-tong");
        System.out.println(str);
    }

    public List<Boolean> solute(int[] a){
        List<Boolean> list = new ArrayList<>(a.length);
        int num=0;
        for (int i=0; i<a.length; i++){
            num = num << 1;
            num = a[i] == 0 ? num%5 : (num+1)%5 ;
            list.add(num == 0 ? true : false);
        }
        return list;
    }


    public void xxxx() throws  Exception{
        DateTimeFormatter df = DateTimeFormat.forPattern("yyyy-MM-dd").withZoneUTC();
        Date date = df.parseDateTime("1988-04-10").toDate();
        //DateTime.parse("1988-04-10", df).toDate();
        System.out.println(date);


        DateTimeFormatter df2 = DateTimeFormat.forPattern("yyyy-MM-dd");
        Date date2 = df2.parseLocalDateTime("1988-04-10").toDate();
        System.out.println(date2);


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date3 = sdf.parse("1988-04-10");
        System.out.println(date3);
    }


    public void write2Console() {
        try {
            InputStream fis = new FileInputStream("E:\\projects\\zyhTest\\src\\main\\resources\\mybatis-config2.xml");
            int i=0;
            StringBuffer sb = new StringBuffer();
            while(i != -1){
                i = fis.read();
                char c = (char)i;
                sb.append(c);
            }
            System.out.println(sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }










}
