package com.mqd.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 1408. 数组中的字符串匹配
 * 给你一个字符串数组 words ，数组中的每个字符串都可以看作是一个单词。请你按 任意 顺序返回 words 中是其他单词的子字符串的所有单词。
 *
 * 如果你可以删除 words[j] 最左侧和/或最右侧的若干字符得到 word[i] ，那么字符串 words[i] 就是 words[j] 的一个子字符串。
 */
public class L1408 {

    public static void main(String[] args) {
        Solution p = new Solution();

    }

    static class Solution {
        public List<String> stringMatching(String[] words) {
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < words.length; i++) {
                for (int j = 0; j < words.length; j++) {
                    if (j == i) continue;
                    if (words[j].contains(words[i])) {
                        ans.add(words[i]);
                        break;
                    }
                }
            }
            return ans;
        }
    }
}
