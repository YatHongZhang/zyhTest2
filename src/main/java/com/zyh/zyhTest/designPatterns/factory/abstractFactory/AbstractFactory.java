package com.zyh.zyhTest.designPatterns.factory.abstractFactory;

import com.zyh.zyhTest.designPatterns.factory.Freezer;

/**
 * Created by YatHong on 2018/9/4/0004.
 */
public interface AbstractFactory {
    Freezer createFreezer();

    Pool createPool();


}
