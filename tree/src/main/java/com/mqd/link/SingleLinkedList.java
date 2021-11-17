package com.mqd.link;

public class SingleLinkedList<T extends Comparable<T>> {

    public static void main(String[] args) {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.show();
        System.out.println("--------------");
        list.reversal();
        list.show();
    }

    private Node<T> head;

    //遍历
    public void show(){
        Node<T> cur = head;
        while (cur!=null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    //添加节点
    public void add(T val){
        if (head==null){
            head = new Node<>(val);
            return;
        }
        Node<T> cur = head;
        while (cur.next != null){
            cur = cur.next;
        }
        cur.next = new Node<>(val);
    }

    //返回节点个数
    public int size(){
        Node<T> cur = head;
        int size = 0;
        while (cur!=null){
            cur = cur.next;
            size++;
        }
        return size;
    }

    //删除节点,index从0开始
    public void remove(int index){
        if (index<0){
            throw new ArrayIndexOutOfBoundsException("越界了");
        }
        if (index==0){
            head = head.next;
            return;
        }
        Node<T> cur = head;
        Node<T> preCur = null;
        int curIndex = 0;
        while (curIndex < index){
            if (cur.next==null){
                throw new ArrayIndexOutOfBoundsException("越界了");
            }
            preCur = cur;
            cur = cur.next;
            curIndex++;
        }
        preCur.next = cur.next;
    }

    private Node<T> getNodeParent(int index){

        return null;
    }

    //交换两个节点
    public void swap(int index1, int index2){
        if (index1 < 0 || index2 < 0){
            throw new ArrayIndexOutOfBoundsException("越界了");
        }
        int max = Math.max(index1, index2);
        int min = Math.min(index1, index2);
        Node<T> cur = head;
        Node<T> preCurMin = null;
        Node<T> preCurMax = null;
        int curIndex = 0;
        while (true){
            if (cur==null){
                throw new ArrayIndexOutOfBoundsException("越界了");
            }
            if (curIndex<min){
                preCurMin = cur;
                cur = cur.next;
                curIndex++;
            }else if (curIndex<max){
                preCurMax = cur;
                cur = cur.next;
                curIndex++;
            }else {
                break;
            }
        }
        //实际交换
        if (preCurMin==null && Math.abs(index1-index2)==1){
            cur = head;
            head = head.next;
            cur.next = head.next;
            head.next = cur;
            return;
        }
        if (preCurMin==null && Math.abs(index1-index2)>1){
            cur = head;
            head = preCurMax.next;
            Node<T> temp = cur.next;
            cur.next = head.next;
            head.next = temp;
            preCurMax.next = cur;
            return;
        }
        assert preCurMin != null;
        if (preCurMin.next == preCurMax){
            preCurMin.next = preCurMax.next;
            preCurMax.next = preCurMin.next.next;
            preCurMin.next.next = preCurMax;
            return;
        }
        Node<T> temp = preCurMin.next;

        preCurMin.next = preCurMax.next;
        preCurMax.next = temp;
        cur = preCurMin.next.next;
        preCurMin.next.next = temp.next;
        temp.next = cur;

    }

    //反转链表
    public void reversal(){
        if (size()<2){
            return;
        }
        Node<T> cur = head;
        Node<T> next = cur.next;
        Node<T> m = next.next;
        head.next = null;
        while (true){
            next.next = cur;
            cur = next;
            next = m;
            m = m.next;
            if (next.next==null){
                next.next = cur;
                break;
            }
        }
        head = next;
    }







    static class Node<T>{
        private final T val;
        private Node<T> next;

        public Node(T val) {
            this.val = val;
        }
    }
}
