package com.zyh.zyhTest.designPatterns.proxy;

/**
 * Created by YatHong on 2018/9/4/0004.
 */
public class ProxyTest {
    public static void main(String[] args) {
        User user = new UserImpl("张三",99) ;

        ProxyCreater<User> proxyCreater = new ProxyCreater<>(user);

        User newUser = proxyCreater.getProxyInstance();

        newUser.printName();

        System.out.println("------------------");

        System.out.println("返回年龄:" + newUser.getAge());

    }
}
