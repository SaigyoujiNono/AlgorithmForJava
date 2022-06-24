package com.mqd.leetcode.medium;

import com.mqd.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 515 在每个树行中找最大值
 * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 */
public class L515 {
    List<Integer> res = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        process(root, 0);
        return res;
    }

    private void process(TreeNode root, int storey) {
        if (root == null) return;
        if (res.size() == storey) {
            res.add(root.val);
        } else {
            Integer integer = res.get(storey);
            res.set(storey, Math.max(integer, root.val));
        }

        process(root.left, storey + 1);
        process(root.right, storey + 1);
    }
}
