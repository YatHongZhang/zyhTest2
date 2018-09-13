package com.zyh.zyhTest.designPatterns.chainofresponsibility.filter;

/**
 * Created by YatHong on 2018/9/13/0013.
 */
public class FilterCheckSex implements MyFilter {
    @Override
    public void doFilter(MyRequest myRequest, MyFilterChain chain) {
        System.out.println("filter检测到性别是:"+myRequest.getSex());
        chain.doFilter(myRequest);
    }
}
