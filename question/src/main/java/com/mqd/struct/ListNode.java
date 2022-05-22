package com.mqd.struct;

public class ListNode {
    public int val;
    public ListNode next;
    ListNode() {}
    public ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    public static ListNode from(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode listNode = new ListNode(arr[0]);
        ListNode cur = listNode;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return listNode;
    }
}
