package com.mqd.leetcode;

import com.mqd.utils.TimeStatistic;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 1513
 * 给你一个二进制字符串 s（仅由 '0' 和 '1' 组成的字符串）。
 *
 * 返回所有字符都为 1 的子字符串的数目。
 *
 * 由于答案可能很大，请你将它对 10^9 + 7 取模后返回。
 *
 * 来源：力扣（LeetCode）
 * @link https://leetcode.cn/problems/number-of-substrings-with-only-1s
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1513 {

    public static void main(String[] args) {
        TimeStatistic.func(() -> System.out.println(numSub("111111")));

    }

    public static int numSub(String s) {
        Map<Integer, Long> factCache = new HashMap<>();
        int left = 0;
        long res = 0;
        while (left < s.length()) {
            if (s.charAt(left) != '1') {
                left++;
            } else {
                int right = left;
                while (right< s.length() && s.charAt(right) == '1') {
                    right++;
                }
                int len = right - left;
                Long x = factCache.get(len);
                if (x == null) {
                    x = 0L;
                    for (int i = 1; i <= len; i++) {
                        x += i;
                        x %= 1000000007;
                    }
                    factCache.put(len, x);
                }
                res += x;
                res %= 1000000007;
                left = right;
            }
        }
        return (int)res;
    }
}
