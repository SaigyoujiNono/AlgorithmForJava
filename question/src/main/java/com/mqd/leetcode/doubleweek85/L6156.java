package com.mqd.leetcode.doubleweek85;

/**
 * leetcode 6156. 得到 K 个黑块的最少涂色次数
 * 给你一个长度为 n 下标从 0 开始的字符串 blocks ，
 * blocks[i] 要么是 'W' 要么是 'B' ，表示第 i 块的颜色。字符 'W' 和 'B' 分别表示白色和黑色。
 *
 * 给你一个整数 k ，表示想要 连续 黑色块的数目。
 *
 * 每一次操作中，你可以选择一个白色块将它 涂成 黑色块。
 *
 * 请你返回至少出现 一次 连续 k 个黑色块的 最少 操作次数。
 */
public class L6156 {

    public static void main(String[] args) {
        Solution p = new Solution();
        System.out.println(p.minimumRecolors("WBBWWWWBBWWBBBBWWBBWWBBBWWBBBWWWBWBWW", 15));
    }

    static class Solution {
        public int minimumRecolors(String blocks, int k) {
            if (blocks.length() < k) return -1;
            char[] chars = blocks.toCharArray();
            int W = 0;
            for (int i = 0; i < k; i++) {
                if (chars[i] == 'W') W++;
            }
            int ans = W;
            int r = k;
            while (r < chars.length) {
                if (chars[r] == 'W' && chars[r - k] != 'W') {
                    W++;
                } else if (chars[r] == 'B' && chars[r - k] != 'B'){
                    W--;
                }
                r++;
                ans = Math.min(ans, W);
            }
            return Math.max(ans, 0);
        }
    }
}
