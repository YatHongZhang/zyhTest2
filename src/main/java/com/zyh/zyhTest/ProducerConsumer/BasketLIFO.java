package com.zyh.zyhTest.ProducerConsumer;

/**
 * Created by YatHong on 2018/2/24/0024.
 * 后进先出
 */
public class BasketLIFO extends Basket{

    private int head = 0;

    public BasketLIFO(int capacity){
        super(capacity);
    }

    @Override
    public synchronized void produce(String producerName, Ball ball){
        while(head == this.capacity){
            try {
                System.out.println("已满," + producerName + "等待");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        basket[head] = ball;
        head++;
        this.notifyAll();
        System.out.println(producerName + "生产了" + ball.getId() + "号球");
    }

    @Override
    public synchronized Ball consume(String consumerName){
        while(head == 0){
            try {
                System.out.println("已空," + consumerName + "等待");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Ball ball = basket[head - 1];
        head--;
        this.notifyAll();
        System.out.println(consumerName + "消费了" + ball.getId() + "号球");
        return ball;
    }




    public static void main(String args[]){
        Basket basket = new BasketLIFO(5);

        Thread p1 = new Thread(new Producer("p1",basket,100));
        Thread p2 = new Thread(new Producer("p2",basket,200));
        Thread c1 = new Thread(new Consumer("c1",basket));
        Thread c2 = new Thread(new Consumer("c2",basket));

        p1.start();
        p2.start();
        c1.start();
        c2.start();
    }
}
