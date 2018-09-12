package com.zyh.zyhTest.designPatterns.observer;

/**
 * Created by YatHong on 2018/9/11/0011.
 */
public interface Observable {

    /**
     * 增加观察者
     * @param observer
     */
    void addObserver(Observer observer);


    /**
     * 移除观察者
     * @param observer
     */
    void removeObserver(Observer observer);


    /**
     * 通知
     */
    void notifyObserver(String badThing);
}
