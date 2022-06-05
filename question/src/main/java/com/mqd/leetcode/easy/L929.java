package com.mqd.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * leetcode 929  独特的电子邮件地址
 * 每个 有效电子邮件地址 都由一个 本地名 和一个 域名 组成，以 '@' 符号分隔。除小写字母之外，电子邮件地址还可以含有一个或多个 '.' 或 '+' 。
 *
 * 例如，在 alice@leetcode.com中， alice 是 本地名 ，而 leetcode.com 是 域名 。
 * 如果在电子邮件地址的 本地名 部分中的某些字符之间添加句点（'.'），则发往那里的邮件将会转发到本地名中没有点的同一地址。请注意，此规则 不适用于域名 。
 *
 * 例如，"alice.z@leetcode.com” 和 “alicez@leetcode.com” 会转发到同一电子邮件地址。
 * 如果在 本地名 中添加加号（'+'），则会忽略第一个加号后面的所有内容。这允许过滤某些电子邮件。同样，此规则 不适用于域名 。
 *
 * 例如 m.y+name@email.com 将转发到 my@email.com。
 * 可以同时使用这两个规则。
 *
 * 给你一个字符串数组 emails，我们会向每个 emails[i] 发送一封电子邮件。返回实际收到邮件的不同地址数目。
 */
public class L929 {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        int res = 0;
        for (String email : emails) {
            String emailAddress = getEmailAddress(email);
            System.out.println(emailAddress);
            if (!set.contains(emailAddress)) {
                set.add(emailAddress);
            } else {
                res++;
            }
        }
        return res;
    }

    private String getEmailAddress(String email) {
        String[] split = email.split("@");
        String s = split[0];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+') {
                break;
            } else if (s.charAt(i) != '.') {
                sb.append(s.charAt(i));
            }
        }
        sb.append('@').append(split[1]);
        return sb.toString();
    }
}
