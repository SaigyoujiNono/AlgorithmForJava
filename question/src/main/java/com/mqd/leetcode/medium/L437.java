package com.mqd.leetcode.medium;

import com.mqd.struct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode 437. 路径总和 III
 * 给定一个二叉树的根节点 root，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 *
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 */
public class L437 {

    public static void main(String[] args) {
        Solution p = new Solution();
//        Integer[] tree = {10,5,-3,3,2,null,11,3,-2,null,1};
//        Integer[] tree = {5,4,8,11,null,13,4,7,2,null,null,5,1};
        Integer[] tree = {1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000};
//        Integer[] tree = {1,2};
        TreeNode root = TreeNode.createByIntArray(tree);
        System.out.println(p.pathSum(root, 0));
//        System.out.println(p.count);
    }

    static class Solution {
        int ans = 0;
        public int pathSum(TreeNode root, int targetSum) {
            if (root == null) return 0;
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                TreeNode n = q.poll();
                dfs(n, targetSum);
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }
            return ans;
        }

        private void dfs(TreeNode root, long target) {
            if (root == null) {
                return;
            }
            target -= root.val;
            if (target == 0) {
                ans++;
            }
            dfs(root.left, target);
            dfs(root.right, target);
        }
    }
}
