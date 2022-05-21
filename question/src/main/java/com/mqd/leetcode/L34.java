package com.mqd.leetcode;

import java.util.Arrays;

/**
 * leetcode 34 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回[-1, -1]。
 *
 * 来源：力扣（LeetCode）
 * @link https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L34 {
    public static void main(String[] args) {
        int[] arr = {2,2};
        System.out.println(Arrays.toString(searchRange(arr, 3)));
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int l = 0;
        int r = nums.length;
        int mid = (l + r) / 2;
        while (l <= r) {
            if (mid < nums.length && nums[mid] == target) {
                int li = mid, ri = mid;
                while (li >= 0 && nums[li] == target) {
                    li--;
                }
                li++;
                while (ri < nums.length && nums[ri] == target) {
                    ri++;
                }
                ri--;
                return new int[]{li, ri};
            } else if (mid < nums.length && nums[mid] > target) {
                r = mid - 1;
                mid = (l + r) / 2;
            }else {
                l = mid + 1;
                mid = (l + r) / 2;
            }
        }
        return new int[]{-1, -1};
    }
}
