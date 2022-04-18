package com.mqd;

/**
 * 给定一个数字N，N代表二叉树节点数量，要求返回一共有多少个节点
 */
public class TreeNodeStructQuantity {

    public static void main(String[] args) {
        System.out.println(solution1(10));
    }

    public static int solution1(int N) {
        if (N == 0 || N == 1) return 1;
        if (N == 2) return 2;
        int res = 0;
        for (int left = 0; left < N; left++) {
            int leftCount = solution1(left);
            int rightCount = solution1(N - left - 1);
            res += leftCount * rightCount;
        }
        return res;
    }


}
