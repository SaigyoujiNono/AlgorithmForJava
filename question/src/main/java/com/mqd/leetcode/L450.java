package com.mqd.leetcode;

import com.mqd.struct.TreeNode;

/**
 * leetcode 450 删除二叉搜索树中的节点
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 *
 * 一般来说，删除节点可分为两个步骤：
 *
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 *
 * 来源：力扣（LeetCode）
 * @link https://leetcode.cn/problems/delete-node-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L450 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode rootL = new TreeNode(3);
        TreeNode rootR = new TreeNode(6);
        root.left = rootL;
        root.right =rootR;

        TreeNode rootLL = new TreeNode(2);
        TreeNode rootLR = new TreeNode(4);
        rootL.left = rootLL;
        rootL.right = rootLR;
        rootR.right = new TreeNode(7);
        L450 l450 = new L450();
        TreeNode d = l450.deleteNode(root, 3);
    }

    private TreeNode head = null;

    public TreeNode deleteNode(TreeNode root, int key) {
        if (this.head == null) {
            this.head = root;
        }
        TreeNode parent = null;
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val == key) {
                if (cur.left == null && cur.right == null) {
                    if (parent == null) {
                        return null;
                    }
                    if (parent.left == cur) {
                        parent.left = null;
                    }
                    if (parent.right == cur) {
                        parent.right = null;
                    }
                }
                else if (cur.left == null) {
                    // 左子节点为空
                    if (parent == null) {
                        return cur.right;
                    }
                    if (parent.left == cur) {
                        parent.left = cur.right;
                    }
                    if (parent.right == cur) {
                        parent.right = cur.right;
                    }
                }
                else if (cur.right == null) {
                    // 右子节点为空
                    if (parent == null) {
                        return cur.left;
                    }
                    if (parent.left == cur) {
                        parent.left = cur.left;
                    }
                    if (parent.right == cur) {
                        parent.right = cur.left;
                    }
                }
                else {
                    TreeNode k = cur.left;
                    while (k.right != null) {
                        k = k.right;
                    }
                    if (parent == null) {
                        deleteNode(root, k.val);
                        k.left = cur.left;
                        k.right = cur.right;
                        this.head = k;
                    } else {
                        deleteNode(root, k.val);
                        k.left = cur.left;
                        k.right = cur.right;
                        if (parent.left == cur) {
                            parent.left = k;
                        } else {
                            parent.right = k;
                        }
                    }
                }
                break;
            }
            else if (cur.val > key) {
                parent = cur;
                cur = cur.left;
            }
            else {
                parent = cur;
                cur = cur.right;
            }
        }
        return this.head;
    }
}
