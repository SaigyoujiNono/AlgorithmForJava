package com.mqd.leetcode.hard;

/**
 * leetcode 135. 分发糖果
 */
public class L135 {

    public static void main(String[] args) {
        Solution p = new Solution();
//        int[] arr = {1,0,2};
        int[] arr = {8,7,6,5,4,3,2,2,3,1,5,5,6,8,9,1,2,3,3,5,5,1,1,0,0,4,4,8,8,9,9,8,7,6,5,4,3,2,1};
        System.out.println(p.candy(arr));
    }


    static class Solution {
        public int candy(int[] ratings) {
            if (ratings == null || ratings.length == 0) return 0;
            if (ratings.length == 1) return 1;
            int[] m = new int[ratings.length];
            m[0] = 1;
            int ans = 1;
            for (int i = 1; i < m.length; i++) {
                // 如果当前分数比前一个大，直接在前一个的基础上 + 1
                if (ratings[i] > ratings[i - 1]) {
                    m[i] = m[i - 1] + 1;
                    ans += m[i];
                    continue;
                }
                // 如果分数<=前一个则直接分一个糖果
                m[i] = 1;
                ans++;
                for (int j = i; j > 0; j--) {
                    int next =ratings[j];
                    int pre = ratings[j - 1];
                    if (m[j] >= m[j - 1] && ratings[j] < ratings[j - 1]) {
                        ans -= m[j - 1];
                        m[j - 1] = m[j] + 1;
                        ans += m[j - 1];
                    } else {
                        break;
                    }
                }
            }
            return ans;
        }
    }
}
