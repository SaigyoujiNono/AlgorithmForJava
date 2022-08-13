package com.mqd.leetcode.hard;

import com.mqd.utils.RandomArrayBuilder;
import com.mqd.utils.TimeStatistic;

import java.util.*;

/**
 * leetcode 239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回 滑动窗口中的最大值 。
 */
public class L239 {

    public static void main(String[] args) {
        Solution p = new Solution();
        int[] arr = RandomArrayBuilder.randomArray(1, 1000000);
//        int[] arr = {7,12,6,8,11,9,28,22,14,3};
        TimeStatistic.func(() -> {
            System.out.println("start");
            int[] a = p.maxSlidingWindow(arr, 50000);
        });
    }


    static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            // 如果k 大于等于数组长度 直接返回数组中的最大值
            if (k >= nums.length) {
                int max = Integer.MIN_VALUE;
                for (int num : nums) {
                    max = Math.max(max, num);
                }
                return new int[]{max};
            }
            // next
            int[] ans = new int[nums.length - k + 1];
            int index = 0;
            // 创建单调队列
            Deque<Integer> q = new LinkedList<>();
            for (int i = 0; i < k; i++) {
                if (q.peekLast() == null || nums[q.peekLast()] >= nums[i]) {
                    q.addLast(i);
                } else {
                    while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                        q.pollLast();
                    }
                    q.addLast(i);
                }
            }
            int l = 0;
            int r = k - 1;
            while (r < nums.length) {
                Integer peek = q.peekFirst();
                if (peek == null) break;
                ans[index] = nums[peek];
                index++;
                if (q.peekLast() == null || nums[q.peekFirst()] == nums[l]) {
                    q.pollFirst();
                }
                l++;
                r++;
                if (r >= nums.length) break;
                while (!q.isEmpty() && nums[q.peekLast()] < nums[r]) {
                    q.pollLast();
                }
                q.addLast(r);
            }
            return ans;
        }
    }
}
