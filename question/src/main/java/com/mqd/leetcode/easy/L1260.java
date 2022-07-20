package com.mqd.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 1260. 二维网格迁移
 * 给你一个 m 行 n列的二维网格grid和一个整数k。你需要将grid迁移k次。
 *
 * 每次「迁移」操作将会引发下述活动：
 *
 * 位于 grid[i][j]的元素将会移动到grid[i][j + 1]。
 * 位于grid[i][n- 1] 的元素将会移动到grid[i + 1][0]。
 * 位于 grid[m- 1][n - 1]的元素将会移动到grid[0][0]。
 * 请你返回k 次迁移操作后最终得到的 二维网格。
 */
public class L1260 {

    public static void main(String[] args) {
        L1260 p = new L1260();
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
//        int[][] arr = {{1},{2},{3},{4},{7},{6},{5}};
        System.out.println(p.shiftGrid(arr, 2));
    }

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int row = grid.length;
        int col = grid[0].length;
        int len = row * col;
        k = k % len;
        List<Integer> rowL = null;
        for (int i = len - k; i < 2 * len - k; i++) {
            if (rowL == null) {
                rowL = new ArrayList<>();
            }
            if (rowL.size() < col) {
                rowL.add(grid[i % len / col][i % col]);
            } else {
                res.add(rowL);
                rowL = null;
                i--;
            }
        }
        res.add(rowL);
        return res;
    }
}
