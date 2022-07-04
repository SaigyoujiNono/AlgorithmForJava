package com.mqd.leetcode.medium;

import com.mqd.utils.TimeStatistic;

import java.util.Arrays;

/**
 * leetcode 1685. 有序数组中差绝对值之和
 * 给你一个 非递减 有序整数数组 nums 。
 *
 * 请你建立并返回一个整数数组 result，它跟 nums 长度相同，且result[i] 等于 nums[i] 与数组中所有其他元素差的绝对值之和。
 *
 * 换句话说， result[i] 等于 sum(|nums[i]-nums[j]|) ，其中 0 <= j < nums.length 且 j != i （下标从 0 开始）。
 */
public class L1685 {
    public static void main(String[] args) {
        L1685 p = new L1685();
        int[] arr = {1,4,6,8,10};
        TimeStatistic.func(() -> System.out.println(Arrays.toString(p.getSumAbsoluteDifferences(arr))));
    }

    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] preSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = nums[i] + preSum[i];
        }
        for (int i = 0; i < nums.length; i++) {
            int left = preSum[i];
            int right = preSum[preSum.length - 1] - preSum[i + 1];
            nums[i] = Math.abs(left - i * nums[i]) + Math.abs(right - (nums.length - 1 - i) * nums[i]);
        }
        return nums;
    }
}
