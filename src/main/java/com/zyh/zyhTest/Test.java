package com.zyh.zyhTest;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Throwables;
import com.seebon.shabao.commons.CommonConstants;
import com.seebon.shabao.commons.utils.MessageDigestUtil;
import lombok.Data;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by YatHong on 2018/6/4/0004.
 */
public class Test {
    public static void main(String[] args) throws Exception{
        System.out.println("准备开始了昂");
        String str = "asdf";
        String str2 = new String("asdf");
        System.out.println(str);
        System.out.println(str2);
        System.out.println(str == str2);


    }


}
