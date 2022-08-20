package com.mqd.leetcode.medium;

import com.mqd.struct.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * leetcode 382. 链表随机节点
 * 给你一个单链表，随机选择链表的一个节点，并返回相应的节点值。每个节点 被选中的概率一样 。
 *
 * 实现 Solution 类：
 *
 * Solution(ListNode head) 使用整数数组初始化对象。
 * int getRandom() 从链表中随机选择一个节点并返回该节点的值。链表中所有节点被选中的概率相等。
 */
public class L382 {


    static class Solution {
        private final List<Integer> el;

        private final Random random = new Random(System.nanoTime());

        public Solution(ListNode head) {
            el = new ArrayList<>();
            ListNode cur = head;
            while (cur != null) {
                el.add(cur.val);
                cur = cur.next;
            }
        }

        public int getRandom() {
            return el.get(random.nextInt(el.size()));
        }
    }
}
