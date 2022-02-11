package com.mqd;

/**
 * 去商店买苹果，一次只能买6个装或者8个装
 * 现在想买n个苹果，求最少包装袋数量，如果不能正好买n个苹果则返回-1
 */
public class BuyApple {


    public static void main(String[] args) {
        int n = 301;
        long t1 = System.currentTimeMillis();
        System.out.println(solution(n));
        long t2 = System.currentTimeMillis();
        System.out.println(solution2(n));
        long t3 = System.currentTimeMillis();
        System.out.println("方法1: " + (t2 - t1) + "ms");
        System.out.println("方法2: " + (t3 - t2) + "ms");
    }

    public static int solution(int n) {
        if (n%2!=0) return -1;
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return -1;
        }
        int solution1 = solution(n - 6);
        int solution2 = solution(n - 8);
        if (solution1 < 0 && solution2 < 0) {
            return -1;
        } else if (solution1 < 0) {
            return solution2 + 1;
        } else if (solution2 < 0) {
            return solution1 + 1;
        } else {
            return Math.min(solution1, solution2) + 1;
        }
    }

    public static int solution2(int n) {
        if (n%2!=0) return -1;
        int eight = n / 8;
        int six = 0;
        while (eight > 0) {
            while ((n - (eight * 8 + six * 6)) > 5) {
                six++;
            }
            if (eight * 8 + six * 6 == n) {
                return eight + six;
            }
            eight--;
        }
        return -1;
    }
}
