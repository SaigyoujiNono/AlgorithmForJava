package com.mqd.tree;


import java.util.*;

/**
 * 二叉树
 * @param <T>
 */
public class BinaryTree <T extends Comparable<T>> {
    //根节点
    private Node<T> root = null;


    public static void main(String[] args) {
        BinaryTree<Integer> bt = new BinaryTree<>();
        bt.add(10);
        bt.add(7);
        bt.add(15);
        bt.add(4);
        bt.add(9);
        Integer in1 = 13;
        bt.add(in1);
        bt.add(19);
        bt.add(2);
        bt.add(5);
        bt.add(8);
        bt.add(11);
        Integer in2 = 18;
        bt.add(in2);
        bt.add(20);
        bt.add(17);
        bt.preEach();
        System.out.println("最大宽度为: "+bt.getTreeMaxWidth());
        System.out.println("最大宽度为: "+bt.getTreeMaxWidth2());
        System.out.println("二叉搜索树: "+bt.isBst());
        System.out.println("完全二叉树: "+bt.isCBT());
        System.out.println("二叉树高度: "+bt.getTreeDepth());
        System.out.println("二叉树节点: "+bt.get(5).value);
        Node<Integer> n1 = new Node<>(17);
        Node<Integer> n2 = new Node<>(15);

        System.out.println("求二叉树两个节点的公共父节点: "+bt.getLowestCommonAncestor(n1,n2).value);
        System.out.println("求二叉树两个节点的公共父节点2: "+bt.getLowestCommonAncestor2(n1,n2).value);
    }


    /**
     * 给定两个节点，求出它们的最低公共祖先节点
     * @param n1    节点1
     * @param n2    节点2
     * @return  返回最低公共祖先节点
     */
    public Node<T> getLowestCommonAncestor(Node<T> n1, Node<T> n2){
        if (get(n1.value)==null || get(n2.value)==null){
            return null;
        }
        List<Node<T>> list1 = new ArrayList<>();
        List<Node<T>> list2 = new ArrayList<>();

        List<Node<T>> nodes = new ArrayList<>();
        nodes.add(n1);
        nodes.add(n2);

        for (int i = 0; i < nodes.size(); i++) {
            Node<T> cur = root;
            while (true){
                if (i==0){
                    list1.add(cur);
                }else {
                    list2.add(cur);
                }
                //该节点的左子树等于n1则加入list1
                if (cur.left.value.compareTo(nodes.get(i).value)==0){
                    if (i==0){
                        list1.add(cur.left);
                    }else {
                        list2.add(cur.left);
                    }
                    break;
                    //该节点的右子树等于n1则加入list1
                }else if (cur.right.value.compareTo(nodes.get(i).value)==0){
                    if (i==0){
                        list1.add(cur.right);
                    }else {
                        list2.add(cur.right);
                    }
                    break;
                    //该节点本身等于n1的话则加入list1
                }else if (cur.value.compareTo(nodes.get(i).value)==0){
                    break;
                }else if (cur.value.compareTo(nodes.get(i).value)>0){
                    cur = cur.left;
                }else {
                    cur = cur.right;
                }
            }
        }
        //从最后一个开始遍历比对
        for (int i = list1.size()-1; i >=0 ; i--) {
            for (Node<T> node : list2) {
                if (node==list1.get(i)) {
                    return node;
                }
            }
        }
        return null;
    }

