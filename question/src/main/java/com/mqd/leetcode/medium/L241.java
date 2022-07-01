package com.mqd.leetcode.medium;

import com.mqd.utils.TimeStatistic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 241. 为运算表达式设计优先级
 * 给你一个由数字和运算符组成的字符串 expression ，按不同优先级组合数字和运算符，计算并返回所有可能组合的结果。你可以 按任意顺序 返回答案。
 *
 * 生成的测试用例满足其对应输出值符合 32 位整数范围，不同结果的数量不超过 10^4 。
 */
public class L241 {
//    private final List<String> tests = Arrays.asList("2-1-1");
    private final List<String> tests = Arrays.asList("11", "2-1-1", "2*3-4*5", "2*3-4*5+9-4*8-6-7+4");

    public static void main(String[] args) {
        L241 p = new L241();
        TimeStatistic.func(() -> p.tests.forEach(el -> System.out.println(p.diffWaysToCompute(el))));
    }
    private char[] chars;

    public List<Integer> diffWaysToCompute(String expression) {
        chars = expression.toCharArray();
        return dfs(0, expression.length() - 1);
    }

    public List<Integer> dfs(int l, int r) {
        List<Integer> res = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                continue;
            }
            List<Integer> list1 = dfs(l, i - 1);
            List<Integer> list2 = dfs(i + 1, r);
            int finalI = i;
            list1.forEach(a -> list2.forEach(b -> {
                int current;
                switch (chars[finalI]) {
                    case '+' -> current = a + b;
                    case '-' -> current = a - b;
                    default -> current = a * b;
                }
                res.add(current);
            }));
        }
        if (res.isEmpty()) {
            int cur = 0;
            for (int i = l; i <= r; i++) {
                cur = cur * 10 + (chars[i] - '0');
            }
            res.add(cur);
        }
        return res;
    }
}
