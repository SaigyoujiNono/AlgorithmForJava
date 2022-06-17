package com.mqd.leetcode.medium;

import com.mqd.utils.TimeStatistic;

/**
 * leetcode 397 整数替换
 * 给定一个正整数 n ，你可以做如下操作：
 *
 * 如果 n 是偶数，则用 n / 2替换 n 。
 * 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
 * 返回 n 变为 1 所需的 最小替换次数 。
 */
public class L397 {

    public static void main(String[] args) {
        L397 p = new L397();
        TimeStatistic.func(() -> {
            System.out.println(p.integerReplacement(2147483647));
        });
    }

    public int integerReplacement(int n) {
        return process(n);
    }

    private int process(long n) {
        if (n == 1) {
            return 0;
        }
        if (n % 2 == 0) {
            return process(n >> 1) + 1;
        }
        return Math.min(process(n - 1), process(n + 1)) + 1;
    }

}
