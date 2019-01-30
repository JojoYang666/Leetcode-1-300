package leetcode_1To300;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

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
public class _281_ZigzagIterator {
    /**
     * 281. Zigzag Iterator
     * For example, given two 1d vectors:

     v1 = [1, 2]
     v2 = [3, 4, 5, 6]

     output : 1 3 2 4 5 6

     [1,2,3]
     [4,5,6,7]
     [8,9]
     It should return [1,4,8,2,5,9,3,6,7].

     time : O(n)
     space : O(1)

     * @param v1
     * @param v2
     */

    private Iterator<Integer> i, j, temp;


    public _281_ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        i = v2.iterator();
        j = v1.iterator();
    }

    public int next() {
        if (j.hasNext()) {
            temp = j;
            j = i;
            i = temp;
        }
        return i.next();
    }

    public boolean hasNext() {
        return i.hasNext() || j.hasNext();
    }

    /**
     * v1 = [1, 2]
     v2 = [3, 4, 5, 6]

     time : O(n)
     space : O(2)
     */

    LinkedList<Iterator> list;

    public void ZigzagIterator2(List<Integer> v1, List<Integer> v2) {
        list = new LinkedList<>();
        if (!v1.isEmpty()) list.add(v1.iterator());
        if (!v2.isEmpty()) list.add(v2.iterator());
    }

    public int next2() {
        Iterator poll = list.remove();
        int result = (Integer) poll.next();
        if (poll.hasNext()) {
            list.add(poll);
        }
        return result;
    }

    public boolean hasNext2() {
        return !list.isEmpty();
    }
}
