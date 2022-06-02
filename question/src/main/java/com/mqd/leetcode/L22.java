package com.mqd.leetcode;

import com.mqd.utils.TimeStatistic;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 22 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 */
public class L22 {
    public static void main(String[] args) {
        L22 l22 = new L22();
        TimeStatistic.func(() -> {
            List<String> strings = l22.generateParenthesis(3);
        });
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        dfs(n, n, "", list);
        return list;
    }

    public void dfs(int l, int r, String cur, List<String> list) {
        if (l == 0 && r == 0) {
            list.add(cur);
        }
        if (l > 0) {
            dfs(l - 1, r, cur + "(", list);
        }
        if (r > l) {
            dfs(l, r - 1, cur + ")", list);
        }
    }
}
