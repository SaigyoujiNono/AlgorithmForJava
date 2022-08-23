package com.mqd.leetcode.medium;

/**
 * leetcode 1375. 二进制字符串前缀一致的次数
 * 给你一个长度为 n 、下标从 1 开始的二进制字符串，所有位最开始都是 0 。
 * 我们会按步翻转该二进制字符串的所有位（即，将 0 变为 1）。
 *
 * 给你一个下标从 1 开始的整数数组 flips ，其中 flips[i] 表示对应下标 i 的位将会在第 i 步翻转。
 *
 * 二进制字符串 前缀一致 需满足：在第 i 步之后，在 闭 区间[1, i] 内的所有位都是 1 ，而其他位都是 0 。
 *
 * 返回二进制字符串在翻转过程中 前缀一致 的次数。
 * 
 */
public class L357 {


    public static void main(String[] args) {
        Solution p = new Solution();
        int[] t = {3,2,4,1,5};
        System.out.println(p.numTimesAllBlue(t));
    }

    static class Solution {
        public int numTimesAllBlue(int[] flips) {
            int ans = 0;
            int maxOne = -1;
            for (int i = 0; i < flips.length; i++) {
                maxOne = Math.max(maxOne, flips[i]);
                if (i + 1 == maxOne) {
                    ans++;
                }
            }
            return ans;
        }
    }
}
