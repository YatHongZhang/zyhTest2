package com.zyh.zyhTest.dubbo;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.rpc.Protocol;

import java.util.regex.Pattern;

/**
 * @author YatHong on 2019/1/21/0021
 */
public class DubboTest {
    public static void main(String[] args) {

        //ExtensionLoader.getExtensionLoader(Protocol.class).getActivateExtension()
        String str;
        str = ExtensionLoader.getExtensionLoader(Protocol.class).getDefaultExtensionName();
        System.out.println(str);
        int port = ExtensionLoader.getExtensionLoader(Protocol.class).getDefaultExtension().getDefaultPort();
        System.out.println(port);
        str = ExtensionLoader.getExtensionLoader(Protocol.class).getAdaptiveExtension().getClass().getName();
        System.out.println(str);

        String test = "h,hh";
        String[] tests = Pattern.compile("\\s*[,]+\\s*").split(test);
        for(String aaa:tests){
            System.out.println(aaa);
        }

        String s = String.format("\nif (arg%d == null) throw new IllegalArgumentException(\"url == null\");",
                2);
        System.out.println(s);
    }
}
