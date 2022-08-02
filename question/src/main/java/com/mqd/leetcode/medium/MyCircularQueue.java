package com.mqd.leetcode.medium;

class MyCircularQueue {

    private final int[] queue;
    private int rear = 0;
    private int front = 0;

    public MyCircularQueue(int k) {
        queue = new int[k + 1];
    }
    
    public boolean enQueue(int value) {
        if (isFull()){
            return false;
        }
        queue[rear] = value;
        rear = (rear + 1) % queue.length;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % queue.length;
        return true;
    }
    
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return queue[front];
    }
    
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return queue[(rear-1 < 0) ? (queue.length - 1) : (rear - 1)];
    }
    
    public boolean isEmpty() {
        return rear == front;
    }
    
    public boolean isFull() {
        return (rear + 1) % queue.length == front;
    }
}