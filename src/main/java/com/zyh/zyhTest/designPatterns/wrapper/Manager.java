package com.zyh.zyhTest.designPatterns.wrapper;

/**
 * Created by YatHong on 2018/9/12/0012.
 */
public class Manager extends SeniorProgramer {

    public Manager(Programer programer) {
        super(programer);
    }

    @Override
    public void work() {
        System.out.println("管理项目进度");
        programer.work();
    }
}
