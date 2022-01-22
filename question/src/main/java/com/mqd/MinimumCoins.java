package com.mqd;

/**
 * 最小硬币问题
 * 设有一组硬币
 * 每个硬币面值是整数且大于0
 * 给定一个数字
 * 要求返回组成这个数字的最小硬币数量
 */
public class MinimumCoins {


    public static void main(String[] args) {
        int[] coins = {2, 5, 7, 3, 5, 3};
        System.out.println(minimumCoins(coins, 0, 10));
        System.out.println(minimumCoins2(coins, 0, 10));
    }

    /**
     * 返回最小硬币数量
     *
     * @param arr   硬币数组
     * @param index 索引
     * @param cost  价值
     * @return 硬币数量
     */
    public static int minimumCoins(int[] arr, int index, int cost) {
        //当cost == 0时，符合条件，返回
        if (cost == 0) {
            return 0;
        }
        //当cost < 0 时，或者index到达了arr.length时（没有硬币组合了），返回-1
        if (cost < 0 || index == arr.length) {
            return -1;
        }

        int p1 = minimumCoins(arr, index + 1, cost);    //不要这枚硬币的结果
        int p2 = minimumCoins(arr, index + 1, cost - arr[index]); //要这枚硬币的结果
        if (p1 == -1 && p2 == -1) {
            return -1;
        } else {
            if (p1 == -1) {
                return p2 + 1;
            }
            if (p2 == -1) {
                return p1;
            }
            return Math.min(p1, p2 + 1);
        }
    }

    /**
     * 返回最小硬币数量
     *
     * @param arr   硬币数组
     * @param index 索引
     * @param cost  价值
     * @return 硬币数量
     */
    public static int minimumCoins2(int[] arr, int index, int cost) {
        int[][] record = new int[arr.length + 1][cost + 1];
        for (int i = 0; i < arr.length + 1; i++) {
            for (int j = 0; j < cost + 1; j++) {
                record[i][j] = -2;
            }
        }
        return minimumCoins(arr, index, cost, record);
    }

    public static int minimumCoins(int[] arr, int index, int cost, int[][] record) {
        //当cost == 0时，符合条件，返回
        if (cost == 0) {
            record[index][cost] = 0;
            return 0;
        }
        //当cost < 0 时，或者index到达了arr.length时（没有硬币组合了），返回-1
        if (cost < 0 || index == arr.length) {
            record[index][cost] = -1;
            return -1;
        }

        int p1 = minimumCoins(arr, index + 1, cost);    //不要这枚硬币的结果
        int p2 = minimumCoins(arr, index + 1, cost - arr[index]); //要这枚硬币的结果
        if (p1 == -1 && p2 == -1) {
            record[index][cost] = -1;
        } else {
            if (p1 == -1) {
                record[index][cost] = p2 + 1;
            }
            if (p2 == -1) {
                record[index][cost] = p1;
            }
            record[index][cost] = Math.min(p1, p2 + 1);
        }

        return record[index][cost];
    }
}
