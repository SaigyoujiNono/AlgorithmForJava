package com.mqd.leetcode.medium;

import com.mqd.utils.TimeStatistic;

import java.util.HashSet;
import java.util.Set;

/**
 * leetcode 565 数组嵌套
 * 索引从0开始长度为N的数组A，包含0到N - 1的所有整数。找到最大的集合S并返回其大小，其中 S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }且遵守以下的规则。
 *
 * 假设选择索引为i的元素A[i]为S的第一个元素，S的下一个元素应该是A[A[i]]，
 * 之后是A[A[A[i]]]... 以此类推，不断添加直到S出现重复的元素。
 *
 */
public class L565 {

    public int arrayNesting(int[] nums) {
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            int index = i;
            Set<Integer> set = new HashSet<>();
            while (!set.contains(nums[index]) && nums[index] != -1) {
                set.add(nums[index]);
                int temp = nums[index];
                nums[index] = -1;
                index = temp;
            }
            max = Math.max(set.size(), max);
        }
        return max;
    }

    public static void main(String[] args) {
        L565 p = new L565();
        int[] arr = { 5,4,0,3,1,6,2 };
        TimeStatistic.func(() -> System.out.println(p.arrayNesting(arr)));
    }
}
