package com.mqd.leetcode.medium;

/**
 * leetcode 641. 设计循环双端队列
 */
class MyCircularDeque {

    private final int[] queue;

    private int rear;

    private int head;

    public MyCircularDeque(int k) {
        queue = new int[k + 1];
        rear = 0;
        head = 0;
    }
    
    public boolean insertFront(int value) {
        if ((rear + 1) % queue.length == head) {
            return false;
        }
        head = head - 1 < 0 ? (queue.length - 1) : (head - 1);
        queue[head] = value;
        return true;
    }
    
    public boolean insertLast(int value) {
        if ((rear + 1) % queue.length == head) {
            return false;
        }
        queue[rear] = value;
        rear = (rear + 1) % queue.length;
        return true;
    }
    
    public boolean deleteFront() {
        if (rear == head) return false;
        head = (head + 1) % queue.length;
        return true;
    }
    
    public boolean deleteLast() {
        if (rear == head) return false;
        rear = rear - 1 < 0 ? (queue.length - 1) : (rear - 1);
        return true;
    }
    
    public int getFront() {
        if(rear == head) return -1;
        return queue[head];
    }
    
    public int getRear() {
        if(rear == head) return -1;
        return queue[rear - 1 < 0 ? (queue.length - 1) : (rear - 1)];
    }
    
    public boolean isEmpty() {
        return rear == head;
    }
    
    public boolean isFull() {
        return (rear + 1) % queue.length == head;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */