package com.mqd;

/**
 * 牛吃草问题
 * 假设一定有n棵草
 * 每次只能吃4的x次方棵
 * 有两只牛，吃完最后一颗草的赢
 */
public class CowEatGrass {


    public static void main(String[] args) {
        System.out.println(solution(85));
        System.out.println(solution(85));
    }

    public static String solution(int n){
        //0,1,2,3,4,5 后先后先先
        if (n < 5){
            return (n == 0 || n == 2) ? "后手":"先手";
        }
        int count = 0, eat;
        while ((eat = 1<< count) <= n){
            if (solution(n-eat).equals("后手")) return "先手";
            count++;
            count++;
        }
        return "后手";
    }

    public static String solution2(int n){
        if (n % 5 == 0 || n % 5 ==2){
            return "后手";
        }
        return "先手";
    }

}
