package com.zyh.zyhTest.designPatterns.adapter;

import com.zyh.zyhTest.designPatterns.adapter.interfaceAndAbstractClass.*;

/**
 * Created by YatHong on 2018/9/7/0007.
 */
public class AdapterSocketHK2PlugCN extends SocketHK implements Adapter{

    private Plug plug;
    private Socket socket;

    public AdapterSocketHK2PlugCN(Plug plug, Socket socket) {
        this.plug = plug;
        this.socket = socket;
    }

    @Override
    protected void acceptHKplug(PlugHK plugHK) {
        System.out.println("对接成功");
        this.transfer();
    }

    @Override
    public void transfer() {
        System.out.println(this + "-转接-" + plug);
        plug.insert(socket);
    }

}
