package com.zyh.zyhTest.ProducerConsumer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YatHong on 2018/2/24/0024.
 */
public abstract class Basket {
    protected int capacity;

    protected Ball[] basket;

    public Basket(int capacity){
        basket = new Ball[capacity];
        this.capacity = capacity;
    }

    public abstract void produce(String producerName, Ball ball);

    public abstract Ball consume(String consumerName);


}

