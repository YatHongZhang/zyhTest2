package com.zyh.zyhTest.rmi;

import java.rmi.Remote;

/**
 * @author YatHong on 2018/12/26/0026
 */
public interface IHelloService extends Remote {

    String saySth(String str);
}
