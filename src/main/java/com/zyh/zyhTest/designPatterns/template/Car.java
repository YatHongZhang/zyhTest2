package com.zyh.zyhTest.designPatterns.template;

/**
 * Created by YatHong on 2018/9/5/0005.
 * 开车去加油
 */
public abstract class Car {

    protected abstract void startEngine();

    protected abstract void run();

    protected abstract void supply();

    protected void goSupply(){
        startEngine();
        run();
        supply();
    }
}
