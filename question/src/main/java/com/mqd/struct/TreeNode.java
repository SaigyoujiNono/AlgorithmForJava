package com.mqd.struct;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
//        Integer[] nums = {0, 1, 2, 3, 4, 3, 4};
        Integer[] nums = {1, null, 2, 3, 4, null, 5, null, 6};
        TreeNode byIntArray = createByIntArray(nums);
        System.out.println(byIntArray.val);
    }

    public static TreeNode createByIntArray(Integer[] nums) {
        if (nums == null || nums.length == 0 || nums[0] == null) return null;
        Deque<Integer> q = new LinkedList<>(Arrays.asList(nums));
        Deque<TreeNode> nq = new LinkedList<>();
        Integer integer = q.pollFirst();
        assert integer != null;
        TreeNode root = new TreeNode(integer);
        nq.addLast(root);
        while (!q.isEmpty()) {
            Integer head = q.pollFirst();
            // 左子节点
            TreeNode node = nq.pollFirst();
            assert node != null;
            if (head == null) {
                node.left = null;
            } else {
                node.left = new TreeNode(head);
            }
            // 右子节点
            if (q.isEmpty()) {
                break;
            }
            head = q.pollFirst();
            if (head == null) {
                node.right = null;
            } else {
                node.right = new TreeNode(head);
            }
            if (node.left != null) nq.addLast(node.left);
            if (node.right != null) nq.addLast(node.right);
        }
        return root;
    }
 }