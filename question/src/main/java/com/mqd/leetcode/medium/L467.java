package com.mqd.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 467 环绕字符串中唯一的子字符串
 * 把字符串 s 看作是“abcdefghijklmnopqrstuvwxyz”的无限环绕字符串，所以s 看起来是这样的：
 *
 * "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....".
 * 现在给定另一个字符串 p 。返回s 中唯一 的 p 的 非空子串的数量。
 */
public class L467 {
    public int findSubstringInWraproundString(String p) {
        char[] chars = p.toCharArray();
        int[] dp = new int[chars.length + 1];
        Map<Character, Integer> map = new HashMap<>();
        dp[0] = 1;
        map.put(chars[0], 1);
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == (chars[i-1] + 1) || chars[i] == (chars[i-1] + 1 - 26) ) {
                dp[i] = dp[i-1] + 1;
            } else{
                dp[i] = 1;
            }
            Integer integer = map.get(chars[i]);
            if (integer == null) {
                map.put(chars[i], dp[i]);
            } else {
                map.put(chars[i], Math.max(integer, dp[i]));
            }
        }
        int r = 0;
        for (Integer value : map.values()) {
            r += value;
        }

        return r;
    }
}
