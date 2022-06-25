package com.mqd.leetcode.doubleweek81;

import com.mqd.utils.TimeStatistic;

/**
 * leetcode 6104. 统计星号
 * 给你一个字符串 s ，每 两个 连续竖线 '|' 为 一对 。换言之，第一个和第二个 '|' 为一对，第三个和第四个 '|' 为一对，以此类推。
 *
 * 请你返回 不在 竖线对之间，s 中 '*' 的数目。
 *
 * 注意，每个竖线 '|' 都会 恰好 属于一个对。
 */
public class L6104 {
    public static void main(String[] args) {
        L6104 p = new L6104();
        TimeStatistic.func(() -> System.out.println(p.countAsterisks("yo|uar|e**|b|e***au|tifu|l")));
    }

    public int countAsterisks(String s) {
        char[] chars = s.toCharArray();
        int lCount = 0;
        int res = 0;
        for (char aChar : chars) {
            if (aChar == '|') {
                lCount++;
            } else if (lCount % 2 == 0 && aChar == '*') {
                res++;
            }
        }
        return res;
    }
}
