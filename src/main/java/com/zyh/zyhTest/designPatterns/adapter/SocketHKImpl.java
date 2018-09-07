package com.zyh.zyhTest.designPatterns.adapter;

import com.zyh.zyhTest.designPatterns.adapter.interfaceAndAbstractClass.PlugHK;
import com.zyh.zyhTest.designPatterns.adapter.interfaceAndAbstractClass.SocketHK;

/**
 * Created by YatHong on 2018/9/7/0007.
 */
public class SocketHKImpl extends SocketHK {
    @Override
    protected void acceptHKplug(PlugHK plugHK) {
        System.out.println("对接成功,开始通电");
    }
}
