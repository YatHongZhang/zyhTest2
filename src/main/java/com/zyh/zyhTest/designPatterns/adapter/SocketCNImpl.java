package com.zyh.zyhTest.designPatterns.adapter;

import com.zyh.zyhTest.designPatterns.adapter.interfaceAndAbstractClass.PlugCN;
import com.zyh.zyhTest.designPatterns.adapter.interfaceAndAbstractClass.SocketCN;

/**
 * Created by YatHong on 2018/9/7/0007.
 */
public class SocketCNImpl extends SocketCN {

    @Override
    protected void acceptCNPlug(PlugCN plugCN) {
        System.out.println("对接成功,开始通电");
    }
}
