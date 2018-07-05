package com.zyh.zyhTest.ProducerConsumer;

/**
 * Created by YatHong on 2018/2/24/0024.
 */
public class Consumer implements Runnable{
    private String consumerName;
    private Basket basket;

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public Consumer(String consumerName, Basket basket) {
        this.consumerName = consumerName;
        this.basket = basket;
    }

    @Override
    public void run(){
        for(int i = 0; i<10; i++) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.basket.consume(this.consumerName);
        }
    }
}
