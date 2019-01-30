package leetcode_1To300;

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
public class _277_FindtheCelebrity {
    /**
     * 277. Find the Celebrity
     * Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity.
     * The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.
     * You are given a helper function bool knows(a, b) which tells you whether A knows B.
     * Implement a function int findCelebrity(n), your function should minimize the number of calls to knows.
     *
     * 0 1 2 3 4 5
     *   3 : Celebrity
     *   0 : 1   1: 2   2 : 4   4 : 5   5 : 1
     *   possible = 3
     *
     * time : O(n)
     * space : O(1)
     *
     * @param n
     * @return
     */
    public int findCelebrity(int n) {
        if (n < 2) return -1;
        int possible = 0;
        for (int i = 1; i < n; i++) {
            if (knows(possible, i)) {
                possible = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (possible != i && ((knows(possible, i) || !knows(i, possible)))) {
                return -1;
            }
        }
        return possible;
    }

    public boolean knows(int a, int b) {
        return true;
    }
}
