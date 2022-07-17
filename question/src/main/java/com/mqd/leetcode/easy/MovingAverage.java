package com.mqd.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算滑动窗口里所有数字的平均值。
 *
 * 实现 MovingAverage 类：
 *
 * MovingAverage(int size) 用窗口大小 size 初始化对象。
 * double next(int val)成员函数 next每次调用的时候都会往滑动窗口增加一个整数，请计算并返回数据流中最后 size 个值的移动平均值，
 * 即滑动窗口里所有数字的平均值。
 */
class MovingAverage {
    private final Queue<Integer> value;
    private final int size;
    private double sum;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.value = new LinkedList<>();
        this.size = size;
        this.sum = 0;
    }

    public double next(int val) {
        if (value.size() < size) {
            value.add(val);
            sum += val;
            return sum / value.size();
        }
        Integer poll = value.poll();
        if(poll != null)
            sum -= poll;
        sum += val;
        value.add(val);
        return sum / value.size();
    }

    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(5);
        System.out.println(movingAverage.next(1));
        System.out.println(movingAverage.next(10));
        System.out.println(movingAverage.next(3));
        System.out.println(movingAverage.next(5));
    }
}