package com.mqd.leetcode.doubleweek85;

import com.mqd.utils.TimeStatistic;

import java.util.Random;

/**
 * leetcode 6157. 二进制字符串重新安排顺序需要的时间
 * 给你一个二进制字符串 s 。在一秒之中，所有 子字符串 "01" 同时 被替换成 "10" 。这个过程持续进行到没有 "01" 存在。
 *
 * 请你返回完成这个过程所需要的秒数。
 */
public class L6157 {

    public static void main(String[] args) {
        Solution p = new Solution();
        Random random = new Random(System.nanoTime());
        StringBuilder t1 = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            if (random.nextBoolean()) t1.append("1");
            else t1.append("0");
        }
        TimeStatistic.func(() -> System.out.println(p.secondsToRemoveOccurrences(t1.toString())));
    }

    static class Solution {
        public int secondsToRemoveOccurrences(String s) {
            int ans = 0;
            String t = s;
            while (t.contains("01")) {
                t = t.replaceAll("01", "10");
                ans++;
            }
            return ans;
        }
    }
}
