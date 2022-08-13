package com.mqd.leetcode.easy;

/**
 * leetcode 1556. 千位分隔数
 */
public class L1556 {

    public static void main(String[] args) {
        Solution p = new Solution();
        System.out.println(p.thousandSeparator(1045100040));
    }

    static class Solution {
        public String thousandSeparator(int n) {
            StringBuilder s = new StringBuilder(String.valueOf(n));
            int index = s.length();
            index -= 3;
            while (index > 0) {
                s.insert(index, '.');
                index -= 3;
            }
            return s.toString();
        }
    }
}
