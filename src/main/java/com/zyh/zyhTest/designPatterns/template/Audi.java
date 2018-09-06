package com.zyh.zyhTest.designPatterns.template;

/**
 * Created by YatHong on 2018/9/5/0005.
 */
public class Audi extends Car {
    @Override
    protected void startEngine() {
        System.out.println("插入车钥匙,发动引擎");
    }

    @Override
    protected void run() {
        System.out.println("手动驾驶,走起");
    }

    @Override
    protected void supply() {
        System.out.println("到达加油站,开始加油");
    }
}
