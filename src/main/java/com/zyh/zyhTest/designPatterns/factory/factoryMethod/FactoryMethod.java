package com.zyh.zyhTest.designPatterns.factory.factoryMethod;

import com.zyh.zyhTest.designPatterns.factory.Freezer;
import com.zyh.zyhTest.designPatterns.factory.HaierFreezer;
import com.zyh.zyhTest.designPatterns.factory.MediaFreezer;
import com.zyh.zyhTest.designPatterns.factory.RonShenFreezer;

/**
 * Created by YatHong on 2018/9/4/0004.
 * 工厂方法, 专厂做专事
 */
public class FactoryMethod {
    public static void main(String[] args) {
        System.out.println(new MediaFactory().createFreezer().getFreezerName());
        System.out.println(new HaierFactory().createFreezer().getFreezerName());
        System.out.println(new RonshenFactory().createFreezer().getFreezerName());
    }
}


class MediaFactory implements FreezerFactory {
    @Override
    public Freezer createFreezer() {
        return new MediaFreezer();
    }
}


class HaierFactory implements FreezerFactory {
    @Override
    public Freezer createFreezer() {
        return new HaierFreezer();
    }
}


class RonshenFactory implements FreezerFactory {
    @Override
    public Freezer createFreezer() {
        return new RonShenFreezer();
    }
}
