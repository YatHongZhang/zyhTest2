package com.zyh.zyhTest.designPatterns.singleton;

/**
 * Created by YatHong on 2018/9/4/0004.
 * 饿汉式, 程序启动就创建实例
 */
public class Singleton2 {

    private static Singleton2 inst = new Singleton2();

    private Singleton2(){}

    public static Singleton2 getInstance(){
        return inst;
    }

}
