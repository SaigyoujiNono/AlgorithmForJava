package com.mqd.leetcode.medium;

import com.mqd.struct.ListNode;

/**
 * leetcode 82 删除排序链表中的重复元素 II
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 */
public class L82 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(1);
        ListNode cur = deleteDuplicates(l1);
        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode r = new ListNode(-101);
        r.next = head;
        ListNode pre = r;
        ListNode cur = r;
        ListNode first = r;
        boolean flag = false;
        while (cur.next != null) {
            cur = cur.next;
            if (cur.val != first.val && !flag) {
                pre = first;
                first = cur;
            } else if (cur.val != first.val){
                pre.next = cur;
                first = cur;
                flag = false;
            } else {
                flag = true;
            }
        }
        if (flag){
            pre.next = null;
        }
        return r.next;
    }
}
