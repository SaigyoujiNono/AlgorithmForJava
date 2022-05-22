package com.mqd.leetcode;

/**
 * leetcode 6074 字母在字符串中的百分比
 * 给你一个字符串 s 和一个字符 letter ，返回在 s 中等于 letter 字符所占的 百分比 ，向下取整到最接近的百分比。
 */
public class L6074 {
    public static void main(String[] args) {
        System.out.println(percentageLetter("foobar", 'o'));
    }
    public static int percentageLetter(String s, char letter) {
        char[] chars = s.toCharArray();
        int count = 0;
        for (char aChar : chars) {
            if (aChar == letter) {
                count++;
            }
        }
        return (int)((((double)count) / s.length()) * 100);
    }
}
