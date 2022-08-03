package com.mqd.leetcode.easy;

import com.mqd.utils.TimeStatistic;

/**
 * leetcode 1886. 判断矩阵经轮转后是否一致
 * 给你两个大小为 n x n 的二进制矩阵 mat 和 target 。现 以 90 度顺时针轮转 矩阵 mat 中的元素 若干次 ，
 * 如果能够使 mat 与target 一致，返回 true ；否则，返回 false 。
 */
public class L1886 {
    public static void main(String[] args) {
        Solution p = new Solution();
        int[][] mat = {{0,0,0},{0,1,0},{1,1,1}};
        int[][] tar = {{1,1,1},{0,1,0},{0,0,0}};
        TimeStatistic.func(() -> System.out.println(p.findRotation(mat, tar)));
    }

    static class Solution {
        public boolean findRotation(int[][] mat, int[][] target) {
            boolean flag1 = true, flag2 = true, flag3 = true, flag4 = true;

            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat.length; j++) {
                    flag1 = flag1 && mat[i][j] == target[i][j];
                    // 左旋90度比较
                    flag2 = flag2 && mat[mat.length - 1 - j][i] == target[i][j];
                    // 右旋90度比较
                    flag3 = flag3 && mat[j][mat.length - 1 - i] == target[i][j];
                    // 180度
                    flag4 = flag4 && mat[mat.length - 1 - i][mat.length - 1 - j] == target[i][j];
                }
            }
            return flag1 || flag2 || flag3 || flag4;
        }
    }
}
