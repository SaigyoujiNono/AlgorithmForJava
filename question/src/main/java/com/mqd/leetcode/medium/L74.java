package com.mqd.leetcode.medium;

/**
 * leetcode 74
 * 编写一个高效的算法来判断m x n矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 */
public class L74 {
    public static void main(String[] args) {
        int[][] arr = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        System.out.println(searchMatrix(arr, 10));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col>=0) {
            if (target == matrix[row][col]) {
                return true;
            }else {
                if (row + 1 < matrix.length && matrix[row + 1][col] <= target) {
                    row++;
                } else {
                    col--;
                }
            }
        }
        return false;
    }
}
