package com.zyh.zyhTest.designPatterns.factory.simpleFactory;

import com.zyh.zyhTest.designPatterns.factory.Freezer;
import com.zyh.zyhTest.designPatterns.factory.HaierFreezer;
import com.zyh.zyhTest.designPatterns.factory.MediaFreezer;
import com.zyh.zyhTest.designPatterns.factory.RonShenFreezer;

/**
 * Created by YatHong on 2018/9/4/0004.
 * 简单工厂
 * 优点:什么都可以做,要什么都可以给你
 * 缺点:什么都可以做,代码量大,无法遵循开闭原则(对修改关闭,对扩展开放)
 */
public class SimpleFactory {

    public Freezer getFreezer(String name){
        if("美的".equals(name)){
            return new MediaFreezer();
        }else if ("海尔".equals(name)){
            return new HaierFreezer();
        }else if ("容声".equals(name)){
            return new RonShenFreezer();
        }else {
            throw new RuntimeException("没有你想要的冰箱");
        }
    }


    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();
        System.out.println(simpleFactory.getFreezer("美的").getFreezerName());
        System.out.println(simpleFactory.getFreezer("海尔").getFreezerName());
        System.out.println(simpleFactory.getFreezer("容声").getFreezerName());
        System.out.println(simpleFactory.getFreezer("格力").getFreezerName());
    }
}
