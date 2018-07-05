package com.zyh.zyhTest.springSource.circleDependency;

/**
 * Created by YatHong on 2018/3/20/0020.
 */
public class TestB {
    private TestA a;

    public TestB(){

    }

    public TestA getA() {
        return a;
    }

    public void setA(TestA a) {
        this.a = a;
    }
}
