package com.zyh.zyhTest.designPatterns.chainofresponsibility.filter;

/**
 * Created by YatHong on 2018/9/13/0013.
 */
public class FilterCheckAge implements MyFilter {
    @Override
    public void doFilter(MyRequest myRequest, MyFilterChain chain) {
        System.out.println("filter检测到年龄是:"+myRequest.getAge());
        chain.doFilter(myRequest);
    }
}
