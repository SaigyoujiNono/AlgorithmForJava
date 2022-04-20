package com.mqd;

import java.util.*;

/**
 * 字符串括号问题
 * ()()算一个字符串，)()(不算
 */
public class StringBracket {
    static Random random = new Random(System.currentTimeMillis());
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100000000; i++) {
            if (random.nextInt(2) == 0) {
                sb.append("(");
            }else {
                sb.append(")");
            }
        }
        String s = sb.toString();
        long t1 = System.currentTimeMillis();
        System.out.println(solution1(s));   //1842
        long t2 = System.currentTimeMillis();
        System.out.println("solution1: " + (t2-t1));
        System.out.println(solution2(s));   //473
        long t3 = System.currentTimeMillis();
        System.out.println("solution2: " + (t3-t2));
    }

    /**
     * 思路：栈
     * @param str  字符串
     * @return  最少需要添加一个括号
     */
    public static int solution1(String str) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') { //如果是左括号直接入栈
                stack.push(i);
            }else if (str.charAt(i) == ')') {
                if (stack.empty()) {    //如果为空右括号直接入栈
                    stack.push(i);
                }else {
                    if (str.charAt(stack.peek()) == '(') {
                        stack.pop();
                    }else {
                        stack.push(i);
                    }
                }
            }
        }
        return stack.size();
    }

    /**
     * 思路：count遇到左括号+1，遇到右括号-1
     * @param str  字符串
     * @return  最少需要添加一个括号
     */
    public static int solution2(String str) {
        int count = 0;
        int countR = 0;
        ArrayList<Character> characters = new ArrayList<>(str.length());
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                count++;
            }else if (str.charAt(i) == ')') {
                if (count == 0) countR++;
                else count--;
            }
        }
        return count + countR;
    }

}
