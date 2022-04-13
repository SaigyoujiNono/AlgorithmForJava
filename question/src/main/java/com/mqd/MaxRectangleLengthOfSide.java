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
            {0, 1, 1, 1, 1, 1},
            {0, 1, 0, 0, 1, 1},
            {0, 1, 0, 0, 1, 1},
            {0, 1, 1, 1, 1, 1},
            {0, 1, 1, 1, 1, 1},
            {0, 1, 1, 1, 1, 1}
    };

    public static void main(String[] args) {
        System.out.println(solution1(matrix));
    }

    /**
     * 解决1 暴力解，遍历所有子矩阵
     * @param matrix    矩阵
     * @return  最大边长
     */
    public static int solution1(int[][] matrix) {
        int res = 0;
        // 遍历所有点
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length ; col++) {
                // 检查该点最大的矩形边长
                if (matrix[row][col] == 1) {
                    res = Math.max(getCurrentMaxLength(matrix,row,col),res);
                }
            }
        }
        return res;
    }

    /**
     * 获取当前节点最大矩形长度
     * @param matrix    大矩形
     * @param row   当前行
     * @param col   当前列
     * @return  当前节点最大矩形长度
     */
    public static int getCurrentMaxLength(int[][] matrix, int row, int col) {
        int row2 = row;
        int col2 = col;
        int res = 1;
        while (row2 + 1 < matrix.length && col2 + 1 < matrix[0].length) {
            row2++;
            col2++;
            if (matrix[row2][col2] == 1) {
                boolean flag = true;
                for (int c = col, r = row; c < col2 || r < row2; c++, r++) {
                    if (matrix[row][c] != 1 || matrix[row2][c] != 1) {
                        flag = false;
                        break;
                    }
                    if (matrix[r][col] != 1 || matrix[r][col2] != 1) {
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    res = Math.max(res, col2-col+1);
                }

            }
        }
        return res;
    }
}
