package com.mqd;


/**
 * 去商店买苹果，一次只能买6个装或者8个装
 * 现在想买n个苹果，求最少包装袋数量，如果不能正好买n个苹果则返回-1
 */
public class BuyApple {


    public static void main(String[] args) {
        int n = 1121890248;
        long t1 = System.currentTimeMillis();
        System.out.println(solution(n));
        long t2 = System.currentTimeMillis();
        System.out.println(solution2(n));
        long t3 = System.currentTimeMillis();
        System.out.println(solution3(n));
        long t4 = System.currentTimeMillis();
        System.out.println(solution4(n));
        long t5 = System.currentTimeMillis();
        System.out.println("方法1: " + (t2 - t1) + "ms");
        System.out.println("方法2: " + (t3 - t2) + "ms");
        System.out.println("方法3: " + (t4 - t3) + "ms");
        System.out.println("方法4: " + (t5 - t4) + "ms");
    }

    public static int solution(int n) {
        if (n % 2 != 0) return -1;
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return -1;
        }
        return min(solution(n - 6), solution(n - 8));
    }

    public static int solution2(int n) {
        if (n % 2 != 0) return -1;
        int eight = n / 8;
        int six = 0;
        while (eight >= 0) {
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

    public static int solution3(int n) {
        if (n % 2 != 0) return -1;
        if (n % 8 == 0) {
            return n / 8;
        }
        if (n < 0) {
            return -1;
        }
        return min(solution3(n - 6), solution3(n - 8));
    }

    public static int solution4(int n) {
        if (n % 2 != 0) return -1;
        int apple = n;
        while (apple % 8 != 0 && apple > 5) {
            apple -= 6;
        }
        return apple < 0 ? -1 : apple / 8 + (n - apple) / 6;
    }

    private static int min(int x1, int x2) {
        if (x1 < 0 && x2 < 0) {
            return -1;
        } else if (x1 < 0) {
            return x2 + 1;
        } else if (x2 < 0) {
            return x1 + 1;
        } else {
            return Math.min(x1, x2) + 1;
        }
    }
}
