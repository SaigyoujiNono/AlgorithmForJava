package com.mqd.leetcode.medium;

import com.mqd.struct.TreeNode;

/**
 * leetcode 988. 从叶结点开始的最小字符串
 * 给定一颗根结点为root的二叉树，树中的每一个结点都有一个[0, 25]范围内的值，分别代表字母'a' 到'z'。
 *
 * 返回 按字典序最小 的字符串，该字符串从这棵树的一个叶结点开始，到根结点结束。
 *
 * 注：字符串中任何较短的前缀在 字典序上 都是 较小 的：
 *
 * 例如，在字典序上"ab" 比"aba"要小。叶结点是指没有子结点的结点。
 * 节点的叶节点是没有子节点的节点。
 *
 */
public class L988 {
    public static void main(String[] args) {
        Solution p = new Solution();
        TreeNode r = new TreeNode(0);
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(3);
        TreeNode r6 = new TreeNode(4);
        r.left = r1;
        r.right = r2;
        r1.left = r3;
        r1.right = r4;
        r2.left = r5;
        r2.right = r6;
        System.out.println(p.smallestFromLeaf(r));
//        System.out.println(p.compare("dba", "eba"));
//        System.out.println((char) 1 + 97);
    }

    static class Solution {
        private String value;
        public String smallestFromLeaf(TreeNode root) {
            this.value = "";
            dfs(root, new StringBuilder());
            return this.value;
        }

        public void dfs(TreeNode node, StringBuilder str) {
            if (node == null) return;
            str.insert(0, (char) (node.val + 97));
            if (node.left == null && node.right == null) {
                int compare = compare(value, str.toString());
                if (compare < 0 || this.value.equals("")) {
                    this.value = str.toString();
                }
            }
            dfs(node.left, str);
            dfs(node.right, str);
            str.deleteCharAt(0);
        }
        
        public int compare(String str1, String str2) {
            int maxL = Math.max(str1.length(), str2.length());
            byte[] b1 = str1.getBytes();
            byte[] b2 = str2.getBytes();
            for (int i = 0; i < maxL; i++) {
                if (i < b1.length && i < b2.length) {
                    if (b1[i] > b2[i]) {
                        return -1;
                    } else if (b1[i] < b2[i]) {
                        return 1;
                    }
                } else if (i < b1.length) {
                    return -1;
                } else if (i < b2.length) {
                    return 1;
                }
            }
            return 0;
        }
    }
}
