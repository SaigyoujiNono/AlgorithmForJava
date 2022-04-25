package com.mqd;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个数组arr
 * 获取差值为k的不重复的数值对
 */
public class UnRepetitiveNumMap {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,5,7,0,0};
        System.out.println(solution(arr,2));
    }

    public static Map<Integer,Integer> solution(int[] nums, int k) {
        Map<Integer, Integer> res = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++){
                if (Math.abs(nums[i] - nums[j]) == k) {
                    if (nums[i] > nums[j]) {
                        res.put(nums[j], nums[i]);
                    } else {
                        res.put(nums[i],nums[j]);
                    }
                }
            }
        }



        return res;
    }
}