    /**
     * 给定两个节点，求出它们的最低公共祖先节点 2.0版本
     * @param n1    节点1
     * @param n2    节点2
     * @return  返回最低公共祖先节点
     */
    public Node<T> getLowestCommonAncestor2(Node<T> n1, Node<T> n2) {
        if (get(n1.value) == null || get(n2.value) == null) {
            return null;
        }
        if (n1.value == n2.value){
            return get(n1.value);
        }

        Node<T> cur1 = root;
        Node<T> cur2 = root;
        Node<T> temp = root;
        while (true){
            if (cur1.value.compareTo(n1.value)>0){
                temp = cur1;
                cur1 = cur1.left;
            }else if (cur1.value.compareTo(n1.value)<0){
                temp = cur1;
                cur1 = cur1.right;
            }else {
                temp = cur1;
                break;
            }

            if (cur2.value.compareTo(n2.value)>0){
                cur2 = cur2.left;
            }else if(cur2.value.compareTo(n2.value)<0){
                cur2 = cur2.right;
            }else{
                break;
            }
            if (cur1!=cur2){
                break;
            }
        }
        return temp;
    }

    /**
     * 返回二叉树深度
     * @return  树的深度
     */
    public int getTreeDepth(){
        return root.getHeight();
    }

    /**
     * 判断是否是完全二叉树
     * @return  如果是返回true
     */
    public boolean isCBT(){
        if (root==null){
            return true;
        }
        Node<T> cur = root;
        Queue<Node<T>> queue = new LinkedList<>();

        //是否右遇到左右两个孩子不双全的节点
        boolean leaf = false;
        Node<T> l = null;
        Node<T> r = null;
        queue.add(cur);
        while (!queue.isEmpty()) {
            cur = queue.poll();
            l = cur.left;
            r = cur.right;
            if (
                    (leaf && (l!=null || r!=null))
                    || (l==null && r!=null)
            ){
                return false;
            }
            if (l!=null){
                queue.add(l);
            }
            if (r!=null){
                queue.add(r);
            }
            if (l == null || r == null){
                leaf = true;
            }
        }
        return false;
    }


    public boolean isBst(){
        return isBst(root);
    }

    private T preValue;
    /**
     * 判断是否是二叉搜索树
     * @param cur   传入一个节点
     * @return  返回该节点及其子树是否是搜索二叉树
     */
    private boolean isBst(Node<T> cur){
        if (cur == null){
            return true;
        }
        boolean isLeftBst = isBst(cur.left);
        if (!isLeftBst){
            return false;
        }
        if (preValue==null){
            preValue = cur.value;
        }else if (cur.value.compareTo(preValue)<=0){
            return false;
        }else{
            preValue = cur.value;
        }
        return isBst(cur.right);
    }

    /**
     * 根据值获取节点
     * @param target    目标值
     * @return  返回node节点
     */
    public Node<T> get(T target){
        if (root==null){
            return null;
        }
        Node<T> cur = root;
        while(true){
            //如果val比value小则往左深入
            if (cur.value.compareTo(target)>0){
                if (cur.left!=null){
                    cur = cur.left;
                }else{
                    return null;
                }
                //如果值相等则直接返回
            }else if (cur.value.compareTo(target)==0){
                return cur;
                //如果val比value大则往右深入
            }else{
                if (cur.right!=null){
                    cur = cur.right;
                }else{
                    return null;
                }
            }
        }
    }

    /**
     * 添加一个节点
     * @param val   节点value
     */
    public void add(T val){
        if (root==null){
            root = new Node<T>(val);
            return;
        }
        Node<T> cur = root;
        while(true){
            //如果val比value小则往左深入
            if (cur.value.compareTo(val)>0){
                if (cur.left!=null){
                    cur = cur.left;
                }else{
                    cur.left = new Node<T>(val);
                    return;
                }
            //如果值相等则直接返回
            }else if (cur.value.compareTo(val)==0){
                System.out.println("值相等！val: "+val);
                return;
            //如果val比value大则往右深入
            }else{
                if (cur.right!=null){
                    cur = cur.right;
                }else{
                    cur.right = new Node<T>(val);
                    return;
                }
            }
        }
    }

    /**
     * 前序遍历
     */
    public void preEach(){
        if (root==null){
            System.out.println("树为空");
        }else {
            root.preEach();
        }
    }

