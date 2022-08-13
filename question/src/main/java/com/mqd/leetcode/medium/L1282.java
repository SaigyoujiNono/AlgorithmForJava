package com.mqd.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode 1282. 用户分组
 * 有n个人被分成数量未知的组。每个人都被标记为一个从 0 到 n - 1 的唯一ID。
 *
 * 给定一个整数数组 groupSizes ，其中groupSizes[i]是第 i 个人所在的组的大小。
 * 例如，如果groupSizes[1] = 3，则第 1 个人必须位于大小为 3 的组中。
 *
 * 返回一个组列表，使每个人 i 都在一个大小为groupSizes[i]的组中。
 *
 * 每个人应该恰好只出现在一个组中，并且每个人必须在一个组中。如果有多个答案，返回其中任何一个。
 * 可以保证给定输入至少有一个有效的解。
 */
public class L1282 {
    public static void main(String[] args) {
        Solution p = new Solution();
        int[] arr = {3,3,3,3,3,1,3};
        System.out.println(p.groupThePeople(arr));
    }

    static class Solution {
        public List<List<Integer>> groupThePeople(int[] groupSizes) {
            List<List<Integer>> ans = new ArrayList<>();
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < groupSizes.length; i++) {
                List<Integer> list = map.get(groupSizes[i]);
                list = list == null ? new ArrayList<>() : list;
                list.add(i);
                if (list.size() == groupSizes[i]) {
                    ans.add(list);
                    map.put(groupSizes[i], null);
                } else {
                    map.put(groupSizes[i], list);
                }
            }
            return ans;
        }
    }
}
