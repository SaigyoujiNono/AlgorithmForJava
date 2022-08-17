package com.mqd.leetcode.medium;

import com.mqd.struct.ListNode;

/**
 * leetcode 2181. 合并零之间的节点
 * 给你一个链表的头节点 head ，该链表包含由 0 分隔开的一连串整数。链表的 开端 和 末尾 的节点都满足 Node.val == 0 。
 *
 * 对于每两个相邻的 0 ，请你将它们之间的所有节点合并成一个节点，其值是所有已合并节点的值之和。
 * 然后将所有 0 移除，修改后的链表不应该含有任何 0 。
 *
 * 返回修改后链表的头节点 head 。
 */
public class L2181 {

    static class Solution {
        public ListNode mergeNodes(ListNode head) {
            ListNode cur = head;
            ListNode t = null;
            while (cur.next != null) {
                if (cur.next.val != 0) {
                    cur.val += cur.next.val;
                    cur.next = cur.next.next;
                } else {
                    t = cur;
                    cur = cur.next;
                }
            }
            if (t != null) {
                t.next = null;
            }
            return head;
        }
    }
}
