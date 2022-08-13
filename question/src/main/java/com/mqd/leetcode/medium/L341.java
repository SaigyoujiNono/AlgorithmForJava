package com.mqd.leetcode.medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * leetcode 341. 扁平化嵌套列表迭代器
 * 给你一个嵌套的整数列表 nestedList 。每个元素要么是一个整数，要么是一个列表；该列表的元素也可能是整数或者是其他列表。
 * 请你实现一个迭代器将其扁平化，使之能够遍历这个列表中的所有整数。
 *
 * 实现扁平迭代器类 NestedIterator ：
 *
 * NestedIterator(List<NestedInteger> nestedList) 用嵌套列表 nestedList 初始化迭代器。
 * int next() 返回嵌套列表的下一个整数。
 * boolean hasNext() 如果仍然存在待迭代的整数，返回 true ；否则，返回 false 。
 * 你的代码将会用下述伪代码检测：
 *
 * initialize iterator with nestedList
 * res = []
 * while iterator.hasNext()
 *     append iterator.next() to the end of res
 * return res
 * 如果 res 与预期的扁平化列表匹配，那么你的代码将会被判为正确。
 */
public class L341 {


    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        List<NestedInteger> getList();
    }

    static public class NestedIterator implements Iterator<Integer> {
        private final List<Integer> list;

        private final Iterator<Integer> iterator;

        public NestedIterator(List<NestedInteger> nestedList) {
            list = new ArrayList<>();
            buildArray(nestedList);
            iterator = list.iterator();
        }

        private void buildArray(List<NestedInteger> nestedList) {
            for (NestedInteger next : nestedList) {
                if (next.isInteger()) {
                    list.add(next.getInteger());
                } else {
                    buildArray(next.getList());
                }
            }
        }

        @Override
        public Integer next() {
            return iterator.next();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }
    }
}
