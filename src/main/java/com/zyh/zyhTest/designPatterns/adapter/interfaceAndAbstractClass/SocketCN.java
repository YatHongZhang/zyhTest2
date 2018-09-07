package com.zyh.zyhTest.designPatterns.adapter.interfaceAndAbstractClass;

/**
 * Created by YatHong on 2018/9/7/0007.
 * 国产插座
 */
public abstract class SocketCN implements Socket{

    @Override
    public void accept(Plug plug) {
        if(!(plug instanceof PlugCN)){
            throw new RuntimeException("失败,只能接收国产插头");
        }
        this.acceptCNPlug((PlugCN)plug);
    }

    protected abstract void acceptCNPlug(PlugCN plugCN);

    @Override
    public String toString(){
        return "国产插座";
    }
}
