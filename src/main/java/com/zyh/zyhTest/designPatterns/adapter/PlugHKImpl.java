package com.zyh.zyhTest.designPatterns.adapter;

import com.zyh.zyhTest.designPatterns.adapter.interfaceAndAbstractClass.PlugHK;
import com.zyh.zyhTest.designPatterns.adapter.interfaceAndAbstractClass.Socket;
import com.zyh.zyhTest.designPatterns.adapter.interfaceAndAbstractClass.SocketHK;

/**
 * Created by YatHong on 2018/9/7/0007.
 */
public class PlugHKImpl extends PlugHK {

    @Override
    protected void insertHKSocket(SocketHK socketHK) {
        socketHK.accept(this);
    }
}
