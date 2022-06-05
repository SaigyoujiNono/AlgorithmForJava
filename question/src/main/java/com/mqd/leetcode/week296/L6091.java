package com.mqd.leetcode.week296;

import java.util.Arrays;

/**
 * leetcode 6091 划分数组使最大差为 K
 * 给你一个整数数组 nums 和一个整数 k 。你可以将 nums 划分成一个或多个 子序列 ，使 nums 中的每个元素都 恰好 出现在一个子序列中。
 *
 * 在满足每个子序列中最大值和最小值之间的差值最多为 k 的前提下，返回需要划分的 最少 子序列数目。
 *
 * 子序列 本质是一个序列，可以通过删除另一个序列中的某些元素（或者不删除）但不改变剩下元素的顺序得到。
 */
public class L6091 {
    public static void main(String[] args) {
        L6091 p = new L6091();
        int[] arr = {3,6,1,2,5};
        int[] arr2 = {1,2,3};
        int[] arr3 = {2,2,4,5};
        System.out.println(p.partitionArray(arr, 2));
        System.out.println(p.partitionArray(arr2, 1));
        System.out.println(p.partitionArray(arr3, 0));
    }

    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        int r = 0;
        int res = 0;
        while (r < nums.length) {
            while (r < nums.length && (nums[r] - nums[l]) <= k) {
                r++;
            }
            res++;
            l = r;
        }
        return res;
    }
}
