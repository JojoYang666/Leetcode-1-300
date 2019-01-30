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
public class _231_PowerofTwo {
    /**
     * 231. Power of Two
     * Given an integer, write a function to determine if it is a power of two.
     *
     *
     * 2, 4, 8, 16...
     *
     * 2 : 10
     * 4 : 100
     * 8 : 1000
     * 16: 10000
     *
     *
     * n : 16 : 10001
     * n - 1  : 10000
     *
     * time : O(1);
     * space : O(1);
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo(int n) {
        return n > 0 && ((n & (n - 1)) == 0);
    }
}
