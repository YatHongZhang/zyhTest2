package com.zyh.zyhTest.designPatterns.observer;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by YatHong on 2018/9/11/0011.
 */
@Slf4j
public class Police implements Observer {

    private String policeNum;

    public Police(String policeNum) {
        this.policeNum = policeNum;
    }

    @Override
    public void update(String thiefName, String msg) {
        log.info("{},{}那边有情况:{}",policeNum,thiefName,msg);
    }
}
