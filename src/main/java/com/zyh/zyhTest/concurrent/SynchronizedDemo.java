package com.zyh.zyhTest.concurrent;

/**
 * Created by YatHong on 2018/8/31/0031.
 */
public class SynchronizedDemo {
    private static int count = 0;

    public void add(){
        synchronized(this){
            count ++;
        }
    }
}
