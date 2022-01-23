package com.mqd;

/**
 * 鲍勃游戏
 * 设有一个长x宽y的区域
 * 鲍勃在其中一个坐标上，每次只能向上下左右移动
 * 移动到区域外鲍勃死亡
 * 给定一定步数
 * 求鲍勃存活的概率
 */
public class BobGame {

    public static void main(String[] args) {
        int x = 16, y = 16, m = 7, n = 6, step = 22;
        long t1 = System.currentTimeMillis();
        long live = process(x, y, m, n, step);
        long t2 = System.currentTimeMillis();
        long live2 = process2(x, y, m, n, step);
        long t3 = System.currentTimeMillis();
        System.out.println(live);
        System.out.println(live2);
        System.out.println((double) live / Math.pow(4,step));
        System.out.println((double) live2 / Math.pow(4,step));
        System.out.println("方法1: "+(t2-t1)+"ms");
        System.out.println("方法2: "+(t3-t2)+"ms");

    }

    /**
     * 解决
     *
     * @param x    长度
     * @param y    宽度
     * @param m    鲍勃所在位置x坐标
     * @param n    鲍勃所在位置y坐标
     * @param step 步数
     * @return 存活的方法数
     */
    public static long process(int x, int y, int m, int n, int step) {
        if (m < 0 || m >= x || n < 0 || n >= y) {
            return 0;
        }
        if (step == 0) {
            return 1;
        }
        return process(x, y, m - 1, n, step - 1) +
                process(x, y, m + 1, n, step - 1) +
                process(x, y, m, n - 1, step - 1) +
                process(x, y, m, n + 1, step - 1);
    }

    public static long process2(int x, int y, int m, int n, int step){
        long[][][] matrix = new long[x][y][step+1];

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrix[i][j][0] = 1;
            }
        }
        for (int s = 1; s <= step; s++) {
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    matrix[i][j][s] = getValues(matrix,x,y,i-1,j,s-1)+
                            getValues(matrix,x,y,i+1,j,s-1)+
                            getValues(matrix,x,y,i,j-1,s-1)+
                            getValues(matrix,x,y,i,j+1,s-1);
                }
            }
        }
        return matrix[m][n][step];
    }
    public static long getValues(long[][][] matrix,int x,int y,int m,int n,int step){
        if (m < 0 || m >= x || n < 0 || n >= y) {
            return 0;
        }
        return matrix[m][n][step];
    }

}
