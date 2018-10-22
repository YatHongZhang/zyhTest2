package com.zyh.zyhTest.jobinterview;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;

/**
 * @author YatHong on 2018/10/22/0022
 */
@Slf4j
public class TestInteger {
    public static void main(String[] args) {
        Integer a=1, b=2;
        log.info("交换前,a的值:{},b的值:{}",a,b);
        swap(a,b);
        log.info("交换后,a的值:{},b的值:{}",a,b);

        log.info("=======================");
        log.info("{}",Integer.valueOf(1) == Integer.valueOf(1));
        log.info("{}",Integer.valueOf(128) == Integer.valueOf(128));
        log.info("{}",Integer.valueOf(1).equals(Integer.valueOf(1)));
        log.info("{}",Integer.valueOf(128).equals(Integer.valueOf(128)));
    }

    public static void swap(Integer a, Integer b){
        try {

            Field field = Integer.class.getDeclaredField("value");
            //value属性在Integer中是private, 外部无法访问, 通过此处修改为可访问
            field.setAccessible(true);
            int tmp = a.intValue();
            field.set(a,b.intValue());
            field.set(a,tmp);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
