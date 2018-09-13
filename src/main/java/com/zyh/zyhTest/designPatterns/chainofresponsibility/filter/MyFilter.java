package com.zyh.zyhTest.designPatterns.chainofresponsibility.filter;

/**
 * Created by YatHong on 2018/9/13/0013.
 */
public interface MyFilter {
    void doFilter(MyRequest myRequest, MyFilterChain myFilterChain);
}
