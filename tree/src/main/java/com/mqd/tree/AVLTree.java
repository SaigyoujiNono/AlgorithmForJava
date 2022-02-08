package com.mqd.tree;


import java.util.Arrays;
import java.util.List;

/**
 * AVL树的实现
 */
public class AVLTree<T extends Comparable<T>> {

    public static void main(String[] args) {
        test2();


    }

    private static void test2() {
        AVLTree<Integer> avlTree = new AVLTree<>();
        List<Integer> integers = Arrays.asList(50, 40, 30, 60, 70, 55);
        integers.forEach(avlTree::add);
        avlTree.preTraversal();
        System.out.println("--------------");
        avlTree.midTraversal();
    }

    private static void test1() {
        AVLTree<Integer> a2 = new AVLTree<>();
        a2.add(6);
        a2.add(7);
        a2.add(8);
        a2.preTraversal();
        System.out.println("--------------");
        a2.midTraversal();
    }

    private TreeNode<T> root;


    /**
     * 添加一个新的节点
     *
     * @param value 值
     */
    public void add(T value) {
        add(value, this.root);
    }

    /**
     * 添加一个新的节点
     *
     * @param value 节点
     * @param t     当前节点
     */
    public TreeNode<T> add(T value, TreeNode<T> t) {
        //如果当前根节点为空则直接添加到根节点
        if (this.root == null) {
            this.root = new TreeNode<>(value);
            return this.root;
        }
        //如果遍历到当前节点t为空时
        if (t == null) {
            return new TreeNode<>(value);
        } else {
            //不为空则继续比较
            //如果value大于当前节点则向右继续递归
            if (value.compareTo(t.value) > 0) {
                t.right = add(value, t.right);
            } else if (value.compareTo(t.value) < 0) {
                //如果value小于当前节点则向左继续递归
                t.left = add(value, t.left);
            } else {
                //如果相同则抛出异常
                throw new RuntimeException("相同value!");
            }
        }
        //添加完成后对当前节点进行平衡
        TreeNode<T> balance = balance(t);
        if (t == root) {
            root = balance;
        }
        return balance;
    }

    public TreeNode<T> remove(T value, TreeNode<T> t) {
        if (t == null) throw new NullPointerException();
        if (value.compareTo(t.value) == 0) {
            TreeNode<T> parent = root;
            if (t != root) parent = getParent(t);
            //当确认时进入此区域
            if (t.left == null && t.right == null) {
                if (t == root) root = null;
                if (parent.left == t) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            } else if (t.left == null) {
                if (t == root) root = t.right;
                if (parent.left == t) {
                    parent.left = t.right;
                } else {
                    parent.right = t.right;
                }
            } else if (t.right == null) {
                if (t == root) root = t.left;
                if (parent.left == t) {
                    parent.left = t.left;
                } else {
                    parent.right = t.left;
                }
            } else {
                //两个子树都存在的情况下
                TreeNode<T> inherited = findInherited(t.left);
                if (t == root) {
                    if (inherited != null) {
                        inherited.left = t.left;
                        inherited.right = t.right;
                    } else {
                        inherited = t.left;
                        t.left = t.left.left;
                        inherited.left = t.left;
                        inherited.right = t.right;
                    }
                    root = inherited;
                } else {
                    if (inherited != null) {
                        inherited.left = t.left;
                        inherited.right = t.right;
                    } else {
                        inherited = parent.right;
                        parent.right = inherited.right;
                        inherited.left = t.left;
                        inherited.right = t.right;
                    }
                    if (parent.left == t) {
                        parent.left = inherited;
                    } else {
                        parent.right = inherited;
                    }
                }
            }

        } else if (value.compareTo(t.value) > 0) {
            t.right = remove(value, t.right);
        } else {
            t.left = remove(value, t.left);
        }
        TreeNode<T> balance = balance(t);
        if (t == root) {
            root = balance;
        }
        return balance;
    }

    /**
     * 查找继任者
     *
     * @param tar 从该节点开始查找
     * @return 返回继任者节点
     */
    private TreeNode<T> findInherited(TreeNode<T> tar) {
        //传入左子树，查找最右叶子节点，如果没有返回null
        if (tar.right == null) return null;
        TreeNode<T> parent = tar;
        TreeNode<T> temp = tar.right;
        while (temp.right != null) {
            parent = temp;
            temp = temp.right;
        }
        parent.right = null;
        return temp;
    }


