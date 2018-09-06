package com.zyh.zyhTest.designPatterns.strategy;

/**
 * Created by YatHong on 2018/9/5/0005.
 */
public class Strategy02 implements Strategy {
    @Override
    public double discount(double price) {
        System.out.println("开张大酬宾,买满500元,立减55");
        if (price < 500.00){
            throw new RuntimeException("满500元才能选择此活动哦");
        }
        return price - 55;
    }
}
