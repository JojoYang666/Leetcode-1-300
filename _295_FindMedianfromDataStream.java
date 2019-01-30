package leetcode_1To300;

import java.util.PriorityQueue;

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
public class _295_FindMedianfromDataStream {
    /**
     * 295. Find Median from Data Stream
     * For example:

     addNum(1)
     addNum(2)
     findMedian() -> 1.5
     addNum(3)
     findMedian() -> 2

     1 2 -3 4
     -3 1 2 4

     small : 3 -1
     large : 2 4

     time : O(logn)
     space : O(n)
     */

    private PriorityQueue<Long> small;
    private PriorityQueue<Long> large;

    public _295_FindMedianfromDataStream() {  // MedianFinder()
        small = new PriorityQueue<>();
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        large.add((long)num);
        small.add(-large.poll());
        if (large.size() < small.size()) {
            large.add(-small.poll());
        }
    }

    public double findMedian() {
        return large.size() > small.size() ? large.peek() : (large.peek() - small.peek()) / 2;
    }
}
