package com.zyh.zyhTest.designPatterns.chainofresponsibility.checker;


/**
 * Created by YatHong on 2018/9/13/0013.
 */
public class SexChecker extends Checker {
    public SexChecker(Checker next) {
        super(next);
    }

    @Override
    void doCheck() {
        System.out.println("校验性别");
    }
}
