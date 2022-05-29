package com.mqd.leetcode;

import java.util.regex.Pattern;

/**
 * leetcode 6079 价格减免
 * 句子 是由若干个单词组成的字符串，单词之间用单个空格分隔，其中每个单词可以包含数字、小写字母、和美元符号 '$' 。如果单词的形式为美元符号后跟着一个非负实数，那么这个单词就表示一个价格。
 *
 * 例如 "$100"、"$23" 和 "$6.75" 表示价格，而 "100"、"$" 和 "2$3" 不是。
 * 注意：本题输入中的价格均为整数。
 *
 * 给你一个字符串 sentence  和一个整数 discount 。对于每个表示价格的单词，都在价格的基础上减免 discount% ，并 更新 该单词到句子中。所有更新后的价格应该表示为一个 恰好保留小数点后两位 的数字。
 *
 * 返回表示修改后句子的字符串。
 */
public class L6079 {
    public static void main(String[] args) {
        String s = "$123th$1ere $4are $1 $2 and$85 5$ candies in the shop";
        System.out.println(discountPrices(s, 50));
    }

    public static String discountPrices(String sentence, int discount) {
        double d = ((double)discount) / 100;
        String[] sArr = sentence.split(" ");
        Pattern compile = Pattern.compile("^\\$\\d+$");
        for (int i = 0; i < sArr.length; i++) {
            String str = sArr[i];
            if (compile.matcher(str).matches()) {
                double price = Double.parseDouble(str.substring(1));
                price = price - price * d;
                sArr[i] = String.format("$%.2f", price);
             }
        }
        return String.join(" ", sArr);
    }
}
