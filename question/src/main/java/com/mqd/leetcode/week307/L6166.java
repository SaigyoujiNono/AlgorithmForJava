package com.mqd.leetcode.week307;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 6166. 最大回文数字
 * 给你一个仅由数字（0 - 9）组成的字符串 num 。
 *
 * 请你找出能够使用 num 中数字形成的 最大回文 整数，并以字符串形式返回。该整数不含 前导零 。
 *
 * 注意：
 *
 * 你 无需 使用 num 中的所有数字，但你必须使用 至少 一个数字。
 * 数字可以重新排序。
 */
public class L6166 {

    public static void main(String[] args) {
        Solution p = new Solution();
        System.out.println(p.largestPalindromic("444947137"));
        System.out.println(p.largestPalindromic("00009"));
        System.out.println(p.largestPalindromic("00001105"));
    }

    static class Solution {
        public String largestPalindromic(String num) {
            int[] sums = new int[10];
            char[] cs = num.toCharArray();
            for (char c : cs) {
                sums[c - '0'] = sums[c - '0'] + 1;
            }
            StringBuilder left = new StringBuilder();
            StringBuilder right = new StringBuilder();
            for (int i = 9; i >= 0; i--) {
                if (sums[i] / 2 > 0) {
                    char[] chars = new char[sums[i] / 2];
                    Arrays.fill(chars, (char) (i + '0'));
                    if (i != 0 || left.length() != 0) {
                        left.append(chars);
                        right.append(chars);
                        sums[i] -= (sums[i] / 2 * 2);
                    }
                }
            }
            for (int i = 9; i >= 0; i--) {
                if (sums[i] > 0) {
                    return left + String.valueOf((char)(i + '0')) + right.reverse();
                }
            }
            if (sums[0] != 0 && left.length() == 0) return "0";
            return left + right.reverse().toString();
        }
    }
}
