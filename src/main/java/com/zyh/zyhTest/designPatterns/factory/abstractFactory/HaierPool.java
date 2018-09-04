package com.zyh.zyhTest.designPatterns.factory.abstractFactory;

/**
 * Created by YatHong on 2018/9/4/0004.
 */
public class HaierPool implements Pool {

    @Override
    public String getPoolName() {
        return "海尔水槽";
    }
}
