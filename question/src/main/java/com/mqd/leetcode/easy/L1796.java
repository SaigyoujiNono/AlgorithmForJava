package com.mqd.leetcode.easy;

/**
 * leetcode 1796 字符串中第二大的数字
 * 给你一个混合字符串 s ，请你返回 s 中 第二大 的数字，如果不存在第二大的数字，请你返回 -1 。
 *
 * 混合字符串 由小写英文字母和数字组成。
 */
public class L1796 {
    public int secondHighest(String s) {
        char[] chars = s.toCharArray();
        int first = -1;
        int second = -1;
        for (char aChar : chars) {
            if (aChar >= '0' && aChar <= '9') {
                int max = aChar - '0';
                if (max > first) {
                    second = first;
                    first = max;
                } else if (max < first && max >second) {
                    second = max;
                }
            }
        }
        return second;
    }
}
