package com.zyh.zyhTest.designPatterns.chainofresponsibility.filter;

/**
 * Created by YatHong on 2018/9/13/0013.
 */
public class FilterTest {
    public static void main(String[] args) {
        MyFilterChainImpl impl = new MyFilterChainImpl();
        impl.addFilter(new FilterCheckAge());
        impl.addFilter(new FilterCheckName());
        impl.addFilter(new FilterCheckSex());
        impl.doFilter(new MyRequest("Mic老师","男",18));
        System.out.println("==================");
        //这里有点问题
        //impl.doFilter(new MyRequest("小若老师","女",18));

    }
}
