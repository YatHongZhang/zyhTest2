package com.zyh.zyhTest.designPatterns.singleton;

/**
 * Created by YatHong on 2018/9/4/0004.
 * 懒汉式,被调用时才创建实例
 */
public class Singleton {

    private static volatile Singleton instance ;

    private Singleton(){}

    public static Singleton getInstance(){
        if(instance == null){
            synchronized(Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
