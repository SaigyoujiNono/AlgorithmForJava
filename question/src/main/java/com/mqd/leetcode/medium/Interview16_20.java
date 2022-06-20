package com.mqd.leetcode.medium;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * leetcode 面试题16.20 T9键盘
 * 在老式手机上，用户通过数字键盘输入，手机将提供与这些数字相匹配的单词列表。每个数字映射到0至4个字母。
 * 给定一个数字序列，实现一个算法来返回匹配单词的列表。你会得到一张含有有效单词的列表。映射如下图所示：
 */
public class Interview16_20 {
    public List<String> getValidT9Words(String num, String[] words) {
        int[] keyboard = {2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,8,8,8,9,9,9,9};
        char[] numChar = num.toCharArray();
        Predicate<String> predicate = word -> {
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (keyboard[chars[i] - 'a'] != numChar[i] - '0') {
                    return false;
                }
            }
            return true;
        };
        return Arrays.stream(words).filter(predicate).collect(Collectors.toList());
    }
}
