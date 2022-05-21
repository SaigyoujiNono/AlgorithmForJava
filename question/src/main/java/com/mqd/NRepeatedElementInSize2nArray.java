package com.mqd;

import com.mqd.utils.TimeStatistic;

import java.util.HashSet;

/**
 * leetcode 961
 * 给你一个整数数组 nums ，该数组具有以下属性：
 *
 * nums.length == 2 * n.
 * nums 包含 n + 1 个 不同的 元素
 * nums 中恰有一个元素重复 n 次
 * 找出并返回重复了 n 次的那个元素。
 *
 * 来源：力扣（LeetCode）
 * @link https://leetcode.cn/problems/n-repeated-element-in-size-2n-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NRepeatedElementInSize2nArray {
    public static void main(String[] args) {
        TimeStatistic.func(() -> {
//            int[] arr = {4,1,7,0,0,9,0,0};
            int[] arr = {1,2,0,2,2,2,4,8};
//            int[] arr = {4,1,7,0,0,9,0,0};
            System.out.println(repeatedNTimes(arr));
        });
    }

    /**
     * 哈希
     */
    public static int repeatedNTimes(int[] nums) {
        HashSet<Integer> zeros = new HashSet<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int ind = Math.abs(nums[i]);
            if (ind < nums.length) {
                if (nums[ind] == 0) {
                    if (zeros.contains(ind)) {
                        return Math.abs(nums[i]);
                    } else {
                        zeros.add(ind);
                    }
                } else if (nums[ind] > 0) {
                    nums[ind] = -nums[ind];
                } else {
                    return Math.abs(nums[i]);
                }
            } else {
                if (set.contains(ind)) {
                    return ind;
                }else {
                    set.add(ind);
                }
            }

        }
        return 0;
    }
}
