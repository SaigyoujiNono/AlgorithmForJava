package com.mqd.leetcode.week296;

/**
 * leetcode 6090 极大极小游戏
 * 给你一个下标从 0 开始的整数数组 nums ，其长度是 2 的幂。
 *
 * 对 nums 执行下述算法：
 *
 * 设 n 等于 nums 的长度，如果 n == 1 ，终止 算法过程。否则，创建 一个新的整数数组 newNums ，新数组长度为 n / 2 ，下标从 0 开始。
 * 对于满足 0 <= i < n / 2 的每个 偶数 下标 i ，将 newNums[i] 赋值 为 min(nums[2 * i], nums[2 * i + 1]) 。
 * 对于满足 0 <= i < n / 2 的每个 奇数 下标 i ，将 newNums[i] 赋值 为 max(nums[2 * i], nums[2 * i + 1]) 。
 * 用 newNums 替换 nums 。
 * 从步骤 1 开始 重复 整个过程。
 * 执行算法后，返回 nums 中剩下的那个数字。
 */
public class L6090 {
    public static void main(String[] args) {
        L6090 p = new L6090();
        int[] arr = {70,38,21,22};
        System.out.println(p.minMaxGame(arr));
    }
    public int minMaxGame(int[] nums) {
        int[] arr = nums;
        for (int i = arr.length / 2; i >= 1 ; i /= 2) {
            int[] arr2 = new int[i];
            for (int j = 0; j < arr2.length; j++) {
                if (j % 2 == 0) {
                    arr2[j] = Math.min(arr[2 * j], arr[2 * j + 1]);
                } else {
                    arr2[j] = Math.max(arr[2 * j], arr[2 * j + 1]);
                }
            }
            arr = arr2;
        }
        return arr[0];
    }
}
