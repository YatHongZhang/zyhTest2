package com.zyh.zyhTest.leetcode;

import java.util.*;

/**
 * @author YatHong on 2019/4/18/0018
 * 两数之和  001,167,653
 */
public class LC0001 {

    public static void main(String[] args) {
        System.out.println(new LC0001().addBinary("1010","1011"));
    }

    /**
     * 两数之和, 两次遍历
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        boolean finded = false;
        int i,j=0;
        for(i=0; i<nums.length-1; i++){
            for (j=i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target){
                    finded = true;
                    break;
                }
            }
            if(finded){
                break;
            }
        }
        int[] result ={i,j};
        return result;
    }


    /**
     * 两数之和, 只遍历一次
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0 ; i<nums.length; i++){
            int num2 = target - nums[i];
            if(map.containsKey(num2)){
                return new int[] {map.get(num2),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }


    /**
     * 653 从二叉树里找两数之和
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return loop(root,k,set);
    }

    public boolean loop(TreeNode node, int k, Set<Integer> set){
        int target = k - node.val;
        if(set.contains(target)){
            return true;
        }
        set.add(node.val);
        if(node.left != null){
            if(loop(node.left,k,set)){return true;}
        }
        if(node.right != null){
            if(loop(node.right,k,set)){return true;}
        }
        return false;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    /**
     * 7 整数反转
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。
     * 请根据这个假设，如果反转后整数溢出那么就返回 0。
     * @param x
     * @return
     */
    public int reverse(int x) {
        if(x==0) {return 0;}
        int reNum = 0;
        int first;
        int max = Integer.MAX_VALUE/10;
        int maxLast = Integer.MAX_VALUE % 10;
        int min = Integer.MIN_VALUE/10;
        int minLast = Integer.MIN_VALUE % 10;
        while(x != 0){
            first = x % 10;
            if(reNum > max || reNum < min || (reNum == max && first>maxLast) || (reNum == min && first<minLast)){
                return 0;
            }
            x/=10;
            reNum = reNum*10 + first;
        }
        return reNum;
    }

    public boolean huiwen(int x){
        if(x < 0){return false;}
        String str = x + "";
        int length = str.length();
        for(int i=0,j=length-1; i<(length/2); i++,j--){
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
        }
        return true;
    }

