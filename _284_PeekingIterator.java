package leetcode_1To300;

import java.util.Iterator;

/**
 * 本代码来自 Cspiration，由 @Cspiration 提供
 * 题目来源：http://leetcode.com
 * - Cspiration 致力于在 CS 领域内帮助中国人找到工作，让更多海外国人受益
 * - 现有课程：Leetcode Java 版本视频讲解（1-900题）（上）（中）（下）三部
 * - 算法基础知识（上）（下）两部；题型技巧讲解（上）（下）两部
 * - 节省刷题时间，效率提高2-3倍，初学者轻松一天10题，入门者轻松一天20题
 * - 讲师：Edward Shi
 * - 官方网站：https://cspiration.com
 * - 版权所有，转发请注明出处
 */
public class _284_PeekingIterator {
    /**
     * 284. Peeking Iterator
     Here is an example. Assume that the iterator is initialized to the beginning of the list: [1, 2, 3].

     Call next() gets you 1, the first element in the list.

     Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.

     You call next() the final time and it returns 3, the last element. Calling hasNext() after that should return false.


     * @param iterator
     */

    private Iterator<Integer> iter;
    private Integer next = null;

    public _284_PeekingIterator(Iterator<Integer> iterator) {
        iter = iterator;
        if (iter.hasNext()) {
            next = iter.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    //@Override
    public Integer next() {
        Integer res = next;
        next = iter.hasNext() ? iter.next() : null;
        return res;
    }

    //@Override
    public boolean hasNext() {
        return next != null;
    }
}
