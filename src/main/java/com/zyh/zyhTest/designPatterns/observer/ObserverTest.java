package com.zyh.zyhTest.designPatterns.observer;

/**
 * Created by YatHong on 2018/9/11/0011.
 */
public class ObserverTest {

    public static void main(String[] args) {
        Police p1 = new Police("AE86");
        Police p2 = new Police("9527");
        Police p3 = new Police("0101");

        Thief t1 = new Thief("耗子");
        Thief t2 = new Thief("老黑");
        Thief t3 = new Thief("黄毛");

        t1.addObserver(p1);
        t1.addObserver(p2);
        t2.addObserver(p2);
        t2.addObserver(p3);

        t1.notifyObserver("今晚有一批货到港口");
        t2.notifyObserver("老大要下来视察了");
        t3.notifyObserver("把那家伙做掉,手法干净点");
    }
}
