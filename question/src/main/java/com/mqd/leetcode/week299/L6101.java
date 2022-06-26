package com.mqd.leetcode.week299;

import com.mqd.utils.TimeStatistic;

/**
 * leetcode 6101. 判断矩阵是否是一个 X 矩阵
 * 如果一个正方形矩阵满足下述 全部 条件，则称之为一个 X 矩阵 ：
 *
 * 矩阵对角线上的所有元素都 不是 0
 * 矩阵中所有其他元素都是 0
 * 给你一个大小为 n x n 的二维整数数组 grid ，
 * 表示一个正方形矩阵。如果 grid 是一个 X 矩阵 ，返回 true ；否则，返回 false 。
 */
public class L6101 {
    public static void main(String[] args) {
        L6101 p = new L6101();
        int[][] grid = {{2,0,0,0,0},{0,4,0,1,0},{0,0,5,0,0},{0,5,0,2,0},{4,0,0,0,2}};
        TimeStatistic.func(() -> System.out.println(p.checkXMatrix(grid)));
    }

    public boolean checkXMatrix(int[][] grid) {
        int len = grid.length;
        int index = 0;
        int x = len - 1;
        int y = 0;
        while (index < len && y < len && x >= 0) {
            if (grid[index][index] == 0 || grid[y][x] == 0) {
                return false;
            } else {
                grid[index][index] = -1;
                grid[y][x] = -1;
            }
            for (int i = 0; i < grid[index].length; i++) {
                if (grid[index][i] != -1 && grid[index][i] != 0) {
                    return false;
                }
            }
            index++;
            y++;
            x--;
        }
        return true;
    }
}
