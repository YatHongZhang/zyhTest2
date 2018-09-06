package com.zyh.zyhTest.designPatterns.template;

/**
 * Created by YatHong on 2018/9/5/0005.
 */
public class TemplateTest {
    public static void main(String[] args) {
        Car tesla = new Tesla();
        tesla.goSupply();

        System.out.println("----------------------");

        Car audi = new Audi();
        audi.goSupply();
    }
}
