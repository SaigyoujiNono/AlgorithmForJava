package com.mqd.leetcode.week300;

import com.mqd.struct.ListNode;

import java.util.Arrays;

/**
 * leetcode 6111. 螺旋矩阵 IV
 * 给你两个整数：m 和 n ，表示矩阵的维数。
 *
 * 另给你一个整数链表的头节点 head 。
 *
 * 请你生成一个大小为 m x n 的螺旋矩阵，矩阵包含链表中的所有整数。链表中的整数从矩阵 左上角 开始、顺时针 按 螺旋 顺序填充。如果还存在剩余的空格，则用 -1 填充。
 *
 * 返回生成的矩阵。
 */
public class L6111 {
    public static void main(String[] args) {
        L6111 p = new L6111();
//        ListNode from = ListNode.from(new int[]{3, 0, 2, 6, 8, 1, 7, 9, 4, 2, 5, 5, 0});
        ListNode from = ListNode.from(new int[]{8,24,5,21,10,11,11,12,6,17});
        int[][] ints = p.spiralMatrix(3, 5, from);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] ints = new int[m][n];
        int x = 0;
        m = m - 1;
        n = n - 1;
        while (true) {
            for (int col = x; col <= n; col++) {
                ints[x][col] = head == null ? -1 : head.val;
                head = head == null ? null : head.next;
            }

            for (int row = x + 1; row <= m; row++) {
                ints[row][n] = head == null ? -1 : head.val;
                head = head == null ? null : head.next;
            }

            if (x < n && x < m) {
                for (int col = n - 1; col >= x ; col--) {
                    ints[m][col] = head == null ? -1 : head.val;
                    head = head == null ? null : head.next;
                }
            }

            if (x < n && x < m) {
                for (int row = m - 1; row > x; row--) {
                    ints[row][x] = head == null ? -1 : head.val;
                    head = head == null ? null : head.next;
                }
            }
            if (x >= m || x >= n) {
                break;
            }
            x++;
            m--;
            n--;
        }
        return ints;
    }
}
