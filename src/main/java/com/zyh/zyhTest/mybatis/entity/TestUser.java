package com.zyh.zyhTest.mybatis.entity;

import java.util.Date;

public class TestUser {
    private Integer id;

    private String userName;

    private Byte age;

    private Date createTime;

    public TestUser() {
    }

    public TestUser(String userName, Byte age, Date createTime) {
        this.userName = userName;
        this.age = age;
        this.createTime = createTime;
    }

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}