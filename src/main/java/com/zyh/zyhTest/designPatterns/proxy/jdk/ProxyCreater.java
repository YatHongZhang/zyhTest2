package com.zyh.zyhTest.designPatterns.proxy.jdk;

import lombok.extern.slf4j.Slf4j;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
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


    /**
     * 测试
     */
    public static void main(String[] args) {

        User user = new UserImpl("张三",99) ;

        ProxyCreater<User> proxyCreater = new ProxyCreater<>(user);

        User newUser = proxyCreater.getProxyInstance();

        newUser.printName();

        log.info("------------------");

        //打印代理类的类名
        log.info(newUser.getClass().getName());

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
