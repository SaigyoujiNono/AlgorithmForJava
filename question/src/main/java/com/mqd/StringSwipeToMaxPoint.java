package com.mqd;

import com.mqd.utils.RandomArrayBuilder;

import java.util.Arrays;

/**
 * 给定一个有序数组
 * 数组里的元素是数轴上的坐标
 * 再给定一根绳子，长度为L
 * 求L最多能围住几个数轴上的点
 */
public class StringSwipeToMaxPoint {

    public static void main(String[] args) {
        int[] arr2 = RandomArrayBuilder.randomArray(0, 300,100);
        assert arr2 != null;
        Arrays.sort(arr2);
        System.out.println(solution(arr2, 20));
    }

    public static int solution(int[] arr, int string) {
        int start = 0, end = 0, max = 0;
        for (; end < arr.length; end++) {
            if (arr[end] - arr[start] < string) {
                continue;
            }
            while (arr[end] - arr[start] > string) {
                start++;
            }
            max = Math.max(max, end - start + 1);
        }
        return max == 0 ? arr.length : max;
    }
}
