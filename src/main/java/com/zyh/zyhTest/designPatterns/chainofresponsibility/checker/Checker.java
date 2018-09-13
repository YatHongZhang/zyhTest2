package com.zyh.zyhTest.designPatterns.chainofresponsibility.checker;

/**
 * Created by YatHong on 2018/9/13/0013.
 */
public abstract class Checker {
    private Checker next;

    public Checker(Checker next) {
        this.next = next;
    }

    public Checker getNext() {
        return next;
    }

    public void setNext(Checker next) {
        this.next = next;
    }

    protected void check(Requestt request){
        doCheck();
        if (next != null){
            next.check(request);
        }
    }

    abstract void doCheck();
}
