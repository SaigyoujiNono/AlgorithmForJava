package com.mqd.leetcode.medium;

import com.mqd.struct.TreeNode;
import com.mqd.utils.TimeStatistic;

import java.util.*;

/**
 * leetcode 508 出现次数最多的子树元素和
 * 给你一个二叉树的根结点 root ，请返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
 *
 * 一个结点的 「子树元素和」 定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 */
public class L508 {

    public static void main(String[] args) {
        L508 p = new L508();
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(-3);
        TimeStatistic.func(() -> System.out.println(Arrays.toString(p.findFrequentTreeSum(treeNode))));
    }


    private final Map<Integer, Integer> map = new HashMap<>();
    private int maxCount = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        process(root);
        map.forEach((k, v) -> {
            if (v == maxCount) {
                res.add(k);
            }
        });
        int[] resArr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }

    public int process(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) {
            Integer subVal = map.get(root.val);
            int count = subVal == null ? 1 : subVal + 1;
            maxCount = Math.max(maxCount, count);
            map.put(root.val, count);
            return root.val;
        }
        int nVal = process(root.left) + process(root.right) + root.val;
        Integer subVal = map.get(nVal);
        int count = subVal == null ? 1 : subVal + 1;
        maxCount = Math.max(maxCount, count);
        map.put(nVal, count);
        return nVal;
    }
}
