package com.zyh.zyhTest.designPatterns.wrapper;

/**
 * Created by YatHong on 2018/9/12/0012.
 * 装饰器模式
 */
public class WrapperTest {
    public static void main(String[] args) {
        Programer p1 = new JuniorProgramer();
        Programer p2 = new SeniorProgramer(p1);
        Programer frameworker = new Frameworker(p2);
        Programer manager = new Manager(p2);

        frameworker.work();
        System.out.println("====================");
        manager.work();
    }
}
