package com.mqd;

import com.mqd.utils.TimeStatistic;

/**
 * 最大子矩阵和
 */
public class MaxSubMatrixSum {

    public static void main(String[] args) {
        int[][] matrix = {
                {-5, 3, 6, 4},
                {-7, 9, -5, 3},
                {-10, 1, -200, 4}};
        TimeStatistic.func(() -> System.out.println(solution(matrix)));
    }

    public static int solution(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int[] arr;
        int cur;
        for (int i = 0; i < matrix.length; i++) {
            arr = new int[matrix[0].length];
            for (int j = i; j < matrix.length; j++) {
                cur = 0;
                for (int k = 0; k < arr.length; k++) {
                    arr[k] += matrix[j][k];
                    cur += arr[k];
                    max = Math.max(max, cur);
                    cur = Math.max(0, cur);
                }
            }
        }
        return max;
    }
}
