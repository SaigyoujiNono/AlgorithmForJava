package com.mqd.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 1. 两数之和
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 */
public class L1 {

    public static void main(String[] args) {
        Solution p = new Solution();
        int[] arr = {2,7,11,15};
        System.out.println(Arrays.toString(p.twoSum(arr, 9)));
    }

    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            int[] ans = new int[2];
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(target - nums[i])) {
                    ans = new int[]{map.get(target - nums[i]), i};
                    break;
                }
                map.put(nums[i], i);
            }
            return ans;
        }
    }
}
