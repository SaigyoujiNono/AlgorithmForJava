package com.mqd.leetcode.medium;

import com.mqd.utils.TimeStatistic;


/**
 * leetcode 45 跳跃游戏 II
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 假设你总是可以到达数组的最后一个位置。
 */
public class L45 {
    public static void main(String[] args) {
        L45 p = new L45();
        int[] arr = {2,3,1,1,4};
        TimeStatistic.func(() -> System.out.println(p.jump(arr)));
    }

    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            int num = nums[i - 1];
            if (dp[dp.length - 1] != 0) {
                break;
            }
            int max = 0;
            for (int j = i; j < Math.min(i + num, dp.length); j++) {
                max = Math.max(max, nums[j]);
                if (dp[j] == 0) {
                    dp[j] = dp[i - 1] + 1;
                }
            }
            i = i + max;
            i--;
        }
        return dp[nums.length - 1];
    }

    public int jump2(int[] nums) {
        int count = 0;
        int r = 0;
        int maxR = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxR = Math.max(nums[i] + i, maxR);
            if (i == r) {
                r = maxR;
                count++;
            }
        }
        return count;
    }


}
