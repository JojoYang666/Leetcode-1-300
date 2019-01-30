package leetcode_1To300;

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
public class _251_Flatten2DVector {
    /**
     * 251. Flatten 2D Vector
     * Given 2d vector =

     [
     [1,2],
     [3],
     [4,5,6]
     ]
     By calling next repeatedly until hasNext returns false,
     the order of elements returned by next should be: [1,2,3,4,5,6].

     time : O(n)
     space : O(1)

     */

    int indexList, indexElement;
    List<List<Integer>> list;


    public _251_Flatten2DVector(List<List<Integer>> vec2d) {
        indexElement = 0;
        indexList = 0;
        list = vec2d;
    }


    //@Override
    public Integer next() {
        return list.get(indexList).get(indexElement++);
    }

    //@Override
    public boolean hasNext() {
        while (indexList < list.size()) {
            if (indexElement < list.get(indexList).size()) {
                return true;
            } else {
                indexList++;
                indexElement = 0;
            }
        }
        return false;
    }
}
