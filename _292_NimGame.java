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
public class _292_NimGame {
    /**
     * 292. Nim Game
     * You are playing the following Nim Game with your friend: There is a dataStructure.heap of stones on the table,
     * each time one of you take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner.
     * You will take the first turn to remove the stones.

     Both of you are very clever and have optimal strategies for the game. Write a function to determine
     whether you can win the game given the number of stones in the dataStructure.heap.

     1-true
     2-true
     3-true
     4-false
     5-true
     6-true
     7-true
     8-false

     time : O(1)
     space : O(1)

     * @param n
     * @return
     */
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
