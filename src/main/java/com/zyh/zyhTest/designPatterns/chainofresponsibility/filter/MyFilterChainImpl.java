package com.zyh.zyhTest.designPatterns.chainofresponsibility.filter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by YatHong on 2018/9/13/0013.
 */
public class MyFilterChainImpl implements MyFilterChain {

    private List<MyFilter> filters ;
    private Iterator<MyFilter> iterator;

    public void addFilter(MyFilter myFilter){
        if(myFilter == null){
            System.out.println("不能添加null");
            return ;
        }
        if(filters == null){
            filters = new ArrayList<>();
        }
        filters.add(myFilter);
    }


    @Override
    public void doFilter(MyRequest myRequest) {
        if(filters == null || filters.size()==0){
            System.out.println("没有filter可以执行");
            return ;
        }
        if(iterator == null){
            iterator = filters.iterator();
        }
        if(iterator.hasNext()){
            iterator.next().doFilter(myRequest,this);
        }
    }
}
