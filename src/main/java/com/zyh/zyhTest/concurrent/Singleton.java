package com.zyh.zyhTest.concurrent;

/**
 * Created by YatHong on 2018/8/29/0029.
 * 单例模式用到volatile
 */
public class Singleton {

    private static volatile Singleton singleton;

    private Singleton(){}

    public static Singleton getInstance(){
        if(singleton == null){
            synchronized(Singleton.class){
                if(singleton == null){//二次校验
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
