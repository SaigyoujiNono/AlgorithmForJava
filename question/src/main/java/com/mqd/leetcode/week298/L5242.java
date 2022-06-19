package com.mqd.leetcode.week298;

import com.mqd.utils.TimeStatistic;

import java.util.HashSet;
import java.util.Set;

/**
 * leetcode 5242 兼具大小写的最好英文字母
 * 给你一个由英文字母组成的字符串 s ，请你找出并返回 s 中的 最好 英文字母。返回的字母必须为大写形式。如果不存在满足条件的字母，则返回一个空字符串。
 *
 * 最好 英文字母的大写和小写形式必须 都 在 s 中出现。
 *
 * 英文字母 b 比另一个英文字母 a 更好 的前提是：英文字母表中，b 在 a 之 后 出现。
 *
 */
public class L5242 {
    public static void main(String[] args) {
        L5242 p = new L5242();
        TimeStatistic.func(() -> System.out.println(p.greatestLetter("lEeTcOdE")));
    }

    public String greatestLetter(String s) {
        int gap = 'a' - 'A';
        Set<Character> upper = new HashSet<>();
        Set<Character> lower = new HashSet<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar >= 65 && aChar <= 90) {
                upper.add(aChar);
            } else {
                lower.add(aChar);
            }
        }
        for (char i = 122; i >= 97; i--) {
            char up = (char)(i - gap);
            if (lower.contains(i) && upper.contains(up)) {
                return String.valueOf((char)(i - gap));
            }
        }
        return "";
    }
}
