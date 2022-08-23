package com.mqd.leetcode.easy;

/**
 * leetcode 1957. 删除字符使字符串变好
 * 一个字符串如果没有 三个连续相同字符，那么它就是一个 好字符串。
 *
 * 给你一个字符串s，请你从 s删除最少的字符，使它变成一个 好字符串 。
 *
 * 请你返回删除后的字符串。题目数据保证答案总是 唯一的 。
 */
public class L1957 {

    public static void main(String[] args) {
        Solution p = new Solution();
        System.out.println(p.makeFancyString("leeetcode"));
        System.out.println(p.makeFancyString("aaabaaaa"));
        System.out.println(p.makeFancyString("aab"));
    }

    static class Solution {
        public String makeFancyString(String s) {
            if (s.length() <= 2) return s;
            StringBuilder sb = new StringBuilder();
            char pre = s.charAt(0);
            int count = 1;
            sb.append(pre);
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == pre) {
                    count++;
                } else {
                    pre = s.charAt(i);
                    count = 1;
                }
                if (count < 3) {
                    sb.append(s.charAt(i));
                }
            }
            return sb.toString();
        }
    }
}
