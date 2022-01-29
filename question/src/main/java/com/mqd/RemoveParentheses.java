package com.mqd;

/**
 * 你将得到一个由小写字母 a-z ，左括号 '(' 和右括号 ')' 构成的字符串 s。
 * 你的任务是删除尽可能少的括号，使得 s 里面的括号匹配。
 * 你需要返回删除括号后的字符串。
 * 由于答案可能会有很多，所以你只需要返回任意一个正确答案。
 *
 * 例如："()", "(())", "()()", "(())()" 是括号匹配的字符串， 而 ")(", "(()", "()()(", "()())" 则是括号不匹配的字符串。
 */
public class RemoveParentheses {

    public static void main(String[] args) {
        String s1 = "(ab(c(de)fg)";
        String s2 = "(((";
        String s3 = "a(b(c(de)fgh)";
        String s4 = "tyweggadosw(sbvf)n((";
        String s5 = "i(j))i(";

        System.out.println(solution(s5));
        System.out.println(solution2(s5));
    }

    public static String solution(String s){
        int first = 0,second = 0;
        String res = s;
        while (first<res.length()){
            if (res.charAt(first) == ')' && second<=first){
                res = res.substring(0,first) + res.substring(first+1);
            }else if (res.charAt(first) == '('){
                boolean flag = false;
                while (second<res.length()){
                    if (res.charAt(second) == ')') {
                        flag = true;
                        break;
                    }
                    second++;
                }
                if (!flag){
                    res = res.substring(0,first) + res.substring(first+1);
                }else {
                    first++;
                    second++;
                }
            }else {
                first++;
            }
        }
        return res;
    }

    public static String solution2(String s){
        int first = 0,second = 0;
        StringBuilder res = new StringBuilder(s);
        while (first<res.length()){
            if (res.charAt(first) == ')' && second<=first){
                res.deleteCharAt(first);
            }else if (res.charAt(first) == '('){
                boolean flag = false;
                while (second<res.length()){
                    if (res.charAt(second) == ')') {
                        flag = true;
                        break;
                    }
                    second++;
                }
                if (!flag){
                    res.deleteCharAt(first);
                }else {
                    first++;
                    second++;
                }
            }else {
                first++;
            }
        }
        return res.toString();
    }
}
