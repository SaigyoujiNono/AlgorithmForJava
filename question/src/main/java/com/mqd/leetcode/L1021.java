package com.mqd.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 1021 删除最外层的括号
 * 有效括号字符串为空 ""、"(" + A + ")" 或 A + B ，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。

例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
如果有效字符串 s 非空，且不存在将其拆分为 s = A + B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。

给出一个非空有效字符串 s，考虑将其进行原语化分解，使得：s = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。

对 s 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 s 。

来源：力扣（LeetCode）
@link https://leetcode.cn/problems/remove-outermost-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1021 {
    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())"));
    }

    public static String removeOuterParentheses(String s) {
        List<String> res = new ArrayList<>();
        int lef = 0;
        int c = 0;
        for(int i = 0; i < s.length();  i++) {
            if (lef == 0) {
                c = i;
            }
            if (s.charAt(i) == '(') {
                lef++;
            } else {
                lef--;
            }
            if (lef == 0) {
                res.add(s.substring(c, i + 1));
            }
        }
        StringBuilder sb = new StringBuilder();
        res.forEach(el -> sb.append(el, 1, el.length() - 1));
        return sb.toString();
    }
}
