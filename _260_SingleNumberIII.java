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
public class _260_SingleNumberIII {
    /**
     * 260. Single Number III
     * Given an array of numbers nums, in which exactly two elements appear only once and
     * all the other elements appear exactly twice. Find the two elements that appear only once.

     For example:

     Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

     A B : 二进制数字有且至少有一位是不相同

     3 : 011
     5 : 101

     3 ^ 5 : 110  -- 6
     -6 : 11111111111111111111111111111010
     6 & -6 : 000010

     1, 2, 1, 3, 2, 5

     diff = 3 ^ 5

     time : O(n)
     space : O(1)


     * @param nums
     * @return
     */
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        diff &= -diff;
        int[] res = new int[2];
        for (int num : nums) {
            if ((num & diff) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }
}
