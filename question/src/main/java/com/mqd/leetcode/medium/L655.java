package com.mqd.leetcode.medium;

import com.mqd.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 655. 输出二叉树
 * 给你一棵二叉树的根节点 root ，请你构造一个下标从 0 开始、大小为 m x n 的字符串矩阵 res ，
 * 用以表示树的 格式化布局 。构造此格式化布局矩阵需要遵循以下规则：
 *
 * 树的 高度 为 height ，矩阵的行数 m 应该等于 height + 1 。
 * 矩阵的列数 n 应该等于 2height+1 - 1 。
 * 根节点 需要放置在 顶行 的 正中间 ，对应位置为 res[0][(n-1)/2] 。
 * 对于放置在矩阵中的每个节点，设对应位置为 res[r][c] ，
 * 将其左子节点放置在 res[r+1][c-2height-r-1] ，右子节点放置在 res[r+1][c+2height-r-1] 。
 * 继续这一过程，直到树中的所有节点都妥善放置。
 * 任意空单元格都应该包含空字符串 "" 。
 * 返回构造得到的矩阵 res 。
 */
public class L655 {

    public static void main(String[] args) {
        Solution p = new Solution();
        Integer[] treeArr = {1,2,3,null,4};
        TreeNode t = TreeNode.createByIntArray(treeArr);
        System.out.println(p.printTree(t));
    }

    static class Solution {
        List<List<String>> ans = new ArrayList<>();
        public List<List<String>> printTree(TreeNode root) {
            int height = getHeight(root);
            int len = (int) Math.pow(2, height) - 1;
            for (int i = 0; i < height; i++) {
                List<String> list = new ArrayList<>(len);
                for (int j = 0; j < len; j++) {
                    list.add("");
                }
                ans.add(list);
            }
            dfs(root, 0, len - 1, 0);
            return ans;
        }

        private void dfs(TreeNode root, int l, int r, int lay) {
            if (root == null) {
                return;
            }
            int mid = (l + r) / 2;
            ans.get(lay).set(mid, root.val + "");
            dfs(root.left, l, mid - 1, lay + 1);
            dfs(root.right, mid + 1, r, lay + 1);
        }

        private int getHeight(TreeNode r) {
            if (r == null) return 0;
            return Math.max(r.left != null ? getHeight(r.left) : 0,
                    r.right != null ? getHeight(r.right) : 0) + 1;
        }
    }
}
