package com.mqd.leetcode.medium;

import com.mqd.utils.RandomArrayBuilder;
import com.mqd.utils.TimeStatistic;

/**
 * leetcode 560. 和为 K 的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
 */
public class L560 {

    public static void main(String[] args) {
        Solution p = new Solution();
        int[] arr = {1,-2, 1, 1, 5,-9,14,25,33};
        int[] ints = RandomArrayBuilder.randomArray(-200000, 200000, 10000);
        int k = 0;
        TimeStatistic.func(() -> {
            assert ints != null;
            System.out.println(p.subarraySum(ints, k));
        });
    }

    static class Solution {
        public int subarraySum(int[] nums, int k) {
//            int[] t = new int[nums.length];
//            int s = 0;
//            for (int i = 0; i < t.length; i++) {
//                s += nums[i];
//                t[i] = s;
//            }
            int ans = 0;
            for (int i = 0; i < nums.length; i++) {
                int sum = 0;
                for (int j = i; j >= 0; j--) {
                    sum += nums[j];
                    if (sum == k) ans++;
                }
            }
            return ans;
        }
    }
}
