package com.zyh.zyhTest.designPatterns.adapter.interfaceAndAbstractClass;

/**
 * Created by YatHong on 2018/9/7/0007.
 * 港版插头
 */
public abstract class PlugHK implements Plug{

    @Override
    public void insert(Socket socket) {
        System.out.println(this + " 开始对接 " + socket);
        if (!(socket instanceof SocketHK)){
            throw new RuntimeException("失败,只能对接港版插座");
        }
        this.insertHKSocket((SocketHK)socket);
    }

    protected abstract void insertHKSocket(SocketHK socketHK);

    @Override
    public String toString(){
        return "港版插头";
    }
}
