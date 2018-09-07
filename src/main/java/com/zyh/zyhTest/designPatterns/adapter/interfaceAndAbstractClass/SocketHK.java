package com.zyh.zyhTest.designPatterns.adapter.interfaceAndAbstractClass;

/**
 * Created by YatHong on 2018/9/7/0007.
 * 港产插座
 */
public abstract class SocketHK implements Socket{

    @Override
    public void accept(Plug plug) {
        if(!(plug instanceof PlugHK)){
            throw new RuntimeException("失败,只能接收港版插头");
        }
        this.acceptHKplug((PlugHK) plug);
    }

    protected abstract void acceptHKplug(PlugHK plugHK);

    @Override
    public String toString(){
        return "港版插座";
    }
}
