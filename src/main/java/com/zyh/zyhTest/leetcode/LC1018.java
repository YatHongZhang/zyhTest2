package com.zyh.zyhTest.leetcode;

import java.util.*;

/**
 * @author YatHong on 2019/4/18/0018
 */
public class LC1018 {

    public static void main(String[] args) {

    }

    /**
     * 可被 5 整除的二进制前缀
     * 给定由若干 0 和 1 组成的数组 A。我们定义 N_i：从 A[0] 到 A[i] 的第 i 个子数组被解释为一个二进制数（从最高有效位到最低有效位）。
     * 返回布尔值列表 answer，只有当 N_i 可以被 5 整除时，答案 answer[i] 为 true，否则为 false。
     * a = {1,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,1,0,0,0,0,1,1,0,1,0,0,0,1}甚至更长
     */
    public List<Boolean> solute(int[] a){
        List<Boolean> list = new ArrayList<>(a.length);
        int num=0;
        for (int i=0; i<a.length; i++){
            num = num << 1;
            num = a[i] == 0 ? num%5 : (num+1)%5 ;
            list.add(num == 0 ? true : false);
        }
        return list;
    }


    /**
     3 无重复字符的最长子串 中等
     给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     示例 1:
     输入: "abcabcbb"
     输出: 3
     解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     示例 2:
     输入: "bbbbb"
     输出: 1
     解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     示例 3:
     输入: "pwwkew"
     输出: 3
     解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     */
    public int lengthOfLongestSubstring(String s) {
        int begin = 0;
        int max=0;
        for(int i=0; i<s.length(); i++){
            char ci = s.charAt(i);
            for(int j=begin; j<i; j++){
                if(ci == s.charAt(j)){
                    begin = j+1;
                    break;
                }
            }
            if(i-begin + 1 > max){
                max = i-begin +1;
            }
        }
        return max;
    }


    /**
     * 26. 删除排序数组中的重复项
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     示例 1:
     给定数组 nums = [1,1,2],
     函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
     你不需要考虑数组中超出新长度后面的元素。
     示例 2:
     给定 nums = [0,0,1,1,1,2,2,3,3,4],
     函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
     */
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length ==0){
            return 0;
        }
        int count = nums.length;
        int now = nums[0];
        for(int i=1; i<count; i++){
            if(now == nums[i]){
                for(int j=i; j<count-1; j++){
                    nums[j] = nums[j+1];
                }
                count --;
                i--;
            }else{
                now = nums[i];
            }
        }
        return count;
    }







}
