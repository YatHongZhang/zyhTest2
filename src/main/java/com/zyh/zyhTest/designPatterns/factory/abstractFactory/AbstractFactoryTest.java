package com.zyh.zyhTest.designPatterns.factory.abstractFactory;

import com.zyh.zyhTest.designPatterns.factory.Freezer;

/**
 * Created by YatHong on 2018/9/4/0004.
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        AbstractFactory factory = new MediaFactory();
        Freezer freezer = factory.createFreezer();
        Pool pool = factory.createPool();
        System.out.println(freezer.getFreezerName());
        System.out.println(pool.getPoolName());
    }
}
