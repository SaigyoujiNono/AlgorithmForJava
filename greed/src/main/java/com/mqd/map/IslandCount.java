package com.mqd.map;

/**
 * 小岛问题，现在存在一个二维数组，求其中1连成一片的小岛数
 * {
 * {1,0,0,0,0,0,1,1,0,0},
 * {1,0,0,1,0,0,1,1,0,0},
 * {0,0,0,1,0,1,1,1,0,0},
 * {1,0,0,1,0,0,1,1,0,0},
 * {0,0,1,0,0,0,0,0,0,0},
 * {1,1,1,0,0,0,1,1,0,0}
 * }
 */
public class IslandCount {
    private final int[][] islandMap = {
                    {1,0,0,0,0,0,1,1,0,0},
                    {1,0,0,1,0,0,1,1,0,0},
                    {0,0,0,1,0,1,1,1,0,0},
                    {1,0,0,1,0,0,1,1,0,0},
                    {0,0,1,0,0,0,0,0,0,0},
                    {1,1,1,0,0,0,1,1,0,0}
                };

    public static void main(String[] args) {
        IslandCount islandCount = new IslandCount();
        int islandCount1 = islandCount.getIslandCount(islandCount.islandMap);
        System.out.println(islandCount1);
    }

    /**
     * 传入一个二维数组，获取小岛数量
     * @param arr   二维数组
     * @return  小岛数量
     */
    public int getIslandCount(int[][] arr){
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1){
                    process(arr,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    private void process(int[][] arr, int row, int column) {
        if (row > arr.length-1 || column > arr[1].length-1 || row < 0 || column < 0 || arr[row][column] != 1){
            return;
        }
        arr[row][column] = 2;
        process(arr,row+1,column);
        process(arr,row,column+1);
        process(arr,row-1,column);
        process(arr,row,column-1);
    }
}
