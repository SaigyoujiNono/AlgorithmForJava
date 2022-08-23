package com.mqd.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode 剑指 Offer 50. 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 */
public class LOffer50 {


    static class Solution {
        public char firstUniqChar(String s) {
            Queue<Character> q = new LinkedList<>();
            int[] alpha = new int[26];
            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                if (alpha[index] == 0) {
                    q.add(s.charAt(i));
                }
                alpha[index]++;
            }
            while (!q.isEmpty()) {
                char poll = q.poll();
                if (alpha[poll - 'a'] == 1) {
                    return poll;
                }
            }
            return ' ';
        }
    }
}
