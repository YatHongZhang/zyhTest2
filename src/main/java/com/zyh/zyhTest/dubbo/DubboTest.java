package com.zyh.zyhTest.dubbo;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.rpc.Protocol;

/**
 * @author YatHong on 2019/1/21/0021
 */
public class DubboTest {
    public static void main(String[] args) {

        String str = ExtensionLoader.getExtensionLoader(Protocol.class).getDefaultExtensionName();
        System.out.println(str);
    }
}
