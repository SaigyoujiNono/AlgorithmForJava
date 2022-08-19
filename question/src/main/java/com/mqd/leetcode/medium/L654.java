package com.mqd.leetcode.medium;

import com.mqd.struct.TreeNode;

/**
 * leetcode 654. 最大二叉树
 * 给定一个不重复的整数数组nums 。最大二叉树可以用下面的算法从nums 递归地构建:
 *
 * 创建一个根节点，其值为nums 中的最大值。
 * 递归地在最大值左边的子数组前缀上构建左子树。
 * 递归地在最大值 右边 的子数组后缀上构建右子树。
 */
public class L654 {


    static class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return dfs(nums, 0, nums.length - 1);
        }

        private TreeNode dfs(int[] nums, int l, int r) {
            if (l > r) {
                return null;
            }
            int maxIndex = l;
            int i = l;
            int maxVal = -1;
            while (i <= r) {
                if (nums[i] > maxVal) {
                    maxVal = nums[i];
                    maxIndex = i;
                }
                i++;
            }
            TreeNode treeNode = new TreeNode(nums[maxIndex]);
            treeNode.left = dfs(nums, l, maxIndex - 1);
            treeNode.right = dfs(nums, maxIndex + 1, r);
            return treeNode;
        }
    }
}
