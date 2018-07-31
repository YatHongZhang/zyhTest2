package com.zyh.zyhTest.jvm;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * Created by YatHong on 2018/7/24/0024.
 */
@Slf4j
public class TestTools {



    public static void main(String[] args){
        log.info("开始~~~~~~~~~~~~");
        for(Map.Entry<Thread, StackTraceElement[]> stackTrace : Thread.getAllStackTraces().entrySet()){
            Thread thread = stackTrace.getKey();
            /*if(thread.equals(Thread.currentThread())){
                continue;
            }*/
            log.info("线程:{}",thread.getName());
            StackTraceElement[] stack = stackTrace.getValue();
            for(StackTraceElement element : stack){
                log.info("{}",element);
            }
        }
    }
}
