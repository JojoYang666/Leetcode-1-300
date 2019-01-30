package leetcode_1To300;

import java.util.ArrayList;
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
public class NestedInteger {

    Integer value;
    List<NestedInteger> list;

    NestedInteger() {
        value = new Integer(0);
        list = new ArrayList<>();
    }
    NestedInteger(int value) {
        this.value = value;
    }
    NestedInteger(int value, List<NestedInteger> list) {
        this.value = value;
        this.list = list;
    }
    public void add(NestedInteger nestedInteger){}

    // @return true if this NestedInteger holds a single integer,
    // rather than a nested list.
    public boolean isInteger() {
        return value != null;
    }
    // @return the single integer that this NestedInteger holds,
    // if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() {
        return value;
    }
    // @return the nested list that this NestedInteger holds,
    // if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
        return list;
    }

    public Integer next() {
        return value; // 例子，真正函数不是这么写的
    }
    public boolean hasNext() {
        return true; // 例子，真正函数不是这么写的
    }


}
