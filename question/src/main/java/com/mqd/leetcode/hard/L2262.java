package com.mqd.leetcode.hard;

import com.mqd.utils.TimeStatistic;

import java.util.*;

/**
 * leetcode 2262. 字符串的总引力
 * 字符串的 引力 定义为：字符串中 不同 字符的数量。
 *
 * 例如，"abbca" 的引力为 3 ，因为其中有 3 个不同字符 'a'、'b' 和 'c' 。
 * 给你一个字符串 s ，返回 其所有子字符串的总引力 。
 *
 * 子字符串 定义为：字符串中的一个连续字符序列。
 */
public class L2262 {
    public static void main(String[] args) {
        String str = "abbca";
        L2262 p = new L2262();
        TimeStatistic.func(() -> System.out.println(p.appealSum(str)));
    }

    public long appealSum(String s) {
        long res = 0;
        int[] tail = new int[26];
        Arrays.fill(tail, -1);
        char[] chars = s.toCharArray();
        int sumG = 0;
        for (int i = 0; i < chars.length; i++) {
            int c = chars[i] - 'a';
            sumG += i - tail[c];
            res += sumG;
            tail[c] = i;
        }
        return res;
    }

    /**
     * 超时
     */
    public long appealSum1(String s) {
        long res = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < chars.length; j++) {
                set.add(chars[j]);
                res += set.size();
            }
        }
        return res;
    }
}
