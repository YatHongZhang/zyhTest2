package com.zyh.zyhTest.currentlimiting;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by YatHong on 2018/8/7/0007.
 */
public class Task implements Runnable {
    private int i ;
    private RateLimiter rateLimiter;
    private AtomicInteger success,fail;
    private int timeout;

    public Task(int i, RateLimiter rateLimiter, AtomicInteger success, AtomicInteger fail, int timeout) {
        this.i = i;
        this.rateLimiter = rateLimiter;
        this.success = success;
        this.fail = fail;
        this.timeout = timeout;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(rateLimiter.tryAcquire(timeout, TimeUnit.MILLISECONDS)){
            System.out.println("线程"+i+"成功");
            success.incrementAndGet();
        }else{
            System.out.println("线程"+i+"抢不到资源");
            fail.incrementAndGet();
        }
    }
}
