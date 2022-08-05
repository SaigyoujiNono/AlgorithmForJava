package com.mqd.leetcode.easy;

import com.mqd.utils.TimeStatistic;

import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 119. 杨辉三角 II
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 */
public class L119 {

    public static void main(String[] args) {
        Solution p = new Solution();
        TimeStatistic.func(() -> {
            System.out.println(p.getRow(33));
            System.out.println(p.getRow(25));
        });
    }

    static class Solution {
        public List<Integer> getRow(int rowIndex) {
            if (rowIndex == 0) {
                return List.of(1);
            }
            List<Integer> base = List.of(1, 1);
            if (rowIndex == 1) {
                return base;
            }
            List<Integer> ans;
            for (int i = 2; i <= rowIndex; i++) {
                ans = new LinkedList<>();
                ans.add(1);
                for (int j = 0; j < base.size() - 1; j++) {
                    ans.add(base.get(j) + base.get(j + 1));
                }
                ans.add(1);
                base = ans;
            }
            return base;
        }
    }
}
