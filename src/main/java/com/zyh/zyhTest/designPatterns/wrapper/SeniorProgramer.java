package com.zyh.zyhTest.designPatterns.wrapper;

/**
 * Created by YatHong on 2018/9/12/0012.
 * 高级程序员
 */
public class SeniorProgramer implements Programer {

    protected Programer programer;

    public SeniorProgramer(Programer programer) {
        this.programer = programer;
    }

    @Override
    public void work() {
        System.out.println("需求分析");
        programer.work();
    }
}