    /**
     * 13 罗马数字转整数 简单
     * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
     字符          数值
     I             1
     V             5
     X             10
     L             50
     C             100
     D             500
     M             1000
     例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
     C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        int sum = 0;
        for (int i = 0; i<s.length(); i++){
            char a = s.charAt(i);
            switch(a){
                case 'I':{
                    if(i != s.length()-1){
                        if(s.charAt(i+1) == 'V'){
                            sum += 4;
                            i++;
                            break;
                        }
                        if(s.charAt(i+1) == 'X'){
                            sum += 9;
                            i++;
                            break;
                        }
                    }
                    sum += 1;
                    break;
                }
                case 'V':{
                    sum += 5;
                    break;
                }
                case 'X':{
                    if(i != s.length()-1){
                        if(s.charAt(i+1) == 'L'){
                            sum += 40;
                            i++;
                            break;
                        }
                        if(s.charAt(i+1) == 'C'){
                            sum += 90;
                            i++;
                            break;
                        }
                    }
                    sum += 10;
                    break;
                }
                case 'L':{
                    sum += 50;
                    break;
                }
                case 'C':{
                    if(i != s.length()-1){
                        if(s.charAt(i+1) == 'D'){
                            sum += 400;
                            i++;
                            break;
                        }
                        if(s.charAt(i+1) == 'M'){
                            sum += 900;
                            i++;
                            break;
                        }
                    }
                    sum += 100;
                    break;
                }
                case 'D':{
                    sum += 500;
                    break;
                }
                case 'M':{
                    sum += 1000;
                    break;
                }
                default:break;
            }
        }
        return sum;
    }

    /**
     * 14 最长公共前缀
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     如果不存在公共前缀，返回空字符串 ""。
     示例 1:
     输入: ["flower","flow","flight"]
     输出: "fl"

     示例 2:
     输入: ["dog","racecar","car"]
     输出: ""
     解释: 输入不存在公共前缀。

     说明:所有输入只包含小写字母 a-z 。
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        if (strs.length == 1){
            return strs[0];
        }

        //先找出长度最短的字符串
        String shortestStr="";
        for(int i=0 ; i<strs.length; i++){
            if(strs[i].equals("")){
                return "";
            }
            if(i==0){
                shortestStr = strs[0];
                continue;
            }
            if(shortestStr.length() > strs[i].length()){
                shortestStr = strs[i];
            }
        }

        String commonStr ="";
        for(int i=0; i<shortestStr.length(); i++){
            commonStr = shortestStr.substring(0,i+1);
            for(int j=0; j<strs.length; j++){
                if(!strs[j].startsWith(commonStr)){
                    i--;
                    if(i>=0){
                        return shortestStr.substring(0,i+1);
                    }else{
                        return "";
                    }
                }
            }
        }
        return commonStr;
    }


    /**
     * 2.两数相加 中等
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     示例：
     输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     输出：7 -> 0 -> 8
     原因：342 + 465 = 807
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean l1end=l1==null?true:false, l2end=l2==null?true:false;
        ListNode result = new ListNode(0);
        ListNode resultFirst = result;
        int bitSum;
        boolean biggerThan10 = false;
        boolean firstTime = true;
        while(!l1end || !l2end){
            if(biggerThan10){
                bitSum = 1;
                biggerThan10 = false;
            }else{
                bitSum = 0;
            }
            if(firstTime){
                firstTime = false;
            }else{
                result.next = new ListNode(0);
                result = result.next;
            }
            if(!l1end){
                bitSum += l1.val;
                l1 = l1.next;
                if (l1 == null){
                    l1end=true;
                }
            }
            if(!l2end){
                bitSum += l2.val;
                l2=l2.next;
                if(l2 == null){
                    l2end = true;
                }
            }
            if(bitSum>=10){
                biggerThan10 = true;
                bitSum %= 10;
            }
            result.val = bitSum;
        }
        if(biggerThan10){
            result.next = new ListNode(1);
        }
        return resultFirst;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * 445 两数相加II
     给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
     你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     进阶:
     如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
     示例:
     输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
     输出: 7 -> 8 -> 0 -> 7
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        StringBuilder sb = new StringBuilder();
        String s1 = null, s2 = null;
        while(l1 != null){
            sb.append(l1.val);
            l1 = l1.next;
        }
        s1 = sb.toString();
        sb.delete(0,sb.length());
        while(l2 != null){
            sb.append(l2.val);
            l2 = l2.next;
        }
        s2 = sb.toString();
        sb.delete(0,sb.length());
        int i = s1.length()-1, j = s2.length()-1;
        boolean add1 = false;
        int bitSum=0;
        while (i >= 0 || j >= 0){
            if(add1){
                bitSum = 1;
                add1 = false;
            }else{
                bitSum = 0;
            }
            if(i>=0){
                bitSum += (s1.charAt(i)-48);
                i--;
            }
            if(j>=0){
                bitSum += (s2.charAt(j)-48);
                j--;
            }
            if(bitSum >= 10){
                add1 = true;
                bitSum -= 10;
            }
            sb.append(bitSum);
        }
        if(add1){
            sb.append(1);
        }
        ListNode first= new ListNode(0);
        ListNode node = first;
        int k = sb.length()-1;
        while(k>=0){
            if(k==sb.length()-1){
                first.val = (sb.charAt(k)-48);
            }else{
                node.next = new ListNode(sb.charAt(k)-48);
                node = node.next;
            }
            k--;
        }
        return first;
    }

    /**
     * 67 二进制求和
     给定两个二进制字符串，返回他们的和（用二进制表示）。
     输入为非空字符串且只包含数字 1 和 0。
     示例 1:
     输入: a = "11", b = "1"
     输出: "100"
     示例 2:
     输入: a = "1010", b = "1011"
     输出: "10101"
     */
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int bitSum ;
        boolean add1 = false;
        int i=a.length()-1, j=b.length()-1;
        while(i>=0 || j>=0){
            if (add1){
                bitSum = 1;
                add1 = false;
            }else{
                bitSum = 0;
            }

            if(i>=0){
                bitSum += (a.charAt(i)-48);
                i--;
            }
            if(j>=0) {
                bitSum += (b.charAt(j)-48);
                j--;
            }

            if(bitSum >= 2){
                add1 = true;
                bitSum %= 2;
            }
            sb.append(bitSum);
        }
        if(add1){
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    /**
     * 66 加一
     给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
     你可以假设除了整数 0 之外，这个整数不会以零开头。
     示例 1:
     输入: [1,2,3]
     输出: [1,2,4]
     解释: 输入数组表示数字 123。
     示例 2:
     输入: [4,3,2,1]
     输出: [4,3,2,2]
     解释: 输入数组表示数字 4321。
     */
    public int[] plusOne(int[] digits) {
        boolean add1 = false;
        int sum;
        int i=digits.length-1;
        while(i>=0){
            if(add1 || i==digits.length-1){
                sum = 1;
                add1 = false;
            }else {
                sum = 0;
            }
            if(sum == 0){
                return digits;
            }

            sum += digits[i];
            if(sum >= 10){
                add1 = true;
                sum -= 10;
            }
            digits[i] = sum;
            i--;
            if(i<0 && add1){
                int[] a = new int[digits.length + 1];
                a[0] = 1;
                for(int k=1; k<a.length ; k++){
                    a[k] = digits[k-1];
                }
                return a;
            }
        }
        return digits;
    }


    /**
     * 876. 链表的中间结点
     给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
     如果有两个中间结点，则返回第二个中间结点。
     */
    public ListNode middleNode(ListNode head) {
        ListNode x1 = head,x2 = head;
        while(x2 != null && x2.next != null){
            x1=x1.next;
            x2=x2.next.next;
        }
        return x1;
    }


    /**
     * 8 字符串转换整数 (atoi) 中等
     * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
     首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
     当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
     该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
     注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
     在任何情况下，若函数不能进行有效的转换时，请返回 0。
     说明：
     假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，qing返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。

     示例 1:
     输入: "42"
     输出: 42

     示例 2:
     输入: "   -42"
     输出: -42
     解释: 第一个非空白字符为 '-', 它是一个负号。
     我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。

     示例 3:
     输入: "4193 with words"
     输出: 4193
     解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。

     示例 4:
     输入: "words and 987"
     输出: 0
     解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
     因此无法执行有效的转换。

     示例 5:
     输入: "-91283472332"
     输出: -2147483648
     解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
     因此返回 INT_MIN (−231) 。
     */
    public int myAtoi(String str) {
        str = str.trim();
        if(str.length() == 0){
            return 0;
        }
        char c = str.charAt(0);
        int bit = c-48;
        if(c!='-' && c!='+' && (bit<0 || bit>9)){
            return 0;
        }
        boolean posi = c=='-'? true : false;
        int max = Integer.MAX_VALUE /10;
        int maxLast = Integer.MAX_VALUE %10;
        int min = Integer.MIN_VALUE /10;
        int minLast = Integer.MIN_VALUE %10;

        int num = (c =='+' || c=='-') ? 0 : bit;
        for(int i=1; i<str.length(); i++){
            c = str.charAt(i);
            bit = c-48;
            if(bit < 0 || bit > 9){
                return num;
            }
            if(num > max || (num == max && bit>maxLast)){
                return Integer.MAX_VALUE;
            }
            if(num < min || (num == min && bit>(-minLast))){
                return Integer.MIN_VALUE;
            }
            if(num != 0){
                num *= 10;
            }
            if(posi){
                num -= bit;
            }else{
                num += bit;
            }
        }
        return num;
    }

    /**
     * 20 有效的括号
     给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     有效字符串需满足：
     左括号必须用相同类型的右括号闭合。
     左括号必须以正确的顺序闭合。
     注意空字符串可被认为是有效字符串。
     示例 1:
     输入: "()"
     输出: true
     示例 2:
     输入: "()[]{}"
     输出: true
     示例 3:
     输入: "(]"
     输出: false
     示例 4:
     输入: "([)]"
     输出: false
     示例 5:
     输入: "{[]}"
     输出: true
     */
    public boolean isValid(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            switch(c){
                case '(':{
                    sb.append(")");
                    break;}
                case '[':{
                    sb.append("]");
                    break;}
                case '{':{
                    sb.append("}");
                    break;}
                case ')':{
                    if(sb.length()>0 && sb.charAt(sb.length()-1) == ')'){
                        sb.delete(sb.length()-1, sb.length());
                    }else{
                        return false;
                    }
                    break;}
                case ']':{
                    if(sb.length()>0 && sb.charAt(sb.length()-1) == ']'){
                        sb.delete(sb.length()-1, sb.length());
                    }else{
                        return false;
                    }
                    break;}
                case '}':{
                    if(sb.length()>0 && sb.charAt(sb.length()-1) == '}'){
                        sb.delete(sb.length()-1, sb.length());
                    }else{
                        return false;
                    }
                    break;}
                default:break;
            }
        }
        return sb.length()==0? true:false;
    }


