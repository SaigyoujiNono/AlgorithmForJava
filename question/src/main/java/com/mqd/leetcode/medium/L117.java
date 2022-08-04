package com.mqd.leetcode.medium;

import java.util.Deque;
import java.util.LinkedList;

/**
 * leetcode 117. 填充每个节点的下一个右侧节点指针 II
 * 给定一个二叉树
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有next 指针都被设置为 NULL。
 */
public class L117 {


    static class Solution {
        public Node connect(Node root) {
            if (root == null) return null;
            Deque<Node> dq = new LinkedList<>();
            dq.addLast(root);
            while (!dq.isEmpty()) {
                Node node = dq.pollFirst();
                int size = dq.size();
                if (node.left != null) dq.addLast(node.left);
                if (node.right != null) dq.addLast(node.right);
                while (size > 0 && !dq.isEmpty()) {
                    Node temp = dq.pollFirst();
                    node.next = temp;
                    node = node.next;
                    if (temp.left != null) dq.addLast(temp.left);
                    if (temp.right != null) dq.addLast(temp.right);
                    size--;
                }
            }
            return root;
        }
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
