package com.zyh.zyhTest.distributed.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author YatHong on 2018/12/26/0026
 */
public class HelloServiceImpl extends UnicastRemoteObject implements IHelloService {

    protected HelloServiceImpl(int port) throws RemoteException {
        super(port);
    }

    @Override
    public String saySth(String str){
        return ("hello,"+str);
    }
}
