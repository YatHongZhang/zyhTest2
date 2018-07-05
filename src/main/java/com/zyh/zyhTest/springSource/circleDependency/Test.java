package com.zyh.zyhTest.springSource.circleDependency;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.net.URLEncoder;

/**
 * Created by YatHong on 2018/3/20/0020.
 */
public class Test {
    public static void main(String[] args) throws Exception{
        //BeanFactory bf = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
        //bf.getBean("testA");

        /*ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        ac.getBean("testA");

        System.out.println("aaaa");*/

        /*String str = "131313$$$VIP";
        String[] arr = str.split("\\$\\$\\$");
        System.out.println(arr[0]);
        System.out.println(arr[1]);*/


        //String url = "https://app.shabaozaixian.com/wx/callback";
        String url = "gQEe8DwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyZEw3bE1VU1BkaGgxVmxwWGhxMTgAAgT9lvtaAwRYAgAA";
        url = URLEncoder.encode(url,"utf-8");
        System.out.println(url);


    }
}
