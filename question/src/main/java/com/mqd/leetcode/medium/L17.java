package com.mqd.leetcode.medium;

import com.mqd.utils.TimeStatistic;

import java.util.*;

/**
 * leetcode 17 电话号码的字母组合
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class L17 {
    public static void main(String[] args) {
        TimeStatistic.func(() -> {
            L17 l17 = new L17();
            System.out.println(l17.letterCombinations("23"));
        });
    }

    public List<String> letterCombinations(String digits) {
        boolean blank = digits.isBlank();
        if (blank) {
            return new ArrayList<>();
        }
        Map<Character, Character[]> map = new HashMap<>();
        map.put('2', new Character[]{'a','b','c'});
        map.put('3', new Character[]{'d','e','f'});
        map.put('4', new Character[]{'g','h','i'});
        map.put('5', new Character[]{'j','k','l'});
        map.put('6', new Character[]{'m','o','n'});
        map.put('7', new Character[]{'p','q','r','s'});
        map.put('8', new Character[]{'t','u','v'});
        map.put('9', new Character[]{'w','x','y','z'});
        List<String> res = new ArrayList<>();
        process(digits, res, 0, map, new StringBuilder());
        return res;
    }

    public void process(String digits, List<String> res, int index, Map<Character, Character[]> map, StringBuilder sb) {
        Character[] characters = map.get(digits.charAt(index));
        for (Character character : characters) {
            if (index != digits.length() - 1) {
                sb.append(character);
                process(digits, res, index + 1, map, sb);
                sb.deleteCharAt(sb.length() - 1);
            } else {
                res.add(sb.toString() + character);
            }
        }
    }
}
