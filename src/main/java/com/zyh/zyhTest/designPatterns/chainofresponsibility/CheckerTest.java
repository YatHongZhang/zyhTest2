package com.zyh.zyhTest.designPatterns.chainofresponsibility;

/**
 * Created by YatHong on 2018/9/13/0013.
 */
public class CheckerTest {
    public static void main(String[] args) {
        Requestt tt = new Requestt();
        SexChecker sexChecker = new SexChecker(null);
        AgeChecker ageChecker = new AgeChecker(sexChecker);
        NameChecker nameChecker = new NameChecker(ageChecker);

        nameChecker.check(tt);
    }
}
