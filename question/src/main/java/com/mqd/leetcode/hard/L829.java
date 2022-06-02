package com.mqd.leetcode.hard;


import com.mqd.utils.TimeStatistic;

/**
 * leetcode 829 连续整数求和
 * 给定一个正整数 n，返回 连续正整数满足所有数字之和为 n 的组数 。
 */
public class L829 {
    public static void main(String[] args) {
        L829 p = new L829();
        TimeStatistic.func(() -> {
            int res = p.consecutiveNumbersSum(15);
            System.out.println(res);
//            for (int i = 0; i < 10000; i++) {
//                int res = p.consecutiveNumbersSum(i);
//                if (res > 1) {
//                    System.out.println(i + " - " + res);
//                }
//            }
        });
    }

    public int consecutiveNumbersSum(int n) {
        if (n <= 2) {
            return 1;
        }
        int res = 0;
        int s = 0;
        for (int i = 1; i <= n ; i++) {
            if (n - s > 0 && (n - s) % i == 0) {
                res++;
            }
            s += i;
            if (s > n) {
                break;
            }
        }
        return res;
    }
}
