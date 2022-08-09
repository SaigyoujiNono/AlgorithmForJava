package com.mqd.leetcode.easy;

/**
 * leetcode 1413. 逐步求和得到正数的最小值
 * 给你一个整数数组 nums。你可以选定任意的正数 startValue 作为初始值。
 *
 * 你需要从左到右遍历 nums数组，并将 startValue 依次累加上nums数组中的值。
 *
 * 请你在确保累加和始终大于等于 1 的前提下，选出一个最小的正数作为 startValue 。
 */
public class L1413 {

    public static void main(String[] args) {
        Solution p = new Solution();
//        int[] arr = {-3,2,-3,4,2};
        int[] arr = {1,2};
        System.out.println(p.minStartValue(arr));
    }

    static class Solution {
        public int minStartValue(int[] nums) {
            int startValue = 1;
            int ans = startValue;
            for (int num : nums) {
                ans += num;
                if (ans < 1) {
                    startValue += (1-ans);
                    ans += (1-ans);
                }
            }
            return startValue;
        }
    }
}
