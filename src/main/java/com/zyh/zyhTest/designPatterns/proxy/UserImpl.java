package com.zyh.zyhTest.designPatterns.proxy;

/**
 * Created by YatHong on 2018/9/4/0004.
 */
public class UserImpl implements User {
    private String name;
    private int age;

    public UserImpl(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void printName() {
        System.out.println("名字叫" + this.name);
    }

    @Override
    public int getAge() {
        System.out.println("获取年龄");
        return this.age;
    }
}