    /**
     * 对当前节点进行旋转平衡
     *
     * @param t 当前节点
     * @return 经过平衡后的根节点
     */
    public TreeNode<T> balance(TreeNode<T> t) {
        int lh = getHeight(t.left), rh = getHeight(t.right);

        if (Math.abs(lh - rh) > 1) {
            if (getHeight(t.left) > getHeight(t.right)) {
                if (getHeight(t.left.left) > getHeight(t.left.right)) {
                    return LLBalance(t);
                } else {
                    return LRBalance(t);
                }
            } else {
                if (getHeight(t.right.left) > getHeight(t.right.right)) {
                    return RLBalance(t);
                } else {
                    return RRBalance(t);
                }
            }
        }
        return t;
    }

    /**
     * 当前节点的右侧的左侧较深，先右旋再左旋
     *
     * @param t 当前节点
     */
    private TreeNode<T> RLBalance(TreeNode<T> t) {
        t.right = LLBalance(t.right);
        return RRBalance(t);
    }

    /**
     * 当前节点的左侧的右侧较深，先左旋再右旋
     *
     * @param t 当前节点
     */
    private TreeNode<T> LRBalance(TreeNode<T> t) {
        t.left = RRBalance(t.left);
        return LLBalance(t);
    }

    /**
     * 当前节点的左侧的左侧较深，进行一次右旋
     *
     * @param t 当前节点
     */
    private TreeNode<T> LLBalance(TreeNode<T> t) {
        TreeNode<T> newNode = t.left;
        t.left = newNode.right;
        newNode.right = t;
        return newNode;
    }

    /**
     * 当前节点的右侧的右侧较深，进行一次左旋
     *
     * @param t 当前节点
     */
    public TreeNode<T> RRBalance(TreeNode<T> t) {
        TreeNode<T> newNode = t.right;
        t.right = newNode.left;
        newNode.left = t;
        return newNode;
    }

    /**
     * 从根节点开始的前序遍历
     */
    public void preTraversal() {
        preTraversal(this.root);
    }

    /**
     * 从根节点开始的中序遍历
     */
    public void midTraversal() {
        midTraversal(this.root);
    }

    /**
     * 从根节点开始的后序遍历
     */
    public void postTraversal() {
        postTraversal(this.root);
    }

    /**
     * 从某个节点开始前序遍历
     *
     * @param tn 开始遍历的根节点
     */
    public void preTraversal(TreeNode<T> tn) {
        if (tn == null) return;
        System.out.println(tn.value);
        preTraversal(tn.left);
        preTraversal(tn.right);
    }

    /**
     * 从当前节点开始中序遍历
     *
     * @param tn 当前节点
     */
    public void midTraversal(TreeNode<T> tn) {
        if (tn == null) return;
        midTraversal(tn.left);
        System.out.println(tn.value);
        midTraversal(tn.right);
    }

    /**
     * 从当前节点开始的后序遍历
     *
     * @param tn 当前节点
     */
    public void postTraversal(TreeNode<T> tn) {
        if (tn == null) return;
        postTraversal(tn.left);
        postTraversal(tn.right);
        System.out.println(tn.value);
    }


    /**
     * 获取某个节点的高度
     *
     * @param tn 某个节点
     * @return 返回当前当前节点的高度
     */
    public int getHeight(TreeNode<T> tn) {
        if (tn == null) return 0;
        return Math.max(tn.left == null ? 0 : getHeight(tn.left), tn.right == null ? 0 : getHeight(tn.right)) + 1;
    }

    /**
     * 获取根节点的高度
     *
     * @return 根节点的高度
     */
    public int getHeight() {
        return getHeight(root);
    }


    /**
     * 获取当前节点的父节点
     *
     * @param tn 当前节点
     * @return 当前节点的父节点
     */
    public TreeNode<T> getParent(TreeNode<T> tn) {
        if (tn == null) return null;
        return getParent(root, tn);
    }

    /**
     * 获取该节点的父节点
     *
     * @param root 根节点
     * @param tn   需要查找的节点
     * @return 该节点的父节点
     */
    private TreeNode<T> getParent(TreeNode<T> root, TreeNode<T> tn) {
        if (root == null) return null;
        if (root.left == tn || root.right == tn) {
            return root;
        }
        if (tn.value.compareTo(root.value) > 0) {
            return getParent(root.right, tn);
        } else {
            return getParent(root.left, tn);
        }
    }


    static class TreeNode<T> {
        private final T value;
        private TreeNode<T> left, right;

        public TreeNode(T value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}
