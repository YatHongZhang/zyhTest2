package com.zyh.zyhTest.designPatterns.adapter;

import com.zyh.zyhTest.designPatterns.adapter.interfaceAndAbstractClass.PlugCN;
import com.zyh.zyhTest.designPatterns.adapter.interfaceAndAbstractClass.Socket;
import com.zyh.zyhTest.designPatterns.adapter.interfaceAndAbstractClass.SocketCN;

/**
 * Created by YatHong on 2018/9/7/0007.
 */
public class PlugCNImpl extends PlugCN {

    @Override
    protected void insertCnSocket(SocketCN socketCN) {
        socketCN.accept(this);
    }
}
