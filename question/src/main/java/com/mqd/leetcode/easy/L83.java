package com.mqd.leetcode.easy;

import com.mqd.struct.ListNode;

/**
 * leetcode 83. 删除排序链表中的重复元素
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 */
public class L83 {


    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode root = new ListNode(0);
            root.next = head;
            ListNode pre = null;
            ListNode cur = head;
            while (cur != null) {
                if (pre == null) {
                    pre = cur;
                    cur = cur.next;
                } else {
                    if (cur.val == pre.val) {
                        cur = cur.next;
                        pre.next = cur;
                    } else {
                        pre = cur;
                        cur = cur.next;
                    }
                }
            }
            return root.next;
        }
    }
}
