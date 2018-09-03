package com.zyh.zyhTest.concurrent;

/**
 * Created by YatHong on 2018/8/27/0027.
 * 对于非原子操作, volatile不能保证线程安全
 */
public class VolatileDemo {

    public static volatile int count = 0;


    public static void add() {
        try {
            Thread.sleep(1);
            count++;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        for(int i = 0; i<1000; i++){
            new Thread(() -> {
                add();
            }).start();
        }
        Thread.sleep(1000);
        System.out.println("final value:"+count);
    }
}
