package com.mqd.leetcode.week296;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 6082 换数组中的元素
 * 给你一个下标从 0 开始的数组 nums ，它包含 n 个 互不相同 的正整数。请你对这个数组执行 m 个操作，在第 i 个操作中，你需要将数字 operations[i][0] 替换成 operations[i][1] 。
 *
 * 题目保证在第 i 个操作中：
 *
 * operations[i][0] 在 nums 中存在。
 * operations[i][1] 在 nums 中不存在。
 * 请你返回执行完所有操作后的数组。
 */
public class L6092 {

    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int[] operation : operations) {
            int index = map.get(operation[0]);
            nums[index] = operation[1];
            map.put(operation[1], index);
            map.remove(operation[0]);
        }
        return nums;
    }
}
