package com.zyh.zyhTest.currentlimiting;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by YatHong on 2018/7/31/0031.
 */
@Slf4j
public class TestRateLimiter {
    double count = 10;
    RateLimiter rateLimiter = RateLimiter.create(count);


    public void testSeveral(){
        int[] array = {10,5,3};
        log.info("每秒执行{}个",count);
        for(int i=0; i<array.length; i++){
            log.info("预支{},返回double:{}",array[i],rateLimiter.acquire(array[i]));
        }
    }

    public void testOne() throws Exception{
        long start = System.currentTimeMillis();
        log.info("每秒执行{}个",count);
        for(int i=0; i<10; i++){
            //rateLimiter.acquire();
            log.info("完成一个");
        }
        log.info("耗时:{}毫秒",System.currentTimeMillis()-start);

    }


    public static void main(String[] args) throws Exception{
        TestRateLimiter test = new TestRateLimiter();
        test.testOne();
    }
}
