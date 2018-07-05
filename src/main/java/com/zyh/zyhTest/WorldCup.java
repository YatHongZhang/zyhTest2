package com.zyh.zyhTest;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2018/6/23 0023.
 */
public class WorldCup {

    private float rate1 = 3.0f;
    private float rate2 = 2.9f;
    private float rate3 = 2.6f;
    private BigDecimal rate1Big = new BigDecimal(rate1);
    private BigDecimal rate2Big = new BigDecimal(rate2);
    private BigDecimal rate3Big = new BigDecimal(rate3);

    private int buy1,buy2,buy3;

    private int[] ss = {20,40,50,60,70,80,90,100,110,120,130,140,150,160,170,180,190,200};

    public void calculate(){
        for(int i = 0; i<ss.length; i++){
            buy1 = ss[i];
            this.find2first();
            this.find3first();
            this.buy1AndBuy3();
            //this.buyLoseWin();
        }
    }


    private boolean isIn(int buy){
        for(int i=0 ; i<ss.length; i++){
            if(buy == ss[i]){
                return true;
            }
        }
        return false;
    }


    private void find2first(){
        for(int j = 0; j<ss.length; j++){
            buy2 = ss[j];
            if (buy1 + buy2 > 200){
                continue;
            }
            buy3 = 200 - buy1 - buy2;
            if(!isIn(buy3)){
                continue;
            }
            this.result();
        }
    }

    private void find3first(){
        for(int j = 0; j<ss.length; j++){
            buy3 = ss[j];
            if (buy1 + buy3 > 200){
                continue;
            }
            buy2 = 200 - buy1 - buy3;
            if(!isIn(buy2)){
                continue;
            }
            this.result();
        }
    }

    private void result(){
        BigDecimal buy1Big = new BigDecimal(buy1);
        BigDecimal buy2Big = new BigDecimal(buy2);
        BigDecimal buy3Big = new BigDecimal(buy3);
        //System.out.println(buy1+", "+buy2+", "+ buy3);
        float win1 = buy1Big.multiply(rate1Big.subtract(BigDecimal.ONE)).floatValue();
        float win2 = buy2Big.multiply(rate2Big.subtract(BigDecimal.ONE)).floatValue();
        float win3 = buy3Big.multiply(rate3Big.subtract(BigDecimal.ONE)).floatValue();
        if(win1>(buy2+buy3) && win2>(buy1+buy3) && win3>(buy1+buy2)){
            System.out.println("有了!!");
            System.out.println("buy1:"+buy1);
            System.out.println("buy2:"+buy2);
            System.out.println("buy3:"+buy3);
        }
    }

    private void buy1AndBuy3(){
        for(int i =0; i<ss.length; i++){
            buy3 = ss[i];
            if (buy1+buy3 > 200){
                continue;
            }
            BigDecimal buy1Big = new BigDecimal(buy1);
            BigDecimal buy3Big = new BigDecimal(buy3);
            BigDecimal win1 = buy1Big.multiply(rate1Big.subtract(BigDecimal.ONE));
            BigDecimal win3 = buy3Big.multiply(rate3Big.subtract(BigDecimal.ONE));
            if(win1.floatValue() > buy3Big.floatValue() && win3.floatValue() >buy1Big.floatValue()){
                System.out.println("只要不是打平就赚哦");
                System.out.println("buy1:"+buy1);
                System.out.println("buy3:"+buy3);
                //System.out.println(win1.floatValue()+" 或 "+win3.floatValue());
                System.out.println("赚:"+Math.round(win1.floatValue()-buy3)+" 或 "+Math.round(win3.floatValue()-buy1));
                System.out.println();
            }
        }
    }

    private void buyLoseWin(){
        for(int i= 0; i<ss.length;i++){
            buy3=ss[i];
            if (buy1+buy3>200){
                continue;
            }
            BigDecimal buy1Big = new BigDecimal(buy1);
            BigDecimal buy3Big = new BigDecimal(buy3);
            BigDecimal win1 = buy1Big.multiply(rate1Big.subtract(BigDecimal.ONE));
            BigDecimal win3 = buy3Big.multiply(rate3Big.subtract(BigDecimal.ONE));
            if(win1.floatValue() > buy3Big.floatValue() && win3.floatValue() >buy1Big.floatValue()){
                System.out.println("买输赢");
                System.out.println("buy1:"+buy1);
                System.out.println("buy3:"+buy3);
                //System.out.println(win1.floatValue()+" 或 "+win3.floatValue());
                System.out.println("赚:"+Math.round(win1.floatValue()-buy3)+" 或 "+Math.round(win3.floatValue()-buy1));
                System.out.println();
            }
        }
    }



    public static void main(String[] args){
        new WorldCup().calculate();
    }

}
