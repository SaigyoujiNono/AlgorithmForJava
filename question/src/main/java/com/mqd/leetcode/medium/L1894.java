package com.mqd.leetcode.medium;

/**
 * leetcode 1894. 找到需要补充粉笔的学生编号
 * 一个班级里有n个学生，编号为 0到 n - 1。每个学生会依次回答问题，编号为 0的学生先回答，然后是编号为 1的学生，以此类推，直到编号为 n - 1的学生，然后老师会重复这个过程，重新从编号为 0的学生开始回答问题。
 *
 * 给你一个长度为 n且下标从 0开始的整数数组chalk和一个整数k。一开始粉笔盒里总共有k支粉笔。当编号为i的学生回答问题时，他会消耗 chalk[i]支粉笔。如果剩余粉笔数量 严格小于chalk[i]，那么学生 i需要 补充粉笔。
 *
 * 请你返回需要 补充粉笔的学生 编号。
 */
public class L1894 {
    public static void main(String[] args) {
        Solution p = new Solution();
        int[] arr = {};
        System.out.println(p.chalkReplacer(arr, 539095482));
    }

    static class Solution {
        public int chalkReplacer(int[] chalk, int k) {
            long sum = 0;
            long[] temp = new long[chalk.length];
            for (int i = 0; i < chalk.length; i++) {
                sum += chalk[i];
                temp[i] = sum;
            }
            long s = k;
            s = s % sum;
            for (int i = 0; i < chalk.length; i++) {
                if (temp[i] > s) {
                    return i;
                }
            }
            return 0;
        }
    }
}
