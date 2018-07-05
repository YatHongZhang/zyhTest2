package com.zyh.zyhTest.ProducerConsumer;

/**
 * Created by YatHong on 2018/2/24/0024.
 */
public class Producer implements Runnable{
    private String producerName;
    private Basket basket;
    private int ballId;

    public Producer(String producerName, Basket basket, int ballId) {
        this.producerName = producerName;
        this.basket = basket;
        this.ballId = ballId;
    }

    @Override
    public void run(){
        for(int i = 0; i<10; i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.basket.produce(this.producerName,new Ball(ballId++));
        }
    }
}
