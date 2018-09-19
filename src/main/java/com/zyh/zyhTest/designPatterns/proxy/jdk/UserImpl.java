package com.zyh.zyhTest.designPatterns.proxy.jdk;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by YatHong on 2018/9/4/0004.
 */
@Slf4j
public class UserImpl implements User {
    private String name;
    private int age;

    public UserImpl(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void printName() {
        log.info("名字叫{}", this.name);
    }

    @Override
    public int getAge() {
        log.info("获取年龄");
        return this.age;
    }
}
