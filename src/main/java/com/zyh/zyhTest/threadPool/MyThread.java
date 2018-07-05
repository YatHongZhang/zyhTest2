package com.zyh.zyhTest.threadPool;

import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by YatHong on 2018/6/28/0028.
 */
@Slf4j
public class MyThread implements Runnable {


    public MyThread(){

    }

    @Override
    public void run() {
        try {
            log.info("启动");
            Thread.sleep(200);
        }catch (Exception e){
            log.error(Throwables.getStackTraceAsString(e));
        }
    }
}
