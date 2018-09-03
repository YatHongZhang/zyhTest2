package com.zyh.zyhTest.currentlimiting;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by YatHong on 2018/7/31/0031.
 */
@Slf4j
public class TestRateLimiter {
    double numPerSecond = 200;
    int count = 1000;
    int timeout = 3000;
    RateLimiter rateLimiter = RateLimiter.create(numPerSecond);


    public void testTryAcquire() throws Exception{
        AtomicInteger success = new AtomicInteger(0), fail = new AtomicInteger(0);
        Thread.sleep(5000);
        List<Task> list = new ArrayList<>();
        for(int i=0; i<count; i++){
            list.add(new Task(i,rateLimiter,success,fail,timeout));
        }
        ThreadPoolExecutor pool = (ThreadPoolExecutor)Executors.newCachedThreadPool();
        for (Task task : list) {
            pool.execute(task);
        }
        Thread.sleep(timeout+1000);
        pool.shutdown();
        log.info("每秒执行{}个,共有{}个需要执行,超时时间{}毫秒,成功{}个,失败{}个", numPerSecond, count, timeout, success, fail);
    }


    /**
     * 预处理
     */
    public void testSeveral() throws Exception{
        int[] array = {30,40,10};
        log.info("每秒执行{}个", numPerSecond);
        for(int i=0; i<array.length; i++){
            if(i == 1){
                log.info("停5秒");
                Thread.sleep(5000);
            }
            log.info("预支{},返回double:{}",array[i],rateLimiter.acquire(array[i]));
        }
    }


    /**
     * 一个一个处理
     */
    public void testOne() throws Exception{
        long start = System.currentTimeMillis();
        double dd ;
        log.info("每秒执行{}个", numPerSecond);
        for(int i=0; i<50; i++){
            if(i==5){
                log.info("停一会");
                Thread.sleep(5000);
            }
            dd = rateLimiter.acquire();
            log.info("完成{}个,{}", i+1, dd);
        }
        log.info("耗时:{}毫秒",System.currentTimeMillis() - start);
    }

    public static void main(String[] args) throws Exception{
        TestRateLimiter test = new TestRateLimiter();
        test.testTryAcquire();
        log.info("主线程执行完毕");
    }
}
