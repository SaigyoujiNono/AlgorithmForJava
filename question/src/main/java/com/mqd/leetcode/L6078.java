package com.mqd.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode  6078 重排字符形成目标字符串
 * 给你两个下标从 0 开始的字符串 s 和 target 。你可以从 s 取出一些字符并将其重排，得到若干新的字符串。
 *
 * 从 s 中取出字符并重新排列，返回可以形成 target 的 最大 副本数。
 */
public class L6078 {
    public int rearrangeCharacters(String s, String target) {
        char[] sArr = s.toCharArray();
        Map<Character, Integer> sMap = new HashMap<>();
        for (char c : sArr) {
            if (sMap.containsKey(c)) {
                sMap.put(c, sMap.get(c) + 1);
            } else {
                sMap.put(c, 1);
            }
        }
        int count = 0;
        char[] tArr = target.toCharArray();
        boolean flag = true;
        while (flag){
            for (char c : tArr) {
                if (sMap.containsKey(c)) {
                    int sum = sMap.get(c);
                    if (sum >= 1) {
                        sMap.put(c, sum - 1);
                    }else {
                        flag = false;
                        break;
                    }
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag)
                count++;
        }
        return count;
    }
}
