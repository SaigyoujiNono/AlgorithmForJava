package com.mqd.leetcode.medium;

import com.mqd.utils.TimeStatistic;

import java.util.*;

/**
 * leetcode 1338. 数组大小减半
 * 给你一个整数数组 arr。你可以从中选出一个整数集合，并删除这些整数在数组中的每次出现。
 *
 * 返回 至少 能删除数组中的一半整数的整数集合的最小大小。
 */
public class L1338 {

    public static void main(String[] args) {
        Solution p = new Solution();
        int[] arr = {3,3,3,3,5,5,5,2,2,7};
        TimeStatistic.func(() -> System.out.println(p.minSetSize(arr)));

    }

    static class Solution {
        public int minSetSize(int[] arr) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j : arr) {
                map.put(j, map.getOrDefault(j, 0) + 1);
            }
            List<Integer> list = new ArrayList<>();
            map.forEach((k, v) -> list.add(v));
            list.sort((x1, x2) -> x2 -x1);
            int sum = 0;
            for (int i = 0; i < list.size(); i++) {
                sum += list.get(i);
                if (sum >= (arr.length / 2)) {
                    return i + 1;
                }
            }
            return arr.length;
        }
    }
}
