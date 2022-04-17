package com.mqd;

import java.util.HashMap;
import java.util.Map;

/**
 * 有一个函数f 可以等概率随机返回1-5的数字 加工出等概率返回1-7的函数g
 * 有一个函数f 可以等概率返回a-b，加工出等概率返回c-d数字的函数g
 * 有一个函数f 以p概率返回0， 1-p的概率返回1，加工出等概率返回0和1的函数g
 */
public class RandomPlus {

    public static void main(String[] args) {
        Map<Integer,Integer> distribution = new HashMap<>();
        for (int i = 0; i < 100000; i++) {
            int num = solution();
            distribution.put(num, distribution.getOrDefault(num, 0)+1);
        }
        System.out.println(distribution);
    }

    public static int solution() {
        int res = (bin()<<2) + (bin() << 1) + bin();
        return res == 7 ? solution() : res+1;
    }

    // 二进制思路，设计一个函数可以等概率返回1或者0，拼成最终数
    public static int bin() {
        int i = f();
        if (i > 3) {
            return 1;
        }else if (i < 3) {
            return 0;
        }
        return bin();
    }

    // 等概率返回1-5
    public static int f() {
        return (int)(Math.random()*5+1);
    }
}
