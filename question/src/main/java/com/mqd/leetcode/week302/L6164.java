package com.mqd.leetcode.week302;

import com.mqd.utils.RandomArrayBuilder;
import com.mqd.utils.TimeStatistic;

import java.util.*;

/**
 * leetcode 6164 数位和相等数对的最大和
 * 给你一个下标从 0 开始的数组 nums ，数组中的元素都是 正 整数。
 * 请你选出两个下标 i 和 j（i != j），且 nums[i] 的数位和 与  nums[j] 的数位和相等。
 *
 * 请你找出所有满足条件的下标 i 和 j ，找出并返回 nums[i] + nums[j] 可以得到的 最大值 。
 */
public class L6164 {
    public int maximumSum(int[] nums) {
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for (int num : nums) {
            int digitSum = digitSum(num);
            Queue<Integer> q = map.getOrDefault(digitSum, new PriorityQueue<>((x1, x2) -> x2 - x1));
            q.add(num);
            map.put(digitSum, q);
        }
        int max = -1;
        for (Map.Entry<Integer, Queue<Integer>> entry : map.entrySet()) {
            Queue<Integer> q = entry.getValue();
            if (q.size() >= 2) {
                Integer p1 = q.poll();
                Integer p2 = q.poll();
                if (p1 != null && p2 != null)
                    max = Math.max(max, p1 + p2);
            }
        }
        return max;
    }
    private int digitSum(int num) {
        int res = 0;
        while (num > 0) {
            int mod = num % 10;
            res += mod;
            num /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = RandomArrayBuilder.randomArray(1, 99999);
//        int[] ints = {18,43,36,13,7};
        L6164 p = new L6164();
        TimeStatistic.func(() -> System.out.println(p.maximumSum(ints)));
    }
}
