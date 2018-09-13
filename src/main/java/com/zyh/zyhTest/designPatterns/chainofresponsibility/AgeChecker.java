package com.zyh.zyhTest.designPatterns.chainofresponsibility;

/**
 * Created by YatHong on 2018/9/13/0013.
 */
public class AgeChecker extends Checker {
    public AgeChecker(Checker next) {
        super(next);
    }

    @Override
    void doCheck() {
        System.out.println("校验年龄");
    }
}
