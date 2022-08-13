package com.mqd.leetcode.easy;

/**
 * leetcode 1422. 分割字符串的最大得分
 * 给你一个由若干 0 和 1 组成的字符串 s ，请你计算并返回将该字符串分割成两个 非空 子字符串（即左 子字符串和 右 子字符串）所能获得的最大得分。
 *
 * 「分割字符串的得分」为 左 子字符串中 0 的数量加上 右 子字符串中 1 的数量。
 */
public class L1422 {

    public static void main(String[] args) {
        Solution p = new Solution();
        System.out.println(p.maxScore("00"));
    }


    static class Solution {
        public int maxScore(String s) {
            int ans = 0;
            int left;
            int right;
            int one = 0;
            char[] chars = s.toCharArray();
            for (char aChar : chars) {
                if (aChar == '1') one++;
            }
            left = 0;
            right = one;
            for (int i = 0; i < chars.length - 1; i++) {
                if (chars[i] == '1') {
                    right--;
                } else {
                    left++;
                }
                ans = Math.max(ans, left + right);
            }
            return ans;
        }
    }
}
