package com.mqd.leetcode.medium;

import com.mqd.utils.TimeStatistic;

import java.util.*;

/**
 * leetcode 139 单词拆分
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 *
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 */
public class L139 {
    public static void main(String[] args) {
        L139 p = new L139();
        List<String> strings = Arrays.asList("a","abc","b","cd");
        TimeStatistic.func(() -> System.out.println(p.wordBreak("abcd", strings)));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        int max = 0;
        for (String s1 : wordDict) {
            dict.add(s1);
            max = Math.max(s1.length(), max);
        }
        return dp(s, dict, max);
    }

    private boolean dfs(String s, Set<String> dict, int index) {
        for (int i = index; i <= s.length(); i++)
            if (dict.contains(s.substring(index, i)) && (i == s.length() || dfs(s, dict, i))) return true;
        return false;
    }

    private boolean dp(String s, Set<String> dict, int max) {
        boolean[] dp = new boolean[s.length() + 1];
        Arrays.fill(dp, false);
        dp[0] = true;
        for (int i = 1; i <= s.length() ; i++) {
            if (dp[i - 1]) {
                int limit = Math.min(i + max, s.length());
                for (int j = i; j <= limit; j++) {
                    if (dp[j]) continue;
                    int minL = Math.min(j, s.length());
                    String key = s.substring(i - 1, minL);
                    dp[j] = dict.contains(key);
                }
            }
        }

        return dp[dp.length - 1];
    }
}
