package com.mqd.leetcode.medium;

import com.mqd.struct.TreeNode;

import java.util.*;

/**
 * leetcode 919. 完全二叉树插入器
 * 完全二叉树 是每一层（除最后一层外）都是完全填充（即，节点数达到最大）的，并且所有的节点都尽可能地集中在左侧。
 *
 * 设计一种算法，将一个新节点插入到一个完整的二叉树中，并在插入后保持其完整。
 *
 * 实现 CBTInserter 类:
 *
 * CBTInserter(TreeNode root)使用头节点为root的给定树初始化该数据结构；
 * CBTInserter.insert(int v) 向树中插入一个值为Node.val == val的新节点TreeNode。使树保持完全二叉树的状态，并返回插入节点TreeNode的父节点的值；
 * CBTInserter.get_root() 将返回树的头节点。
 */
public class L919 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode rl = new TreeNode(2);
        TreeNode rr = new TreeNode(3);
        root.left = rl;
        root.right = rr;
        TreeNode rll = new TreeNode(4);
        TreeNode rlr = new TreeNode(5);
        rl.left = rll;
        rl.right = rlr;
        rr.left = new TreeNode(6);
        CBTInserter cbt = new CBTInserter(root);
        System.out.println(cbt.insert(7));
        System.out.println(cbt.insert(8));
    }

    static class CBTInserter {
        private final TreeNode root;
        private final List<TreeNode> nodeList;

        public CBTInserter(TreeNode root) {
            this.root = root;
            this.nodeList = new ArrayList<>();
            Deque<TreeNode> q = new LinkedList<>();
            if (root != null) {
                q.addLast(root);
            }
            while (!q.isEmpty()) {
                TreeNode pop = q.pollFirst();
                nodeList.add(pop);
                if (pop.left != null) q.addLast(pop.left);
                if (pop.right != null) q.addLast(pop.right);
            }
        }

        public int insert(int val) {
            TreeNode node = new TreeNode(val);
            nodeList.add(node);
            if ((nodeList.size() - 1) % 2 == 0) {
                TreeNode parent = nodeList.get((nodeList.size() - 1 - 2) / 2);
                parent.right = node;
                return parent.val;
            }
            TreeNode parent = nodeList.get((nodeList.size() - 1 - 1) / 2);
            parent.left = node;
            return parent.val;
        }

        public TreeNode get_root() {
            return this.root;
        }
    }
}
