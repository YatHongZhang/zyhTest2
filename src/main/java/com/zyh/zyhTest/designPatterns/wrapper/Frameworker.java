package com.zyh.zyhTest.designPatterns.wrapper;

/**
 * Created by YatHong on 2018/9/12/0012.
 * 架构师
 */
public class Frameworker extends SeniorProgramer{

    public Frameworker(Programer programer) {
        super(programer);
    }


    @Override
    public void work() {
        System.out.println("搭建架构");
        programer.work();
    }
}
