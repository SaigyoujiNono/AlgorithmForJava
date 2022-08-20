package com.mqd.leetcode.medium;

/**
 * leetcode 1545. 找出第 N 个二进制字符串中的第 K 位
 * 给你两个正整数 n 和 k，二进制字符串 Sn 的形成规则如下：
 *
 * S1= "0"
 * 当 i > 1 时，Si=Si-1+ "1" + reverse(invert(Si-1))
 * 其中 + 表示串联操作，reverse(x) 返回反转 x 后得到的字符串，而 invert(x) 则会翻转 x 中的每一位（0 变为 1，而 1 变为 0）。
 *
 * 例如，符合上述描述的序列的前 4 个字符串依次是：
 *
 * S1= "0"
 * S2= "011"
 * S3= "0111001"
 * S4 = "011100110110001"
 * 请你返回 Sn 的 第 k 位字符 ，题目数据保证 k 一定在 Sn 长度范围以内。
 */
public class L1545 {

    public static void main(String[] args) {
        Solution p = new Solution();
//        System.out.println(p.findKthBit2(3, 1) == p.findKthBit(3, 1));
//        System.out.println(p.findKthBit2(4, 11) == p.findKthBit(4, 11));
//        System.out.println(p.findKthBit2(1, 1) == p.findKthBit(1, 1));
//        System.out.println(p.findKthBit2(2, 3) == p.findKthBit(2, 3));
        System.out.println(p.findKthBit2(4, 11));
    }

    static class Solution {
        public char findKthBit(int n, int k) {
            return createStr(n).charAt(k - 1);
        }

        public char findKthBit2(int n, int k) {
            if(n == 1) return '0';
            int len = (int)Math.pow(2, n) - 1;
            int mid = (len >> 1) + 1;
            if (k == mid) return '1';

            if (k < mid) {
                return findKthBit2(n - 1, k);
            }
            return findKthBit2(n - 1, mid - (k - mid)) == '0' ? '1' : '0';
        }

        private String createStr(int n) {
            String res = "0";

            for (int i = 1; i < n; i++) {
                res = res + "1" + new StringBuilder(invert(res)).reverse();
            }
            return res;
        }

        private String invert(String str) {
            char[] chars = str.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (char aChar : chars) {
                if (aChar == '1') sb.append(0);
                else sb.append(1);
            }
            return sb.toString();
        }
    }
}
