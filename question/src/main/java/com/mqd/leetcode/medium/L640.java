package com.mqd.leetcode.medium;

/**
 * leetcode 640. 求解方程
 * 求解一个给定的方程，将x以字符串 "x=#value"的形式返回。该方程仅包含 '+' ， '-' 操作，变量x和其对应系数。
 *
 * 如果方程没有解，请返回"No solution"。如果方程有无限解，则返回 “Infinite solutions” 。
 *
 * 题目保证，如果方程中只有一个解，则 'x' 的值是一个整数。
 */
public class L640 {

    public static void main(String[] args) {
        Solution p = new Solution();
        System.out.println(p.solveEquation("x=x+2"));
    }

    static class Solution {
        int xSum = 0;
        int numSum = 0;
        StringBuilder num = null;
        public String solveEquation(String equation) {
            String[] split = equation.split("=");
            if (split.length != 2) return "No solution";
            StringBuilder left = new StringBuilder(split[0]);
            StringBuilder right = new StringBuilder(split[1]);
            if (left.charAt(0) != '-') {
                left.insert(0, '+');
            }
            if (right.charAt(0) != '-') {
                right.insert(0, '+');
            }

            for (int i = 0; i < left.length() + 1; i++) {
                char c = i >= left.length() ? '+' : left.charAt(i);
                if (c == '+' || c == '-') {
                    if (num != null) {
                        int nu = Integer.parseInt(num.toString());
                        numSum -= nu;
                    }
                    num = new StringBuilder();
                    num.append(c);
                } else if (c == 'x') {
                    assert num != null;
                    if (num.charAt(0) == '-' && num.length() == 1) xSum--;
                    else if (num.charAt(0) == '+' && num.length() == 1) xSum++;
                    else xSum += Integer.parseInt(num.toString());
                    num = null;
                } else {
                    assert num != null;
                    num.append(c);
                }
            }

            num = null;
            for (int i = 0; i < right.length() + 1; i++) {
                char c = i >= right.length() ? '+' : right.charAt(i);
                if (c == '+' || c == '-') {
                    if (num != null) {
                        int nu = Integer.parseInt(num.toString());
                        numSum += nu;
                    }
                    num = new StringBuilder();
                    num.append(c);
                } else if (c == 'x') {
                    assert num != null;
                    if (num.charAt(0) == '-' && num.length() == 1) xSum++;
                    else if (num.charAt(0) == '+' && num.length() == 1) xSum--;
                    else xSum -= Integer.parseInt(num.toString());
                    num = null;
                } else {
                    assert num != null;
                    num.append(c);
                }
            }

            if (xSum == 0 && numSum != 0) {
                return "No solution";
            }
            if (xSum == 0) {
                return "Infinite solutions";
            }
            return "x=" + (numSum / xSum);
        }
    }
}
