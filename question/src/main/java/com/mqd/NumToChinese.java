package com.mqd;

/**
 * 给定一个范围[0, 999999]
 * 将其转为中文输出
 * 例如11，转为一十一，1S1
 *
 */
public class NumToChinese {
    public static void main(String[] args) {
        System.out.println(toChinese(1070405));
    }

    public static String toChinese(int num) {
        int n = num;
        int len = 1;
        while ((n = n / 10) > 0) {
            len++;
        }
        String str = "";
        if (len >= 1) {
            str = num == 0 ? "L" : (num % 10 + "");
        }
        if (len >= 2) {
            str = (num % 100 / 10) + "S" + ((num % 10) == 0 ? "" : (num % 10));
        }
        if (len >= 3) {
            str = (num % 1000 / 100) + "B" + str;
        }
        if (len >= 4) {
            str = (num % 10000 / 1000) + "Q" + str;
        }
        if (len >= 5) {
            str = toChinese(num / 10000) + "W" + str;
        }
        str = str.replaceAll("0\\w", "L");
        StringBuilder sb = new StringBuilder(str);
        char pre = 'A';
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == pre) {
                sb.deleteCharAt(i);
                i--;
            }
            pre = sb.charAt(i);
        }
        return sb.toString();
    }
}
