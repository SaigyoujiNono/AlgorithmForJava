package com.mqd.leetcode.medium;

import com.mqd.struct.ListNode;
import com.mqd.struct.TreeNode;


/**
 * leetcode 1367 二叉树中的列表
 * 给你一棵以root为根的二叉树和一个head为第一个节点的链表。
 *
 * 如果在二叉树中，存在一条一直向下的路径，且每个点的数值恰好一一对应以head为首的链表中每个节点的值，那么请你返回 True ，否则返回 False 。
 *
 * 一直向下的路径的意思是：从树中某个节点开始，一直连续向下的路径。
 */
public class L1367 {

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        return isSubPath(head, root) || process(head, root.left) || process(head, root.right);
    }

    private boolean process(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;
        if (head.val == root.val) return process(head.next, root.left) || process(head.next, root.right);
        else return false;
    }
}
