package com.mqd;

/**
 * 暂未解决
 */
public class MaxSubArraySum {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,-1,-10,11,4,-6,9,20,-10,-2};
        System.out.println(solution(arr));
        System.out.println(solution2(arr));
    }

    public static int solution(int[] arr){
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        int res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (dp[i - 1] <= 0) {
                dp[i] = arr[i];
            } else {
                dp[i] = arr[i] + dp[i - 1];
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static int solution2(int[] arr){
        int pre = arr[0];
        int res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int cur;
            if (pre <= 0) {
                cur = arr[i];
            } else {
                cur = arr[i] + pre;
            }
            pre = cur;
            res = Math.max(res, cur);
        }
        return res;
    }
}
