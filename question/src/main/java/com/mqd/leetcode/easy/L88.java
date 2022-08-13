package com.mqd.leetcode.easy;

import java.util.Arrays;

/**
 * leetcode 88. 合并两个有序数组
 */
public class L88 {

    public static void main(String[] args) {
        Solution p = new Solution();
    }
    
    
    static class Solution {

        public void merge(int[] nums1, int m, int[] nums2, int n) {
            for (int i = 0, j = m; i < n; i++, j++) {
                nums1[j] = nums2[i];
            }
            Arrays.sort(nums1);
        }
    }
}
