package com.zyh.zyhTest;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Throwables;
import com.seebon.shabao.commons.CommonConstants;
import com.seebon.shabao.commons.utils.MessageDigestUtil;
import lombok.Data;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by YatHong on 2018/6/4/0004.
 */
public class Test {
    public static void main(String[] args) throws Exception{
        /*JSONObject jsonObject = new JSONObject();
        jsonObject.put("productCode","SB-PASF1");
        jsonObject.put("productName","顺丰方案一");
        jsonObject.put("companyId","3ab91e09516f4dee990936cd991c0b19");
        jsonObject.put("effectDate","2018-06-12");
        jsonObject.put("operatorName","1010284");
        String str = "shangbaozengyuan!!" + jsonObject.toString();
        System.out.println(str);
        String encode = URLEncoder.encode(str,"UTF-8");
        System.out.println(encode);
        String decode = URLDecoder.decode(encode,"UTF-8");
        System.out.println(decode);*/

        /*System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));*/


        /*String str ="shangbaozengyuan!!{\"companyId\":\"d03b7a6b7!!791484dba06c4947f08c269\",\"effectDate\":\"2018-06-15\",\"productCode\":\"月付员工报销0611_30005001\",\"operatorName\":\"1011570\",\"productName\":\"月付员工报销0611\"}";
        *//*String arr[] = str.split("\\!\\!");
        System.out.println(arr.length);*//*
        int index = str.indexOf("!!");
        System.out.println(index);
        String type = str.substring(0,index);
        String param = str.substring(index+2);
        System.out.println(type);
        System.out.println(param);*/

        /*String param = "{\"sysType\":\"ios\",\"sysVersion\":\"10.1.1\",\"appType\":\"01\",\"appVersion\":\"1.0.0\",\"signType\":\"SHA256\",\"sign\":\"\",\"token\":\"\",\"traceLogId\":\"98cvb6sf21btg8b49a65d1fr32b16g54\",\"custId\":\"\",\"deviceName\":\"iPhone7\",\"imsi\":\"xxx\",\"imei\":\"xxx\",\"mtMac\":\"xxxxxxxx\",\"wifiMac\":\"xxx\",\"locInfo\":\"xxx\",\"baseVersion\":\"xxx\",\"kernelVersion\":\"xxx\",\"operaDesc\":\"xxx\",\"aiDentifier\":\"xxx\",\"phoneNum\":\"13412345678\",\"timeStamp\":\"2018-06-27 2018-06-27 09:09:09\"}";
        try{
            String sign = MessageDigestUtil.encrypt(param + "Se^#4%e-b8#o)&nS^5h@^a!b%7*a_%^o", CommonConstants.MESSAGE_DIGEST_SHA256);
            System.out.println(sign);
        }catch (Exception e){
            System.out.println(Throwables.getStackTraceAsString(e));
        }*/

        /*String str = "2018-06-27 10:18:00";
        String[] arr = str.split(" ");
        String[] date = arr[0].split("-");
        String[] time = arr[1].split(":");
        long systemTime = System.currentTimeMillis();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR,Integer.parseInt(date[0]));
        cal.set(Calendar.MONTH,Integer.parseInt(date[1])-1);
        cal.set(Calendar.DATE,Integer.parseInt(date[2]));
        cal.set(Calendar.HOUR,Integer.parseInt(time[0]));
        cal.set(Calendar.MINUTE,Integer.parseInt(time[1]));
        cal.set(Calendar.SECOND,Integer.parseInt(time[2]));
        long timeFromApp = cal.getTimeInMillis();
        System.out.println(Math.abs(systemTime - timeFromApp)/1000);*/

        /*String str = "地方的呵呵kkkasd343啊啊啊.pdf";
        System.out.println(str.lastIndexOf(".pdf"));
        if(str.lastIndexOf(".pdf") != -1){
            str = str.substring(0,str.length()-4);
        }

        System.out.println(str);*/





    }


}
