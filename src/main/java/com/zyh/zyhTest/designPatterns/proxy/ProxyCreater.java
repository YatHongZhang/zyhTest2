package com.zyh.zyhTest.designPatterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by YatHong on 2018/9/4/0004.
 */
public class ProxyCreater<T> implements InvocationHandler {

    private T origin;

    public ProxyCreater(T origin) {
        this.origin = origin;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进入增强");
        Object obj = method.invoke(origin,args);
        System.out.println("增强结束");
        return obj;
    }

    public T getProxyInstance(){
        return (T)Proxy.newProxyInstance(origin.getClass().getClassLoader(),origin.getClass().getInterfaces(),this);
    }
}