    /**
     * 中序遍历
     */
    public void midEach(){
        if (root==null){
            System.out.println("树为空");
        }else {
            root.midEach();
        }
    }

    /**
     * 后序遍历
     */
    public void posEach(){
        if (root==null){
            System.out.println("树为空");
        }else {
            root.posEach();
        }
    }

    /**
     * 获取二叉树最大宽度
     * 使用hashMap
     * @return  返回二叉树最大宽度(不一定是最底曾)
     */
    public int getTreeMaxWidth(){
        if (root==null){
            return 0;
        }
        Node<T> head = root;
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(head);
        Map<Node<T>,Integer> levelMap = new HashMap<>();
        //先将头节点放入map，设定层数为1
        levelMap.put(head,1);
        //当前层数
        int curLevel = 1;

        //当前层数统计到的节点个数
        int curLevelNodes = 0;

        //设定最大值
        int max = Integer.MIN_VALUE;

        while(!queue.isEmpty()){
            //节点游标
            Node<T> cur = queue.poll();
            //获取当前节点的层数
            Integer curNodeLevel = levelMap.get(cur);

            //如果当前节点的层数等于当前层数，则当前层数的node数量+1
            if (curNodeLevel == curLevel){
                curLevelNodes++;
            }else{
                //获取最大的node数量
                max = Math.max(max,curLevelNodes);
                curLevel++;
                curLevelNodes = 1;
            }

            if (cur.left!=null){
                levelMap.put(cur.left,curNodeLevel+1);
                queue.add(cur.left);
            }
            if (cur.right!=null){
                levelMap.put(cur.right,curNodeLevel+1);
                queue.add(cur.right);
            }
        }
        return Math.max(max,curLevelNodes);
    }

    /**
     * 获取二叉树最大宽度
     * 只使用一个队列
     * @return  返回二叉树最大宽度(不一定是最底曾)
     */
    public int getTreeMaxWidth2(){
        if (root==null){
            return 0;
        }
        Node<T> head = root;
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(head);
        //当前层尾节点
        Node<T> curEnd = head;
        //下一层尾节点
        Node<T> nextEnd = null;
        //当前层发现的节点数
        int curLevel=0;
        //最大节点数
        int max = 0;
        while (!queue.isEmpty()){
            Node<T> cur = queue.poll();
            curLevel++;
            if (cur==curEnd){
                max = Math.max(max, curLevel);
            }
            //谁最后进队，则下一层尾节点指向谁
            if (cur.left!=null){
                queue.add(cur.left);
                nextEnd = cur.left;
            }
            if (cur.right!=null){
                queue.add(cur.right);
                nextEnd = cur.right;
            }
            if (cur==curEnd){
                curEnd = nextEnd;
                nextEnd = null;
                curLevel = 0;
            }
        }
        return max;
    }


    /**
     * 二叉树节点
     * @param <T>
     */
    private static class Node<T>{
        private T value;
        private Node<T> left;
        private Node<T> right;

        public Node(T value) {
            this.value = value;
        }

        public Node() {
        }

        /**
         * 获取当前节点高度
         * @return  返回高度，从1开始
         */
        public int getHeight(){
            return Math.max(left==null ? 0: left.getHeight(), right == null ? 0: right.getHeight())+1;
        }

        /**
         * 前序遍历
         */
        public void preEach(){
            System.out.println(this.value);
            if (this.left!=null){
                this.left.preEach();
            }
            if (this.right!=null){
                this.right.preEach();
            }
        }

        /**
         * 中序遍历
         */
        public void midEach(){
            if (this.left!=null){
                this.left.midEach();
            }
            System.out.println(this.value);
            if (this.right!=null){
                this.right.midEach();
            }
        }

        /**
         * 后序遍历
         */
        public void posEach(){
            if (this.left!=null){
                this.left.posEach();
            }
            if (this.right!=null){
                this.right.posEach();
            }
            System.out.println(this.value);
        }
    }
}
