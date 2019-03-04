package com.zyh.zyhTest.designPatterns.proxy.jdk;

import lombok.extern.slf4j.Slf4j;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by YatHong on 2018/9/4/0004.
 */
@Slf4j
public class ProxyCreater<T> implements InvocationHandler {

    /**
     * 被代理对象, 是一个接口的实现类
     */
    private T originObj;

    public ProxyCreater(T origin) {
        this.originObj = origin;
    }


    /**
     * 代理对象在调用方法的时候,都是调用invoke方法
     * @param proxyObj 代理对象
     * @param method 代理对象调用的方法
     * @param args 方法参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxyObj, Method method, Object[] args) throws Throwable {
        log.info("进入增强,代理类:{},调用方法:{},方法参数:{}",proxyObj.getClass().getName(),method,args);
        Object obj = method.invoke(originObj,args);
        log.info("增强结束");
        return obj;
    }

    /**
     * 获取代理对象
     * @return
     */
    public T getProxyInstance(){
        log.info("{}的类加载器,接口:{},对象:{}", originObj.getClass().getName(), originObj.getClass().getInterfaces(),this);
        return (T)Proxy.newProxyInstance(originObj.getClass().getClassLoader(), originObj.getClass().getInterfaces(),this);
    }


    /**
     * 测试
     */
    public static void main(String[] args) {

        User user = new UserImpl("张三",99) ;

        ProxyCreater<User> proxyCreater = new ProxyCreater<>(user);

        User newUser = proxyCreater.getProxyInstance();

        newUser.printName();

        log.info("------------------");

        //获取代理类字节数组
        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy2",new Class[]{User.class});
        try {
            FileOutputStream fos = new FileOutputStream("D://$Proxy2.class");
            fos.write(bytes);
            fos.flush();
            fos.close();
            log.info("输出文件成功");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
