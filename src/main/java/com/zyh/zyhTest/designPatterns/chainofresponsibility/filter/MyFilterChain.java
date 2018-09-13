package com.zyh.zyhTest.designPatterns.chainofresponsibility.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YatHong on 2018/9/13/0013.
 */
public interface MyFilterChain {

    void doFilter(MyRequest myRequest);
}
