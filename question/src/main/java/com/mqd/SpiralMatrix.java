package com.mqd;

/**
 * 螺旋矩阵问题
 * 给定一个矩阵，按顺时针螺旋顺序输出
 * input: [
 *  [1,2,3],
 *  [4,5,6],
 *  [7,8,9]
 * ]
 * output: [1,2,3,6,9,8,7,4,5]
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] input = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] input2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[][] input3 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[] solution = solution(input3);
        for (int i : solution) {
            System.out.println(i);
        }
    }


    public static int[] solution(int[][] matrix){
        int row = matrix.length;    //行数
        int col = matrix[0].length; //列数
        int directIndex = 0;

        int[] res = new int[row*col];

        int minRow = 0,
                maxRow = row-1,
                minCol = 0,
                maxCol = col-1,
                index = 0;
        while (index<res.length){
            //当directIndex%4 == 0时代表向右遍历
            if (directIndex%4 == 0){
                for (int i = minCol; i <= maxCol; i++) {
                    if (index > res.length) break;
                    res[index] = matrix[minRow][i];
                    index++;
                }
                minRow++;
                directIndex++;  //切换下一个方向
            }else if (directIndex%4 == 1){ //向下遍历
                for (int i = minRow; i <= maxRow ; i++) {
                    if (index >res.length) break;
                    res[index] = matrix[i][maxCol];
                    index++;
                }
                maxCol--;
                directIndex++;
            }else if (directIndex%4 == 2){  //向左遍历
                for (int i = maxCol; i >= minCol; i--) {
                    if (index > res.length) break;
                    res[index] = matrix[maxRow][i];
                    index++;
                }
                maxRow--;
                directIndex++;
            }else {
                for (int i = maxRow; i >= minRow ; i--) {   //向上遍历
                    if (index > res.length) break;
                    res[index] = matrix[i][minCol];
                    index++;
                }
                minCol++;
                directIndex++;
            }
        }

        return res;
    }
}
