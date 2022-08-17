package com.mqd.leetcode.medium;

import com.mqd.struct.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * leetcode 1302. 层数最深叶子节点的和
 * 给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。
 */
public class L1302 {
    static class Solution {
        public int deepestLeavesSum(TreeNode root) {
            if (root.left == null && root.right == null) return root.val;
            Deque<TreeNode> dq = new LinkedList<>();
            dq.addLast(root);
            int ans = 0;
            while(!dq.isEmpty()) {
                ans = 0;
                TreeNode t = dq.pollFirst();
                ans += t.val;
                int size = dq.size();
                if (t.left != null) dq.addLast(t.left);
                if (t.right != null) dq.addLast(t.right);
                while(size-- > 0) {
                    TreeNode n = dq.pollFirst();
                    assert n != null;
                    ans += n.val;
                    if (n.left != null) dq.addLast(n.left);
                    if (n.right != null) dq.addLast(n.right);
                }
            }
            return ans;
        }
    }
}
