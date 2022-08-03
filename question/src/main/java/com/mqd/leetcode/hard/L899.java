package com.mqd.leetcode.hard;

import java.util.Arrays;

/**
 * leetcode 899. 有序队列
 * 给定一个字符串 s 和一个整数 k。你可以从 s 的前 k 个字母中选择一个，并把它加到字符串的末尾。
 *
 * 返回 在应用上述步骤的任意数量的移动后，字典上最小的字符串。
 *
 */
public class L899 {
    public static void main(String[] args) {
        Solution p = new Solution();
        System.out.println(p.orderlyQueue("cba", 1));
    }
    static class Solution {
        public String orderlyQueue(String s, int k) {
            if (s.length() <= 1 || k <= 0) return s;
            if (k == 1) {
                int i = 1;
                String min = s;
                while (i < s.length()) {
                    String cmpStr = s.substring(i) + s.substring(0, i);
                    int comRes = min.compareTo(cmpStr);
                    if (comRes > 0) {
                        min = cmpStr;
                    }
                    i++;
                }
                return min;
            } else {
                char[] cs = s.toCharArray();
                Arrays.sort(cs);
                return String.valueOf(cs);
            }
        }
    }
}
