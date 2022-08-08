package com.mqd.leetcode.doubleweek84;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * leetcode 6141. 合并相似的物品
 * 给你两个二维整数数组 items1 和 items2 ，表示两个物品集合。每个数组 items 有以下特质：
 *
 * items[i] = [valuei, weighti] 其中 valuei 表示第 i 件物品的 价值 ，weighti 表示第 i 件物品的 重量 。
 * items 中每件物品的价值都是 唯一的 。
 * 请你返回一个二维数组 ret，其中 ret[i] = [valuei, weighti]， weighti 是所有价值为 valuei 物品的 重量之和 。
 *
 * 注意：ret 应该按价值 升序 排序后返回。
 */
public class L6141 {

    static class Solution {
        public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
            List<List<Integer>> ans = new ArrayList<>();
            Arrays.sort(items1, Comparator.comparingInt(x -> x[0]));
            Arrays.sort(items2, Comparator.comparingInt(x -> x[0]));
            int i1 = 0;
            int i2 = 0;
            while (i1 < items1.length || i2 < items2.length) {
                if (i1 < items1.length && i2 < items2.length) {
                    if (items1[i1][0] < items2[i2][0]) {
                        List<Integer> list = List.of(items1[i1][0], items1[i1][1]);
                        ans.add(list);
                        i1++;
                    } else if (items1[i1][0] > items2[i2][0]) {
                        List<Integer> list = List.of(items2[i2][0], items2[i2][1]);
                        ans.add(list);
                        i2++;
                    } else {
                        List<Integer> list = List.of(items1[i1][0], items1[i1][1] + items2[i2][1]);
                        ans.add(list);
                        i1++;
                        i2++;
                    }
                } else {
                    if (i1 < items1.length) {
                        List<Integer> list = List.of(items1[i1][0], items1[i1][1]);
                        ans.add(list);
                        i1++;
                    } else {
                        List<Integer> list = List.of(items2[i2][0], items2[i2][1]);
                        ans.add(list);
                        i2++;
                    }
                }
            }
            return ans;
        }
    }
}
