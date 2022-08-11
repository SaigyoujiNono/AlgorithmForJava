package com.mqd.leetcode.easy;

import java.util.*;

/**
 * leetcode 1417. 重新格式化字符串
 * 给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
 *
 * 请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，字母后面应该跟着数字，而数字后面应该跟着字母。
 *
 * 请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。
 */
public class L1417 {

    public static void main(String[] args) {

    }

    static class Solution {
        public String reformat(String s) {
            List<Character> alphas = new ArrayList<>();
            List<Character> nums = new ArrayList<>();
            char[] chars = s.toCharArray();
            for (char aChar : chars) {
                if (aChar >= 'a' && aChar <= 'z') {
                    alphas.add(aChar);
                } else {
                    nums.add(aChar);
                }
            }
            if (Math.abs(alphas.size() - nums.size()) > 1) {
                return "";
            }
            StringBuilder ans = new StringBuilder();
            List<Character> priority = alphas.size() >= nums.size() ? alphas : nums;
            List<Character> defer = alphas.size() < nums.size() ? alphas : nums;
            Iterator<Character> priIt = priority.iterator();
            Iterator<Character> deferIt = defer.iterator();
            while (priIt.hasNext() || deferIt.hasNext()) {
                if (priIt.hasNext()) {
                    ans.append(priIt.next());
                }
                if (deferIt.hasNext()) {
                    ans.append(deferIt.next());
                }
            }
            return ans.toString();
        }
    }
}
