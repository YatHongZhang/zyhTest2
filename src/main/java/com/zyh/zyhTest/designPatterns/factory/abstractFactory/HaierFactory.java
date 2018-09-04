package com.zyh.zyhTest.designPatterns.factory.abstractFactory;

import com.zyh.zyhTest.designPatterns.factory.Freezer;
import com.zyh.zyhTest.designPatterns.factory.HaierFreezer;

/**
 * Created by YatHong on 2018/9/4/0004.
 */
public class HaierFactory implements AbstractFactory {
    @Override
    public Freezer createFreezer() {
        return new HaierFreezer();
    }

    @Override
    public Pool createPool() {
        return new HaierPool();
    }
}
