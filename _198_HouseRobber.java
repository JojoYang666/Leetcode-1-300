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
public class _198_HouseRobber {
    /**
     * 198. House Robber
     * You are a professional robber planning to rob houses along a street.
     * Each house has a certain amount of money stashed, the only constraint stopping you from robbing
     * each of them is that adjacent houses have security system connected and it will automatically contact
     * the police if two adjacent houses were broken into on the same night.
     *
     [1, 3, 2, 4, 1]
          No  Yes
     1 :  0    1
     3 :  1    3
     2 :  3    3

     time : O(n)
     space : O(1)

     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int prevNo = 0;
        int prevYes = 0;
        for (int num : nums) {
            int temp = prevNo;
            prevNo = Math.max(prevNo, prevYes);
            prevYes = num + temp;
        }
        return Math.max(prevNo, prevYes);
    }
}
