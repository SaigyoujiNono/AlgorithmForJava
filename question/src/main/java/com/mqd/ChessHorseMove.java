package com.mqd;

/**
 * 马走日问题
 * 设一个棋盘纵九横十
 * 现在有一个马要移动固定的步数到某个区域
 * 问有多少种走法
 */
public class ChessHorseMove {


    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        System.out.println(horseMove(8, 9, 15));
        long t2 = System.currentTimeMillis();
        System.out.println(horseMove2(8, 9, 15));
        long t3 = System.currentTimeMillis();
        System.out.println("方法1: "+(t2-t1)+"ms");
        System.out.println("方法2: "+(t3-t2)+"ms");
    }

    /**
     * 马移动
     *
     * @param x    横坐标
     * @param y    纵坐标
     * @param step 必须移动的步数
     * @return 多少种方法
     */
    public static int horseMove(int x, int y, int step) {
        if (x < 0 || x > 8 || y < 0 || y > 9) return 0;
        if (step <= 0) return (x == 0 && y == 0) ? 1 : 0;

        return horseMove(x - 2, y - 1, step - 1) +
                horseMove(x - 2, y + 1, step - 1) +
                horseMove(x - 1, y + 2, step - 1) +
                horseMove(x + 1, y + 2, step - 1) +
                horseMove(x + 2, y + 1, step - 1) +
                horseMove(x + 2, y - 1, step - 1) +
                horseMove(x + 1, y - 2, step - 1) +
                horseMove(x - 1, y - 2, step - 1);
    }


    public static int horseMove2(int x, int y, int step) {
        if (x < 0 || x > 8 || y < 0 || y > 9 || step < 0) return 0;

        int[][][] arr = new int[9][10][step + 1];

        arr[0][0][0] = 1;
        //从第0层开始依赖，第0层只有step==0 && x==0 && y==0时为1
        for (int s = 1; s <= step; s++) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 10; j++) {
                    int v1 = isBoundaryOut(i - 2, j - 1) ? 0 : arr[i - 2][j - 1][s - 1];
                    int v2 = isBoundaryOut(i - 2, j + 1) ? 0 : arr[i - 2][j + 1][s - 1];
                    int v3 = isBoundaryOut(i - 1, j + 2) ? 0 : arr[i - 1][j + 2][s - 1];
                    int v4 = isBoundaryOut(i + 1, j + 2) ? 0 : arr[i + 1][j + 2][s - 1];
                    int v5 = isBoundaryOut(i + 2, j + 1) ? 0 : arr[i + 2][j + 1][s - 1];
                    int v6 = isBoundaryOut(i + 2, j - 1) ? 0 : arr[i + 2][j - 1][s - 1];
                    int v7 = isBoundaryOut(i + 1, j - 2) ? 0 : arr[i + 1][j - 2][s - 1];
                    int v8 = isBoundaryOut(i - 1, j - 2) ? 0 : arr[i - 1][j - 2][s - 1];
                    arr[i][j][s] = v1 + v2 + v3 + v4 + v5 + v6 + v7 + v8;
                }
            }
        }
        return arr[x][y][step];
    }

    public static boolean isBoundaryOut(int x, int y) {
        return (x < 0 || x > 8 || y < 0 || y > 9);
    }
}
