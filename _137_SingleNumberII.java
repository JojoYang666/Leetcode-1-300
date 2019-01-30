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
public class _137_SingleNumberII {
    /**
     * 137. Single Number II
     * Given an array of integers, every element appears three times except for one, which appears exactly once.
     * Find that single one

     0 -> 1 -> 2 -> 0
     00 -> 01 -> 10 -> 00
     00 -> 10 -> 01 -> 00

     ones twos
      0     0
     0 -> 1 0 -> 0
     1 -> 0 0 -> 1
     0 -> 0 1 -> 0

     1, 存入ones里
     2，清空ones 存入twos
     3，twos进行清空

     time : O(n)
     space : O(1)


     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int i = 0; i < nums.length; i++) {
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
        }
        return ones;
    }
}
