package com.zyh.zyhTest.controller;

import com.zyh.zyhTest.Constants.ApiUrls;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/6/23/0023.
 */
@RestController
@Slf4j
public class HelloController {

    @RequestMapping(value = ApiUrls.LOGIN_LOGIN, method = RequestMethod.POST)
    public String say(){
        System.out.println("/say~~~~~~~~~~~");
        return "hello";
    }

    @RequestMapping("/hello/say2")
    @ResponseBody
    public String say2(){
        System.out.println("/say2~~~~~~~~~~~");
        return "hello";
    }
}
