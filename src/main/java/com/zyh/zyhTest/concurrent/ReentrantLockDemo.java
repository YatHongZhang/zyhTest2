package com.zyh.zyhTest.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by YatHong on 2018/8/29/0029.
 */
public class ReentrantLockDemo {
    private static ReentrantLock lock = new ReentrantLock();

    public static void testLock(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+" 到此一游");

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        for(int i=0; i<10; i++){
            new Thread(()->{
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                testLock();
            },"t-"+i).start();
        }
    }


}
