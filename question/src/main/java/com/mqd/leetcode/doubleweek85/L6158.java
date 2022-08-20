package com.mqd.leetcode.doubleweek85;

import com.mqd.utils.TimeStatistic;

import java.util.Arrays;
import java.util.Random;

/**
 * leetcode 6158. 字母移位 II
 * 给你一个小写英文字母组成的字符串 s 和一个二维整数数组 shifts ，其中 shifts[i] = [starti, endi, directioni] 。
 * 对于每个 i ，将 s 中从下标 starti 到下标 endi （两者都包含）所有字符都进行移位运算，如果 directioni = 1 将字符向后移位，
 * 如果 directioni = 0 将字符向前移位。
 *
 * 将一个字符 向后 移位的意思是将这个字符用字母表中 下一个 字母替换（字母表视为环绕的，所以 'z' 变成 'a'）。
 * 类似的，将一个字符 向前 移位的意思是将这个字符用字母表中 前一个 字母替换（字母表是环绕的，所以 'a' 变成 'z' ）。
 *
 * 请你返回对 s 进行所有移位操作以后得到的最终字符串。
 */
public class L6158 {

    public static void main(String[] args) {
        Solution p = new Solution();
        Random random = new Random(System.nanoTime());
        for (int j = 0; j < 10; j++) {
            StringBuilder t1 = new StringBuilder();
            int[][] arr = new int[50000][3];
            for (int i = 0; i < 50000; i++) {
                int a = random.nextInt('a', 'z' + 1);
                t1.append((char)a);
                arr[i] = new int[]{random.nextInt(0, 50000), random.nextInt(0, 50000), random.nextInt(0,2)};
            }

            TimeStatistic.func(() -> System.out.println(p.shiftingLetters(t1.toString(), arr)));
        }
    }

    static class Solution {
        public String shiftingLetters(String s, int[][] shifts) {
            char[] cs = s.toCharArray();
            Arrays.sort(shifts, (x1, x2) -> {
                if (x1[0] == x2[0]) {
                    if (x1[1] == x2[1]) {
                        return 0;
                    }
                    return x1[1] - x2[1];
                }
                return x1[0] - x2[0];
            });
//            System.out.println(System.currentTimeMillis());
            int[] counts = new int[cs.length];
            for (int[] shift : shifts) {
                for (int i = shift[0]; i <= shift[1]; i++) {
                    if(shift[2] == 1) counts[i]++;
                    else counts[i]--;
                }
            }
//            for (int[] shift : shifts) {
//                for (int i = shift[0]; i <= shift[1]; i++) {
//                    if(shift[2] == 1) cs[i] = cs[i] + 1 > 'z' ? 'a' : (char)(cs[i] + 1);
//                    else cs[i] = cs[i] - 1 < 'a' ? 'z' : (char)(cs[i] - 1);
//                }
//            }
//            for (int i = 0; i < counts.length; i++) {
//                int l = 0;
//                int j = 0;
//                while (j < shifts.length && shifts[j][0] <= i) j++;
//                while (j < shifts.length && shifts[j][0] <= i && i <= shifts[j][1]) {
//                    if (shifts[i][2] == 1) {
//                        l++;
//                    } else {
//                        l--;
//                    }
//                    j++;
//                }
//                counts[i] = l;
//            }
//            System.out.println(System.currentTimeMillis());
            for (int i = 0; i < cs.length; i++) {
                if (counts[i] == 0) {
                    continue;
                }
                if (counts[i] < 0) {
                    cs[i] = pre(cs[i], -counts[i]);
                } else {
                    cs[i] = next(cs[i], counts[i]);
                }
            }
//            System.out.println(System.currentTimeMillis());
            return String.valueOf(cs);
        }

        private char next(char c, int k) {
            k = k % 26;
            if (c + k <= 'z') {
                return (char)(c + k);
            }
            int s = c + k - 'z';
            return (char)(('a' - 1) + s);
        }

        private char pre(char c, int k) {
            k = k % 26;
            if (c - k >= 'a') {
                return (char)(c - k);
            }
            int s = 'a' - (c - k);
            return (char)(('z' + 1) - s);
        }
    }
}
