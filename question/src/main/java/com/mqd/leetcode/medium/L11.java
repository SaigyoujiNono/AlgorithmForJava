package com.mqd.leetcode.medium;

/**
 * leetcode 11. 盛最多水的容器
 * 给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
 *
 * 找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 */
public class L11 {
    public static void main(String[] args) {
        Solution p = new Solution();
        int[] arr = {1,8,6,2,5,4,8,3,7};
//        int[] arr = {1,1};
        System.out.println(p.maxArea(arr));
    }

    static class Solution {
        public int maxArea(int[] height) {
            if (height.length < 2) return 0;
            int ans = 0;
            int l = 0;
            int r = height.length - 1;
            while (l < r) {
                if (height[l] < height[r]) {
                    ans = Math.max((r - l) * height[l], ans);
                    l++;
                } else {
                    ans = Math.max((r - l) * height[r], ans);
                    r--;
                }
            }
            return ans;
        }
    }
}
