package com.mqd.queen;

/**
 * N皇后问题
 * 在一个N*N的棋盘上, 问每一行都摆一个皇后, 有多少种摆法
 */
public class NQueen {


    public int numOfPutMethod(int n){
        if (n<1 || n==2 || n==3){
            return 0;
        }
        int[] chessboard = new int[n];
        return process(0, chessboard, n);
    }

    /**
     *
     * @param i 当前来到了第几行
     * @param chessboard    棋盘
     * @param n 整体一共多少行
     * @return  合法的摆法
     */
    private int process(int i, int[] chessboard, int n){
        //如果当前来到了终止行了(就是比棋盘最后一行再加一行的位置), 则代表本次位置可行
        if (i==n) {
            return 1;
        }
        int res = 0;
        for (int j = 0; j < n; j++) {


            if (isValid(chessboard, i, j)){
                chessboard[i] = j;
                res += process(i+1, chessboard, n);
            }
        }
        return res;
    }

    private boolean isValid(int[] chessboard, int i, int j){
        for (int k = 0; k < i; k++) {
            if (j == chessboard[k] || Math.abs(chessboard[k]-j) == Math.abs(i-k)/*求斜率*/){
                return false;
            }
        }
        return true;
    }

    /**
     * n皇后问题
     * 常数优化
     * @param n
     * @return
     */
    public int numOfPutMethod2(int n){
        if (n<1 || n==2 || n==3 || n>32){
            return 0;
        }
        int limit = n == 32 ? -1 : (1 << n) -1;
//        return limit;
        return process2(limit,0,0,0);
    }

    /**
     * 常数时间优化
     * 假设8皇后问题[0...7], 在3的位置上放了一个皇后, 则此时col为 00010000
     * leftDia为 00100000, rightDia为 00001000
     * 将这3个数求或, 得到00111000, 则可以知道[2...4]不能放皇后
     * @param limit 列的大小
     * @param colLim    列的限制, 1的位置不能放皇后, 0的位置可以
     * @param leftDiaLim    左斜线的限制, 1的位置不能放皇后, 0的位置可以
     * @param rightDiaLim   右斜线的限制, 1的位置不能放皇后, 0的位置可以
     * @return  返回可行方法数
     */
    private int process2(
            int limit,
            int colLim,
            int leftDiaLim,
            int rightDiaLim
    ){
        //基础条件，当列值等于限制的时候次数+1
        if (colLim == limit)   {
            return 1;
        }
        //所有候选皇后的位置，都在pos上
        int pos = limit &(~(colLim | leftDiaLim | rightDiaLim));

        int mostRightOne = 0;

        int res = 0;
        while (pos != 0){
            //提取皇后最右侧的
            mostRightOne = pos & (~pos + 1);
            pos = pos - mostRightOne;
            res += process2(limit, colLim|mostRightOne,
                    (leftDiaLim | mostRightOne) << 1,
                    (rightDiaLim | mostRightOne) >>> 1);
        }
        return res;
    }
}
