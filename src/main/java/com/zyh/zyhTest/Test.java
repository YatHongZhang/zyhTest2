package com.zyh.zyhTest;


import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by YatHong on 2018/6/4/0004.
 */
public class Test {

    public static void main(String[] args) throws Exception{
        new Test().write2Console();
        System.out.println(2/0);

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
