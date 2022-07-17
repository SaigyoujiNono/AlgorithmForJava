package com.mqd.leetcode.week302;

import java.util.Arrays;

/**
 * leetcode 6120 数组能形成多少数对
 * 给你一个下标从 0 开始的整数数组 nums 。在一步操作中，你可以执行以下步骤：
 *
 * 从 nums 选出 两个 相等的 整数
 * 从 nums 中移除这两个整数，形成一个 数对
 * 请你在 nums 上多次执行此操作直到无法继续执行。
 *
 * 返回一个下标从 0 开始、长度为 2 的整数数组 answer 作为答案，
 * 其中 answer[0] 是形成的数对数目，answer[1] 是对 nums 尽可能执行上述操作后剩下的整数数目。
 */
public class L6120 {
    public int[] numberOfPairs(int[] nums) {
        int[] result = new int[2];
        Arrays.sort(nums);
        int l = 0;
        int r = l + 1;
        while (r < nums.length) {
            if (nums[l] == nums[r]) {
                result[0]++;
                l += 2;
                r += 2;
            } else {
                l++;
                r++;
            }
        }
        result[1] = nums.length - result[0] * 2;
        return result;
    }

    public static void main(String[] args) {
        L6120 p = new L6120();
        int[] arr = {1,3,2,1,3,2,2};
        System.out.println(Arrays.toString(p.numberOfPairs(arr)));
    }
}
