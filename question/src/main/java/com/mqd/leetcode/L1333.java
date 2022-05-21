package com.mqd.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 1333
 * 给你一个餐馆信息数组 restaurants，其中  restaurants[i] = [idi, ratingi, veganFriendlyi, pricei, distancei]。你必须使用以下三个过滤器来过滤这些餐馆信息。
 *
 * 其中素食者友好过滤器 veganFriendly 的值可以为 true 或者 false，如果为 true 就意味着你应该只包括 veganFriendlyi 为 true 的餐馆，为 false 则意味着可以包括任何餐馆。此外，我们还有最大价格 maxPrice 和最大距离 maxDistance 两个过滤器，它们分别考虑餐厅的价格因素和距离因素的最大值。
 *
 * 过滤后返回餐馆的 id，按照 rating 从高到低排序。如果 rating 相同，那么按 id 从高到低排序。简单起见， veganFriendlyi 和 veganFriendly 为 true 时取值为 1，为 false 时，取值为 0 。
 *
 * 来源：力扣（LeetCode）
 * @link https://leetcode.cn/problems/filter-restaurants-by-vegan-friendly-price-and-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1333 {
    public static void main(String[] args) {
//        int[][] restaurants = {{1,4,1,40,10},{2,8,0,50,5},{3,8,1,30,4},{4,10,0,10,3},{5,1,1,15,1}};
//        int[][] restaurants = {{2817,54550,0,24368,82491},{94849,38849,0,97406,43608},{94567,93218,1,66548,87859},
//                {24884,39764,1,77016,65453},{66229,51558,0,62945,31817}};
        int[][] restaurants = {{22482,92278,0,49542,26268},{45473,12980,0,75155,88363},
                {56748,77518,0,64534,13688},{87289,51127,1,66075,65510},{2255,42644,1,36878,2372},
                {20574,26327,1,73839,17714}};

        System.out.println(filterRestaurants(restaurants, 1, 56262, 27923));
    }

    public static List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        Arrays.sort(restaurants, (x1, x2) -> {
            if (veganFriendly != 0) {
                if (x1[2] == x2[2] && x1[2] == 1) {
                    if (x1[1] == x2[1]) {
                        return x2[0] - x1[0];
                    }else {
                        return x2[1] - x1[1];
                    }
                }else if (x1[2] == x2[2]){
                    return 0;
                } else {
                    if (x1[2] == 1) {
                        return -1;
                    }else {
                        return 1;
                    }
                }
            }else {
                if (x1[1] == x2[1]) {
                    return x2[0] - x1[0];
                }else {
                    return x2[1] - x1[1];
                }
            }
        });
        List<Integer> res = new ArrayList<>();
        for (int[] restaurant : restaurants) {
            if (veganFriendly != 0) {
                if (restaurant[2] == 1 && (restaurant[3] <= maxPrice && restaurant[4] <= maxDistance)) {
                    res.add(restaurant[0]);
                }
            } else {
                if (restaurant[3] <= maxPrice && restaurant[4] <= maxDistance) {
                    res.add(restaurant[0]);
                }
            }
        }
        return res;
    }
}
