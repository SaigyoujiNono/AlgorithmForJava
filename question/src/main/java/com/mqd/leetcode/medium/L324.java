package com.mqd.leetcode.medium;

import com.mqd.utils.TimeStatistic;

import java.util.Arrays;

/**
 * leetcode 324. 摆动排序 II
 * 给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 *
 * 你可以假设所有输入数组都可以得到满足题目要求的结果。
 */
public class L324 {

    public static void main(String[] args) {
        L324 p = new L324();
//        int[] arr = {1,4,3,4,1,2,1,3,1,3,2,3,3};
        int[] arr = {1,5,1,1,6,4};
        TimeStatistic.func(() -> {
            p.wiggleSort(arr);
            System.out.println(Arrays.toString(arr));
        });
    }

    public void wiggleSort(int[] nums) {
        int[] nums2 = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums2);
        int l = (nums.length - 1) / 2;
        int r = nums.length - 1;
        int index = 0;
        while (index < nums.length) {
            if ((index % 2 != 0 && r > l) || l < 0){
                nums[index] = nums2[r];
                r--;
            } else {
                nums[index] = nums2[l];
                l--;
            }
            index++;
        }
    }
}
