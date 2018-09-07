package com.zyh.zyhTest.designPatterns.adapter.interfaceAndAbstractClass;

/**
 * Created by YatHong on 2018/9/7/0007.
 * 国产插头
 */
public abstract class PlugCN implements Plug{

    @Override
    public void insert(Socket socket) {
        System.out.println(this + " 开始对接 " + socket);
        if (!(socket instanceof SocketCN)){
            throw new RuntimeException("失败,只能对接国产插座");
        }
        this.insertCnSocket((SocketCN)socket);
    }

    protected abstract void insertCnSocket(SocketCN socketCN);

    @Override
    public String toString(){
        return "国产插头";
    }





}
