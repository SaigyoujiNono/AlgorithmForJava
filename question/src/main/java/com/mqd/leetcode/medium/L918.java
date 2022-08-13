package com.mqd.leetcode.medium;

/**
 * leetcode 918. 环形子数组的最大和
 * 给定一个长度为 n 的环形整数数组nums，返回nums的非空 子数组 的最大可能和。
 *
 * 环形数组意味着数组的末端将会与开头相连呈环状。形式上，
 * nums[i] 的下一个元素是 nums[(i + 1) % n] ， nums[i]的前一个元素是 nums[(i - 1 + n) % n] 。
 *
 * 子数组 最多只能包含固定缓冲区nums中的每个元素一次。形式上，对于子数组nums[i], nums[i + 1], ..., nums[j]，
 * 不存在i <= k1, k2 <= j其中k1 % n == k2 % n。
 */
public class L918 {

    public static void main(String[] args) {
        Solution p = new Solution();
//        int[] arr = {1,-2,3};
        int[] arr = {8,-4,-7,-5,-1,2,-2,-7,1};
        System.out.println(p.maxSubarraySumCircular(arr));
    }

    static class Solution {
        public int maxSubarraySumCircular(int[] nums) {
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            int ans = nums[0];
            long sum = nums[0];
            for (int i = 1; i < dp.length; i++) {
                int pre = nums[i] + dp[i - 1];
                int next = nums[i];
                dp[i] = Math.max(pre, next);
                ans = Math.max(ans, dp[i]);
                sum += nums[i];
            }

            for (int i = 1; i < dp.length; i++) {
                int pre = nums[i] + dp[i - 1];
                int next = nums[i];
                dp[i] = Math.min(pre, next);
                int condition = (int)(sum - dp[i]);
                if (condition == 0 && i == dp.length - 1) {
                    // 表示全是负数
                    break;
                }
                ans = Math.max(ans, (int)(sum - dp[i]));
            }
            return ans;
        }
    }
}
