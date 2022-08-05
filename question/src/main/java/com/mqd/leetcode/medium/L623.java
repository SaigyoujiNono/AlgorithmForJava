package com.mqd.leetcode.medium;

import com.mqd.struct.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * leetcode 623. 在二叉树中增加一行
 * 给定一个二叉树的根root和两个整数 val 和depth，在给定的深度depth处添加一个值为 val 的节点行。
 *
 * 注意，根节点root位于深度1。
 *
 * 加法规则如下:
 *
 * 给定整数depth，对于深度为depth - 1 的每个非空树节点 cur ，创建两个值为 val 的树节点作为 cur 的左子树根和右子树根。
 * cur 原来的左子树应该是新的左子树根的左子树。
 * cur 原来的右子树应该是新的右子树根的右子树。
 * 如果 depth == 1 意味着depth - 1根本没有深度，那么创建一个树节点，值 val 作为整个原始树的新根，而原始树就是新根的左子树。
 */
public class L623 {

    public static void main(String[] args) {
        TreeNode byIntArray = TreeNode.createByIntArray(new Integer[]{4, 2, 6, 3, 1, 5});
        Solution p = new Solution();
        System.out.println(p.addOneRow(byIntArray, 1, 3));
    }

    static class Solution {
        public TreeNode addOneRow(TreeNode root, int val, int depth) {
            if (depth == 1) {
                TreeNode r = new TreeNode(val);
                r.left = root;
                return r;
            }
            Deque<TreeNode> dq = new LinkedList<>();
            dq.addLast(root);
            int lay = 0;
            while (!dq.isEmpty()) {
                TreeNode n = dq.pollFirst();
                int size = dq.size();
                lay++;
                extracted(val, depth, lay, n);

                if (n.left != null) dq.addLast(n.left);
                if (n.right != null) dq.addLast(n.right);
                while (size-- > 0 && !dq.isEmpty()) {
                    TreeNode t = dq.pollFirst();
                    extracted(val, depth, lay, t);
                    if (t.left != null) dq.addLast(t.left);
                    if (t.right != null) dq.addLast(t.right);
                }
                if (lay == depth -1) break;
            }
            return root;
        }

        private void extracted(int val, int depth, int lay, TreeNode n) {
            if (lay == depth -1) {
                TreeNode lNode = n.left;
                TreeNode rNode = n.right;
                n.left = new TreeNode(val);
                n.right = new TreeNode(val);
                n.left.left = lNode;
                n.right.right = rNode;
            }
        }
    }
}
