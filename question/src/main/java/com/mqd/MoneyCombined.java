package com.mqd;


/**
 * 给定一个数组，里面有多个面值的货币
 * 给定一个正整数
 * 求组成这个正整数有多少种方法
 */
public class MoneyCombined {

    public static void main(String[] args) {
        int target = 8000, index = 0;
        int[] money = {1, 2, 3};
        long t1 = System.currentTimeMillis();
        System.out.println(solution(money, index, target));
        long t2 = System.currentTimeMillis();
        System.out.println(solution2(money, target));
        long t3 = System.currentTimeMillis();
        System.out.println(solution3(money, target));
        long t4 = System.currentTimeMillis();
        System.out.println("方法1: " + (t2 - t1) + "ms");
        System.out.println("方法2: " + (t3 - t2) + "ms");
        System.out.println("方法3: " + (t4 - t3) + "ms");
    }


    public static long solution(int[] money, int index, int target) {
        if (index >= money.length) {
            return target == 0 ? 1 : 0;
        }
        int ways = 0;
        for (int i = 0; money[index] * i <= target; i++) {
            ways += solution(money, index + 1, target - money[index] * i);
        }
        return ways;
    }

    public static long solution2(int[] money, int target) {
        if (money == null || money.length == 0) {
            return 0;
        }

        int N = money.length;
        int[][] dp = new int[N + 1][target + 1];
        dp[N][0] = 1;

        for (int i = N - 1; i >= 0; i--) {
            for (int t = 0; t <= target; t++) {
                int ways = 0;
                for (int c = 0; money[i] * c <= t; c++) {
                    ways += dp[i + 1][t - money[i] * c];
                }
                dp[i][t] = ways;
            }
        }

        return dp[0][target];
    }

    public static long solution3(int[] money, int target) {
        if (money == null || money.length == 0) {
            return 0;
        }

        int N = money.length;
        int[][] dp = new int[N + 1][target + 1];
        dp[N][0] = 1;

        for (int i = N - 1; i >= 0; i--) {
            for (int t = 0; t <= target; t++) {
                dp[i][t] = dp[i + 1][t] +
                        ((t - money[i] < 0) ? 0 : dp[i][t - money[i]]);
            }
        }

        return dp[0][target];
    }
}
