package com.mqd.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * leetcode offer 2 80含有 k 个元素的组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */
public class LOfferII80 {
    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<Integer> mid = new Stack<>();
        process(1, n, k, res, mid);
        return res;
    }

    public static void process(int s, int n, int k, List<List<Integer>> res, Stack<Integer> mid) {
        if (k == 0) {
            List<Integer> temp = new ArrayList<>(mid);
            res.add(temp);
            return;
        }
        for (int i = s; i <= n; i++) {
            mid.push(i);
            process(i+1, n, k-1, res, mid);
            mid.pop();
        }
    }
}
