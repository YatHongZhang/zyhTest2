package com.zyh.zyhTest.designPatterns.proxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by YatHong on 2018/9/4/0004.
 */
@Slf4j
public class ProxyCreater<T> implements InvocationHandler {

    private T origin;

    public ProxyCreater(T origin) {
        this.origin = origin;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("进入增强,调用方法:{},方法参数:{}",method,args);
        Object obj = method.invoke(origin,args);
        log.info("增强结束");
        return obj;
    }

    public T getProxyInstance(){
        return (T)Proxy.newProxyInstance(origin.getClass().getClassLoader(),origin.getClass().getInterfaces(),this);
    }
}
