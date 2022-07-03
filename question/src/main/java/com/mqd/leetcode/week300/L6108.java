package com.mqd.leetcode.week300;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 6108. 解密消息
 * 使用 key 中 26 个英文小写字母第一次出现的顺序作为替换表中的字母 顺序 。
 * 将替换表与普通英文字母表对齐，形成对照表。
 * 按照对照表 替换 message 中的每个字母。
 * 空格 ' ' 保持不变。
 * 例如，key = "happy boy"（实际的加密密钥会包含字母表中每个字母 至少一次），
 * 据此，可以得到部分对照表（'h' -> 'a'、'a' -> 'b'、'p' -> 'c'、'y' -> 'd'、'b' -> 'e'、'o' -> 'f'）。
 */
public class L6108 {
    public static void main(String[] args) {
        L6108 p = new L6108();
        System.out.println(p.decodeMessage("eljuxhpwnyrdgtqkviszcfmabo", "zwx hnfx lqantp mnoeius ycgk vcnjrdb"));
    }

    public String decodeMessage(String key, String message) {
        Map<Character, Character> dict = new HashMap<>();
        char index = 'a';
        for (char c : key.toCharArray()) {
            if (dict.size() < 26) {
                if (c == ' ' || dict.containsKey(c)) continue;
                dict.put(c, index);
                index++;
            } else {
                break;
            }
        }
        char[] strChars = new char[message.length()];
        char[] chars = message.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                strChars[i] = chars[i];
            } else {
                strChars[i] = dict.get(chars[i]);
            }
        }
        return String.valueOf(strChars);
    }
}
