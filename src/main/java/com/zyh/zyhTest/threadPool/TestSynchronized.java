package com.zyh.zyhTest.threadPool;

/**
 * @author YatHong on 2019/4/3/0003
 */
public class TestSynchronized implements Runnable{

    @Override
    public void run(){
        print();
    }

    public synchronized void print()  {
        System.out.println("进来了");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("结束了");
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new TestSynchronized());
        Thread t2 = new Thread(new TestSynchronized());
        t1.start();
        t2.start();
        System.out.println("主线程结束");
    }
}
