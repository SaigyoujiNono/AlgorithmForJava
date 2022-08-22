package com.mqd.leetcode.easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode 733. 图像渲染
 * 有一幅以m x n的二维整数数组表示的图画image，其中image[i][j]表示该图画的像素值大小。
 *
 * 你也被给予三个整数 sr , sc 和 newColor 。你应该从像素image[sr][sc]开始对图像进行 上色填充 。
 *
 * 为了完成 上色工作 ，从初始像素开始，记录初始坐标的 上下左右四个方向上 像素值与初始坐标相同的相连像素点，
 * 接着再记录这四个方向上符合条件的像素点与他们对应 四个方向上 像素值与初始坐标相同的相连像素点，……，重复该过程。
 * 将所有有记录的像素点的颜色值改为newColor。
 *
 * 最后返回 经过上色渲染后的图像。
 */
public class L733 {

    public static void main(String[] args) {
        Solution p = new Solution();
        int[][] im = {
                {0,0,0},
                {0,0,0}
        };
        int sr = 0;
        int sc = 0;
        int newColor = 0;
        System.out.println(Arrays.deepToString(p.floodFill(im, sr, sc, newColor)));
    }

    static class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            if (image == null || image.length == 0 || sr < 0 || sc < 0 || sr > image.length || sc > image[0].length || image[sr][sc] == color) {
                return image;
            }
            int base = image[sr][sc];
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{sr, sc});
            while (!q.isEmpty()) {
                int[] poll = q.poll();
                image[poll[0]][poll[1]] = color;
                if (poll[0] - 1 >= 0 && image[poll[0] - 1][poll[1]] == base) q.add(new int[]{poll[0] - 1, poll[1]});
                if (poll[0] + 1 < image.length && image[poll[0] + 1][poll[1]] == base) q.add(new int[]{poll[0] + 1, poll[1]});
                if (poll[1] - 1 >= 0 && image[poll[0]][poll[1] - 1] == base) q.add(new int[]{poll[0], poll[1] - 1});
                if (poll[1] + 1 < image[0].length && image[poll[0]][poll[1] + 1] == base) q.add(new int[]{poll[0], poll[1] + 1});
            }
            return image;
        }
    }
}
