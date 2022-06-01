package com.mqd;

import com.mqd.utils.RandomArrayBuilder;
import com.mqd.utils.TimeStatistic;

/**
 * 给定一个数组，判断相邻两数相乘是4的倍数
 * 如果可以通过调整达到目标返回true，否则返回false
 */
public class JudgeHasFourInArray {
    public static void main(String[] args) {
        JudgeHasFourInArray judgeHasFourInArray = new JudgeHasFourInArray();
//        int[] arr = {1,0,4,8,12,11,13,15,17,19};
        int[] arr = RandomArrayBuilder.randomArray(0,10000012);
        TimeStatistic.func(() -> System.out.println(judgeHasFourInArray.hasFour(arr)));
    }

    public boolean hasFour(int[] nums) {
        int add = 0;
        int hasFour = 0;
        int noHasFour = 0;
        for (int num : nums) {
            if (num % 2 != 0) {
                add++;
            } else {
                if (num % 4 == 0) {
                    hasFour++;
                } else {
                    noHasFour++;
                }
            }
        }
        return hasFour >= (add + noHasFour) - 1;
    }
}
