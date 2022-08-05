package com.mqd.leetcode.easy;

import com.mqd.struct.ListNode;
import java.util.Stack;

/**
 * 剑指 Offer II 027. 回文链表
 * 给定一个链表的 头节点 head ，请判断其是否为回文链表。
 *
 * 如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。
 */
public class LOfferII27 {

    public static void main(String[] args) {
        Solution p = new Solution();
        ListNode from = ListNode.from(new int[]{1, 2, 4, 5, 5, 2, 1});
        System.out.println(p.isPalindrome2(from));
    }

    static class Solution {

        public boolean isPalindrome2(ListNode head) {
            ListNode h = new ListNode(-1);
            h.next = head;
            ListNode fast = h;
            ListNode slow = h;
            ListNode pre = h;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                ListNode temp = slow;
                slow = slow.next;
                temp.next = pre;
                pre = temp;
            }
            if (fast == null) {
                slow = slow.next;
                while (slow != null) {
                    if (slow.val != pre.val) {
                        return false;
                    }
                    slow = slow.next;
                    pre = pre.next;
                }
                return true;
            }
            ListNode temp = slow;
            slow = slow.next;
            temp.next = pre;
            pre = temp;
            while (slow != null) {
                if (slow.val != pre.val) {
                    return false;
                }
                slow = slow.next;
                pre = pre.next;
            }
            return true;
        }
        public boolean isPalindrome(ListNode head) {
            Stack<ListNode> s = new Stack<>();
            ListNode h = new ListNode(-1);
            h.next = head;
            ListNode fast = h;
            ListNode slow = h;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                s.push(slow);
            }
            if (fast == null) {
                s.pop();
            }
            slow = slow.next;
            while (!s.isEmpty()) {
                if (s.pop().val != slow.val) {
                    return false;
                }
                slow = slow.next;
            }
            return true;
        }
    }
}
