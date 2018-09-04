package com.zyh.zyhTest.designPatterns.factory.abstractFactory;

import com.zyh.zyhTest.designPatterns.factory.Freezer;
import com.zyh.zyhTest.designPatterns.factory.MediaFreezer;

/**
 * Created by YatHong on 2018/9/4/0004.
 */
public class MediaFactory implements AbstractFactory {
    @Override
    public Freezer createFreezer() {
        return new MediaFreezer();
    }

    @Override
    public Pool createPool() {
        return new MediaPool();
    }
}
