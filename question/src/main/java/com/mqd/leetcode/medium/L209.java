package com.mqd.leetcode.medium;

/**
 * leetcode 209 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 */
public class L209 {
    public static void main(String[] args) {
        L209 p = new L209();
        System.out.println(p.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int r = 0;
        int res = nums[r];
        int min = Integer.MAX_VALUE;
        int count = 1;
        while (res >= target || r != nums.length - 1) {
            if (res >= target) {
                min = Math.min(min, count);
                res -= nums[l];
                count--;
                l++;
            } else {
                if (r < nums.length - 1) {
                    r++;
                    res += nums[r];
                    count++;
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

}
