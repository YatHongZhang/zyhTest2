package com.zyh.zyhTest.mybatis.entity;

import lombok.ToString;

@ToString
public class TestUser {
    private Integer id;

    private String userName;

    private Byte age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }
}