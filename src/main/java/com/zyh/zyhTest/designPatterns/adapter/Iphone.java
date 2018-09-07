package com.zyh.zyhTest.designPatterns.adapter;

import com.zyh.zyhTest.designPatterns.adapter.interfaceAndAbstractClass.*;

/**
 * Created by YatHong on 2018/9/7/0007.
 */
public class Iphone {

    private Plug plug;
    private Socket socket;

    public Iphone(Plug plug, Socket socket) {
        this.plug = plug;
        this.socket = socket;
    }

    public void charge(){
        plug.insert(socket);
        System.out.println("爱疯开始充电");
    }


    public static void main(String[] args) {
        try{
            Plug plugHK = new PlugHKImpl();
            Plug plugCN = new PlugCNImpl();
            Socket socketCn = new SocketCNImpl();
            Socket socketHK = new SocketHKImpl();
            Socket adapter = new AdapterSocketHK2PlugCN(plugCN,socketCn);

            Iphone iphone = new Iphone(plugHK,adapter);
            iphone.charge();
        }catch (Exception e){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }

    }


}
