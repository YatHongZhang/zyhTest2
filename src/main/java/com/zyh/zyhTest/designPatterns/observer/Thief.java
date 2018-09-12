package com.zyh.zyhTest.designPatterns.observer;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YatHong on 2018/9/11/0011.
 */
@Slf4j
public class Thief implements Observable{
    private String thiefName;
    private List<Observer> list ;

    public Thief(String thiefName) {
        this.thiefName = thiefName;
        list = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer ob) {
        list.add(ob);
    }

    @Override
    public void removeObserver(Observer ob) {
        list.remove(ob);
    }

    @Override
    public void notifyObserver(String badThing) {
        if(list != null && list.size() > 0){
            for(Observer ob:list){
                ob.update(thiefName,badThing);
            }
        }else{
            log.info("各单位注意,各单位注意,{}无人盯梢,速派警力支援",thiefName);
        }
    }
}
