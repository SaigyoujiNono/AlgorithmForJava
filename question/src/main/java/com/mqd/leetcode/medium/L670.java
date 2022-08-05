package com.mqd.leetcode.medium;

import java.util.Arrays;

/**
 * leetcode 670. 最大交换
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 */
public class L670 {

    public static void main(String[] args) {
        Solution p = new Solution();
        System.out.println(p.maximumSwap(8271));
    }

    static class Solution {
        public int maximumSwap(int num) {
            String numStr = String.valueOf(num);
            char[] cs = numStr.toCharArray();
            char[] minSort = numStr.toCharArray();
            Arrays.sort(minSort);
            char find1 = '-';
            char find2 = '-';
            for (int i = minSort.length - 1, j = 0; i >= 0; i--, j++) {
                if (minSort[i] != cs[j]) {
                    find1 = cs[j];
                    find2 = minSort[i];
                    break;
                }
            }
            if (find1 == '-') {
                return num;
            }
            for (int i = 0; i < cs.length; i++) {
                if (cs[i] == find1) {
                    for (int j = cs.length - 1; j >= 0; j--) {
                        if (cs[j] == find2) {
                            char temp = cs[i];
                            cs[i] = cs[j];
                            cs[j] = temp;
                            break;
                        }
                    }
                    break;
                }
            }
            return Integer.parseInt(String.valueOf(cs));
        }
    }
}
