package com.mqd.leetcode.hard;

import java.util.*;

/**
 * leetcode 30 串联所有单词的子串
 * 给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。
 *
 */
public class L30 {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();

        if (s == null || s.length() == 0) {
            return res;
        }
        int wordLen = words[0].length();
        int subLength = wordLen * words.length;
        if (subLength > s.length()) {
            return res;
        }
        // 设置字典
        Map<String, Integer> dict = new HashMap<>();
        Arrays.stream(words).forEach(el -> dict.put(el, dict.getOrDefault(el, 0) + 1));

        int l = 0;
        int r = subLength;
        while (r <= s.length()) {
            String subString = s.substring(l, r);
            Map<String, Integer> temp = new HashMap<>();
            int index = 0;
            while (index + wordLen <= subLength) {
                String word = subString.substring(index, index + wordLen);
                if (!dict.containsKey(word)) {
                    break;
                } else {
                    temp.put(word, temp.getOrDefault(word, 0) + 1);
                }
                index += wordLen;
            }
            if (dict.equals(temp)) {
                res.add(l);
            }
            l++;
            r++;
        }
        return res;
    }
}
