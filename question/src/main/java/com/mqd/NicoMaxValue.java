package com.mqd;

import java.util.stream.IntStream;

/**
 * nico nico问题 (牛客)
 * 给定三个字符串 nico = 1, niconi = 2, niconiconi = 5
 * 给定一个字符串str, 求字符串包含上述字符串的最大值
 */
public class NicoMaxValue {

    private static final String ONE = "nico";
    private static final String TWO = "niconi";
    private static final String FIVE = "niconiconi";

    public static void main(String[] args) {
        String test = "niconiconinnniconinininico";
        System.out.println(solution(test));
    }

    public static int solution(String str){
        return process(str,0);
    }

    public static int process(String str, int start){
        if (start + ONE.length() > str.length()) return 0;
        int res1, res2, res3;
        if (ONE.equals(str.substring(start, start + ONE.length()))){
            res1 = process(str, start + ONE.length()) + 1;
        }else {
            res1 = (start + ONE.length() >= str.length()) ? 0 : process(str, start + 1);
        }

        if (res1 != 0 && (start + TWO.length() <= str.length()) && TWO.equals(str.substring(start, start + TWO.length()))){
            res2 = process(str, start + TWO.length()) + 2;
        }else {
            res2 = (start + 6 >= str.length()) ? 0 : process(str, start + 1);
        }

        if (res2 != 0 && (start + FIVE.length() <= str.length()) && FIVE.equals(str.substring(start, start + FIVE.length()))){
            res3 = process(str, start + FIVE.length()) + 5;
        }else {
            res3 = (start + FIVE.length() >= str.length()) ? 0 : process(str, start + 1);
        }

        return IntStream.of(res1,res2,res3).max().getAsInt();
    }
}
