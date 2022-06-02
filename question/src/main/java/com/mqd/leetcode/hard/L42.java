package com.mqd.leetcode.hard;

import com.mqd.utils.TimeStatistic;

/**
 * leetcode 42 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class L42 {
    public static void main(String[] args) {
        L42 l42 = new L42();
        TimeStatistic.func(() -> System.out.println(l42.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1})));
    }

    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int res = 0;

        int lh = height[l];
        int rh = height[r];
        while (l < r) {
            if (height[l] <= height[r]) {
                if (height[l] > lh) lh = height[l];
                l++;
                int temp = lh - height[l];
                if (temp > 0) res += temp;
            } else {
                if (height[r] > rh) rh = height[r];
                r--;
                int temp = rh - height[r];
                if (temp > 0) res += temp;
            }

        }
        return res;
    }
}
