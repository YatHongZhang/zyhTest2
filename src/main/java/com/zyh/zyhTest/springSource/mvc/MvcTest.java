package com.zyh.zyhTest.springSource.mvc;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author YatHong on 2018/11/8/0008
 */
public class MvcTest {
    public static void main(String[] args) throws NoSuchMethodException {
        List<String> list = new ArrayList<>();
        Method[] methods = list.getClass().getMethods();
        for(Method m : methods){
            System.out.println(m.getName());
            Class[] classes =  m.getParameterTypes();
            for (Class clazz : classes){
                System.out.print(clazz.getName()+" ");
            }
            System.out.println("");
            System.out.println("---------------");
        }

        //method.getParameterTypes()
    }
}
