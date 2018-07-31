package com.zyh.zyhTest.jvm;

/**
 * Created by YatHong on 2018/7/19/0019.
 */
public class TestGC {

    private final static int _1MB = 1024 * 1024;

    public void allocate(){
        Byte[] a1,a2,a3,a4;
        System.out.println("分配a1");
        a1 = new Byte[2 * _1MB];
        System.out.println("分配a2");
        a2 = new Byte[2 * _1MB];
        System.out.println("分配a3");
        a3 = new Byte[2 * _1MB];
        System.out.println("分配a4");
        a4 = new Byte[4 * _1MB];
    }

    public static void main(String[] a) throws Exception{
        System.out.println("启动啦~~~~~~~~~~~");
        Thread.sleep(10000);
        new TestGC().allocate();
        Thread.sleep(15000);
        System.out.println("结束啦~~~~~~~~~~~");
    }
}
