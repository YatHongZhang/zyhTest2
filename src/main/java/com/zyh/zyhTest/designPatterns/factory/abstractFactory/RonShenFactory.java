package com.zyh.zyhTest.designPatterns.factory.abstractFactory;

import com.zyh.zyhTest.designPatterns.factory.Freezer;
import com.zyh.zyhTest.designPatterns.factory.RonShenFreezer;

/**
 * Created by YatHong on 2018/9/4/0004.
 */
public class RonShenFactory implements AbstractFactory {
    @Override
    public Freezer createFreezer() {
        return new RonShenFreezer();
    }

    @Override
    public Pool createPool() {
        return new RonShenPool();
    }
}
