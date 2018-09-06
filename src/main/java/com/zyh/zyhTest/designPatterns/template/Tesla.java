package com.zyh.zyhTest.designPatterns.template;

/**
 * Created by YatHong on 2018/9/5/0005.
 */
public class Tesla extends Car {
    @Override
    protected void startEngine() {
        System.out.println("指纹+虹膜识别+声控,启动");
    }

    @Override
    protected void run() {
        System.out.println("自动驾驶,走起");
    }

    @Override
    protected void supply() {
        System.out.println("到达充电桩,开始充电");
    }
}
