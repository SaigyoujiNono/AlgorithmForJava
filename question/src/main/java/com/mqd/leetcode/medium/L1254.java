package com.mqd.leetcode.medium;

/**
 * leetcode 1254. 统计封闭岛屿的数目
 * 二维矩阵 grid由 0（土地）和 1（水）组成。岛是由最大的4个方向连通的 0组成的群，封闭岛是一个完全 由1包围（左、上、右、下）的岛。
 * <p>
 * 请返回 封闭岛屿 的数目。
 */
public class L1254 {

    public static void main(String[] args) {
        Solution p = new Solution();
        int[][] g = {
                {0, 0, 1, 1, 0, 1, 0, 0, 1, 0},
                {1, 1, 0, 1, 1, 0, 1, 1, 1, 0},
                {1, 0, 1, 1, 1, 0, 0, 1, 1, 0},
                {0, 1, 1, 0, 0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0, 1, 1, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1, 1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 1, 0, 1, 0, 1},
                {1, 1, 1, 0, 1, 1, 0, 1, 1, 0}
        };
        System.out.println(p.closedIsland(g));
    }

    static class Solution {
        public int closedIsland(int[][] grid) {
            if (grid == null || grid.length < 3 || grid[0].length < 3) return 0;
            int ans = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 0 && dfs(grid, i, j)) {
                        ans++;
                    }
                }
            }
            return ans;
        }

        private boolean dfs(int[][] g, int r, int c) {
            if (r < 0 || c < 0 || r >= g.length || c >= g[0].length) {
                return false;
            }
            if (g[r][c] == 1 || g[r][c] == 2) {
                return true;
            }
            g[r][c] = 2;
            return dfs(g, r + 1, c) & dfs(g, r - 1, c) & dfs(g, r, c - 1) & dfs(g, r, c + 1);
        }

    }
}
