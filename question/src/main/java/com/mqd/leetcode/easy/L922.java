package com.mqd.leetcode.easy;

import com.mqd.utils.TimeStatistic;

import java.util.Arrays;

/**
 * leetcode 922 按奇偶排序数组 II
 */
public class L922 {
    public static void main(String[] args) {
        L922 p = new L922();
        int[] arr = {2,3,1,1,4,0,0,4,3,3};
        TimeStatistic.func(() -> System.out.println(Arrays.toString(p.sortArrayByParityII(arr))));
    }

    public int[] sortArrayByParityII(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0 && nums[i] % 2 != 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] % 2 == 0) {
                        int temp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = temp;
                        break;
                    }
                }
            } else if (i % 2 != 0 && nums[i] % 2 == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] % 2 != 0) {
                        int temp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = temp;
                        break;
                    }
                }
            }
        }
        return nums;
    }
}
