package com.mqd;


/**
 * 有一些排成一行的正方形，每个正方形都有颜色(红色或者绿色)
 * 现在对这些正方形进行染色，需要每个红色R都比每个绿色G距离最左侧近
 * 求最少需要涂几个
 * 例如
 * s = RGRGR
 * res = RRRGG
 * 最少涂两个
 */
public class BlockPainting {

    public static void main(String[] args) {
        System.out.println(solution("GRRR"));
    }

    public static int solution(String s){
        int len = s.length()-1;
        int res = len+1;
        while (len>=0){
            int l = 0,r = 0;
            for (int i = 0; i < len; i++) {
                if (s.charAt(i) == 'G'){
                    l++;
                }
            }
            for (int i = s.length()-1; i >= len ; i--) {
                if (s.charAt(i) == 'R'){
                    r++;
                }
            }
            res = Math.min(res,l+r);
            len--;
        }
        return res;
    }
}
