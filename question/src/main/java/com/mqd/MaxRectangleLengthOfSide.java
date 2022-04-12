package com.mqd;

/**
 * 给定一个N*N的矩阵matrix，只有0和1两种值，返回边框全是1的最大正方形的边长长度
 * 如01111
 * 01001
 * 01001
 * 01111
 * 01011
 * 最大正方形为4*4，故返回4
 */
public class MaxRectangleLengthOfSide {
    private static final int[][] matrix = {
            {0, 1, 1, 1, 1},
            {0, 1, 0, 0, 1},
            {0, 1, 0, 0, 1},
            {0, 1, 1, 1, 1},
            {0, 1, 0, 1, 1}
    };

    public static void main(String[] args) {
        System.out.println(solution1(matrix));
    }

    // 解决1 暴力解
    public static int solution1(int[][] matrix) {
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    int tempRes = 1;
                    int width = j, height = i;
                    while (width < matrix.length-1 && height < matrix[0].length-1) {
                        width++;
                        height++;
                        if (matrix[height][width] == 1) {
                            boolean flag = true;
                            int w1 = j,w2 = j, h1 = i, h2 = i;
                            while (w1<=width && w2 <= width && h1 <= height && h2<= height){
                                if (matrix[i][w1] != 1) {
                                    flag = false;
                                    break;
                                }
                                if (matrix[height][w2] != 1){
                                    flag = false;
                                    break;
                                }
                                if (matrix[h1][j] != 1) {
                                    flag = false;
                                    break;
                                }
                                if (matrix[h2][width] != 1) {
                                    flag = false;
                                    break;
                                }
                                w1++;
                                w2++;
                                h1++;
                                h2++;
                            }
                            if (flag) {
                                tempRes = width - i;
                            }
                            break;
                        }
                    }
                    res = Math.max(res, tempRes);
                }
            }
        }
        return res;
    }
}
