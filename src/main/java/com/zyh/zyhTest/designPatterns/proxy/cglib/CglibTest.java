package com.zyh.zyhTest.designPatterns.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2018/9/19 0019.
 */
public class CglibTest implements MethodInterceptor{

    public int add(int i, int j){
        System.out.println("入参:"+i+","+j);
        return i+j;
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("增强代码,调用的原方法是:"+method+",方法代理:"+methodProxy+",代理对象:"+o.getClass());
        Object obj = methodProxy.invokeSuper(o,objects);
        System.out.println("增强代码");
        return obj;
    }


    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CglibTest.class);
        enhancer.setCallback(new CglibTest());
        CglibTest test = (CglibTest)enhancer.create();
        System.out.println("结果:"+test.add(1,2));


    }
}
