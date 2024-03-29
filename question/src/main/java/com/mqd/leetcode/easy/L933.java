package com.mqd.leetcode.easy;

import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 933. 最近的请求次数
 * 写一个RecentCounter类来计算特定时间范围内最近的请求。
 *
 * 请你实现 RecentCounter 类：
 *
 * RecentCounter() 初始化计数器，请求数为 0 。
 * int ping(int t) 在时间 t 添加一个新请求，其中 t 表示以毫秒为单位的某个时间，
 * 并返回过去 3000 毫秒内发生的所有请求数（包括新请求）。确切地说，返回在 [t-3000, t] 内发生的请求数。
 * 保证 每次对 ping 的调用都使用比之前更大的 t 值。
 */
public class L933 {

    public static void main(String[] args) {
        RecentCounter p = new RecentCounter();
        System.out.println(p.ping(642));
        System.out.println(p.ping(1849));
        System.out.println(p.ping(4921));
        System.out.println(p.ping(5936));
        System.out.println(p.ping(5957));
    }

    static class RecentCounter {

        List<Integer> list;

        public RecentCounter() {
            list = new LinkedList<>();
        }

        public int ping(int t) {
            while (!list.isEmpty()) {
                int time = list.get(0);
                if (t - time > 3000) {
                    list.remove(0);
                } else {
                    break;
                }
            }
            list.add(t);
            return list.size();
        }
    }
}