    /**
     * 22 括号生成 中等
     * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
     例如，给出 n = 3，生成结果为：
     [
     "((()))",
     "(()())",
     "(())()",
     "()(())",
     "()()()"
     ]
     */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generateParenthesis("(",list,n-1,n,1);
        return list;
    }
    private void generateParenthesis(String str, List<String> list, int x, int y, int sum){
        if(x > 0){
            generateParenthesis(str + "(", list, x-1, y, sum+1);
        }
        if(y>0 && sum>0){
            if(x==0 && y==1){
                list.add(str + ")");
            }else{
                generateParenthesis(str + ")", list, x, y-1, sum-1);
            }
        }
    }

    /**
     * 21 合并两个有序链表  将两个有序链表合并为一个新的有序链表并返回
     输入：1->2->4, 1->3->4
     输出：1->1->2->3->4->4
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode first = new ListNode(0);
        ListNode node = first;
        while(l1 != null || l2 != null){
            if(l1 != null && l2 != null){
                if(l1.val < l2.val){
                    node.next = new ListNode(l1.val);
                    node = node.next;
                    l1 = l1.next;
                }else{
                    node.next = new ListNode(l2.val);
                    node = node.next;
                    l2 = l2.next;
                }
            }else if(l1 != null){
                node.next = new ListNode(l1.val);
                node = node.next;
                l1 = l1.next;
            }else{
                node.next = new ListNode(l2.val);
                node = node.next;
                l2 = l2.next;
            }
        }
        return first.next;
    }

}
