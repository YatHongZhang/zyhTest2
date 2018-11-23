package com.zyh.zyhTest.jobinterview;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;

/**
 * @author YatHong on 2018/10/22/0022
 *
 * java自动装箱 ,
 * Integer的valueof方法, 会缓存 -128~127 的Integer值
 */
@Slf4j
public class TestInteger {
    public static void main(String[] args) {
        Integer a=1, b=2;
        log.info("交换前,a的值:{},b的值:{}",a,b);
        swap(a,b);
        log.info("交换后,a的值:{},b的值:{}",a,b);

        /*log.info("=======================");
        log.info("{}",Integer.valueOf(1) == Integer.valueOf(1));
        log.info("{}",Integer.valueOf(128) == Integer.valueOf(128));
        log.info("{}",Integer.valueOf(1).equals(Integer.valueOf(1)));
        log.info("{}",Integer.valueOf(128).equals(Integer.valueOf(128)));*/
    }

    public static void swap(Integer a, Integer b){
        try {

            /*
            //Integer实际上是值传递, 在此方法中交换, 并不能改变原方法中的值
            Integer tmp = a;
            a = b;
            b = tmp;
            //log.info("a的值:{},b的值:{}",a,b);
            */
            System.out.println(a == Integer.valueOf(1));
            System.out.println(b == Integer.valueOf(2));

            Field field = Integer.class.getDeclaredField("value");
            //value属性在Integer中是private, 外部无法访问, 通过此处修改为可访问
            field.setAccessible(true);
            Integer tmp = new Integer(a);
            //下面的set方法第二个参数是Object类型, 如果传了基础类型, 会自动进行装箱处理, 装箱处理使用的是valueOf方法, 会有缓存问题
            field.set(a, b);//Integer.valueOf(b.intValue()).intValue();
            field.set(b, tmp);

            //解决方法: tmp改为 Integer tmp = new Integer(a);
            //或者使用field.setInt方法

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
