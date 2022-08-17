package com.mqd.leetcode.easy;

/**
 * leetcode 1232. 缀点成线.
 * 给定一个数组coordinates，其中coordinates[i] = [x, y]，[x, y]表示横坐标为 x、纵坐标为 y的点。
 * 请你来判断，这些点是否在该坐标系中属于同一条直线上。
 */
public class L1232 {

    static class Solution {
        public boolean checkStraightLine(int[][] coordinates) {
            if (coordinates.length <= 2) return true;
            int rateY = coordinates[1][1] - coordinates[0][1];
            int rateX = coordinates[1][0] - coordinates[0][0];
            double rate = rateX == 0 ? Double.MAX_VALUE : (double)rateY / (double)rateX;
            // System.out.println(rate + " : --");
            for(int i = 2; i < coordinates.length; i++) {
                int rY = coordinates[i][1] - coordinates[i - 1][1];
                int rX = coordinates[i][0] - coordinates[i - 1][0];
                double r = rX == 0 ? Double.MAX_VALUE : (double)rY / (double)rX;
                if (r != rate) {
                    // System.out.println(rate + " : " + r);
                    return false;
                }
            }
            return true;
        }
    }
}
