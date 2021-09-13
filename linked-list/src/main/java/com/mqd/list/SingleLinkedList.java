package com.mqd.list;


/**
 * 简单单链表
 * @param <T>
 */
public class SingleLinkedList<T extends Comparable<T>>{

    //头节点
    private Node<T> head = null;

    public static void main(String[] args) {
        SingleLinkedList<Integer> list = new SingleLinkedList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(8);
        list.showAll();
    }

    /**
     * 添加一个节点
     * @param value 值
     */
    public void  add(T value){
        //当为空时，直接插入当前头节点
        if (isEmpty()) {
            head = new Node<T>(value);
            return;
        }
        Node<T> temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = new Node<>(value);
    }

    /**
     * 根据下表移除一个元素
     * @param index 下标，从0开始
     */
    public void remove(int index){
        if (index == 0){
            head = head.next == null ? null : head.next;
            return;
        }
        Node<T> cur = head;
        for (int i = 0; i < index-1; i++) {
            if (cur.next==null){
                throw new IndexOutOfBoundsException("不存在这个下标: "+index);
            }
            cur = cur.next;
        }

        if (cur.next==null){
            throw new IndexOutOfBoundsException("不存在这个下标: "+index);
        }
        cur.next = cur.next.next;
    }

    /**
     * 判断当前链表是否为空
     * @return  true为空
     */
    public boolean isEmpty(){
        return head==null;
    }

    /**
     * 遍历当前链表
     */
    public void showAll(){
        if (isEmpty()) {
            System.out.println("当前链表为空...");
            return;
        }
        Node<T> temp = head;
        do{
            System.out.println(temp.value);
            if (temp.next!=null){
                temp = temp.next;
            }else {
                return;
            }
        }while (true);
    }



    private static class Node<T>{
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }

        public Node() {
        }
    }



}
