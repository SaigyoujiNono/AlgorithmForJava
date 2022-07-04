package com.mqd.leetcode.easy;

import com.mqd.utils.TimeStatistic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 1200. 最小绝对差
 * 给你个整数数组 arr，其中每个元素都 不相同。
 *
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 */
public class L1200 {
    public static void main(String[] args) {
        L1200 p = new L1200();
        int[] arr = {3,8,-10,23,19,-4,-14,27};
        TimeStatistic.func(() -> System.out.println(p.minimumAbsDifference(arr)));
    }


    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        int pre = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int abs = Math.abs(arr[i] - pre);
            if (abs == min) {
                res.add(Arrays.asList(pre, arr[i]));
            } else if (abs < min) {
                res.clear();
                min = abs;
                res.add(Arrays.asList(pre, arr[i]));
            }
            pre = arr[i];
        }
        return res;
    }
}