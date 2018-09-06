package com.zyh.zyhTest.designPatterns.prototype;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by YatHong on 2018/9/5/0005.
 * 原型模式, 也就是克隆, 实现Cloneable接口并重写clone方法
 */
@Getter
@Setter
public class ProtoType implements Cloneable {

    private String str;
    private int i ;
    private ProtoType pt;

    public ProtoType() {
    }

    public ProtoType(String str, int i, ProtoType pt) {
        this.str = str;
        this.i = i;
        this.pt = pt;
    }

    @Override
    protected ProtoType clone() throws CloneNotSupportedException {
        return (ProtoType)super.clone();
    }


    public static void main(String[] args) throws CloneNotSupportedException {
        ProtoType p1 = new ProtoType("原型",123,new ProtoType());
        ProtoType p2 = p1.clone();
        System.out.println(p1 == p2);//false
        System.out.println(p1.getStr() == p2.getStr());//true
        System.out.println(p1.getPt() == p2.getPt());//true
    }
}
