package com.mqd.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * leetcode 840. 矩阵中的幻方
 * 3 x 3 的幻方是一个填充有从 1 到 9 的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。
 *
 * 给定一个由整数组成的row x col的 grid，其中有多少个3 × 3 的 “幻方” 子矩阵？（每个子矩阵都是连续的）。
 */
public class L840 {

    public static void main(String[] args) {
        Solution p = new Solution();
        int[][] a = {
                {7,6,2,2,4},
                {4,4,9,2,10},
                {9,7,8,3,10},
                {8,1,9,7,5},
                {7,10,4,11,6}
        };
        System.out.println(p.numMagicSquaresInside(a));
    }

    static class Solution {
        public int numMagicSquaresInside(int[][] grid) {
            int ans = 0;
            for (int i = 0; i < grid.length - 2; i++)
                for (int j = 0; j < grid[i].length - 2; j++) ans += isPass(grid, i, j) ? 1 : 0;
            return ans;
        }

        private boolean isPass(int[][] g, int r, int c) {
            Set<Integer> set = new HashSet<>();
            for (int i = r; i < r + 3; i++) {
                for (int j = c; j < c + 3; j++) {
                    if (set.contains(g[i][j]) || g[i][j] < 1 || g[i][j] > 9) return false;
                    set.add(g[i][j]);
                }
            }
            int base = g[r][c] + g[r][c + 1] + g[r][c + 2];
            return base == g[r][c] + g[r][c + 1] + g[r][c + 2] &&
                    base == g[r + 1][c] + g[r + 1][c + 1] + g[r + 1][c + 2] &&
                    base == g[r + 2][c] + g[r + 2][c + 1] + g[r + 2][c + 2] &&
                    base == g[r][c] + g[r + 1][c] + g[r + 2][c] &&
                    base == g[r][c + 1] + g[r + 1][c + 1] + g[r + 2][c + 1] &&
                    base == g[r][c + 2] + g[r + 1][c + 2] + g[r + 2][c + 2] &&
                    base == g[r][c] + g[r + 1][c + 1] + g[r + 2][c + 2] &&
                    base == g[r][c + 2] + g[r + 1][c + 1] + g[r + 2][c];
        }
    }
}
