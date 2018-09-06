package com.zyh.zyhTest.designPatterns.strategy;

/**
 * Created by YatHong on 2018/9/5/0005.
 */
public class Strategy01 implements Strategy {
    @Override
    public double discount(double price) {
        System.out.println("开张大酬宾,全场95折");
        return price * 0.95;
    }
}
