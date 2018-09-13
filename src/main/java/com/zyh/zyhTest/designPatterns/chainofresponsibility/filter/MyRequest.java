package com.zyh.zyhTest.designPatterns.chainofresponsibility.filter;

/**
 * Created by YatHong on 2018/9/13/0013.
 */
public class MyRequest {
    private String name;
    private String sex;
    private int age;

    public MyRequest(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
