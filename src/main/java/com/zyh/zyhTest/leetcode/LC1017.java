package com.zyh.zyhTest.leetcode;

/**
 * @author YatHong on 2019/4/18/0018
 * 负二进制转换
 * 给出数字 N，返回由若干 "0" 和 "1"组成的字符串，该字符串为 N 的负二进制（base -2）表示。
 * 除非字符串就是 "0"，否则返回的字符串中不能含有前导零。
 * 0 <= N <= 10^9
 *
 * 输入：2
 * 输出："110"
 * 解释：(-2) ^ 2 + (-2) ^ 1 = 2
 *
 * 输入：3
 * 输出："111"
 * 解释：(-2) ^ 2 + (-2) ^ 1 + (-2) ^ 0 = 3
 */
public class LC1017 {
    public static void main(String[] args) {
        /*for(int i=0 ; i<10; i++){
            System.out.println(2 << i);
        }*/
        LC1017.baseNeg2(22);
    }

    public static String baseNeg2(int n) {
        if(n == 0) {return "0";}
        if(n == 1) {return "1";}
        int bit = 1;
        int max = 1;
        int bitmax = 1;
        while(max < n){
            bit += 2;
            bitmax *= 4;
            max += bitmax;
            System.out.println("bit:"+bit+", num:"+max);
        }
        System.out.println("n:"+n);
        System.out.println("位数:"+bit);
        System.out.println("该位最大值:"+bitmax);
        System.out.println("可容纳的最大值:"+max+", 二进制"+Integer.toBinaryString(max));
        System.out.println("相差:"+(max-n)+", 二进制:"+Integer.toBinaryString(max-n));





        return null;
    }
}
