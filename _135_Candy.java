package leetcode_1To300;

import java.util.Arrays;

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
public class _135_Candy {
    /**
     * 135. Candy
     * There are N children standing in a line. Each child is assigned a rating value.

     You are giving candies to these children subjected to the following requirements:

     Each child must have at least one candy.
     Children with a higher rating get more candies than their neighbors.
     What is the minimum candies you must give?

     ratings:     [4, 5, 1, 1, 3, 7]
     candies:     [1, 1, 1, 1, 1, 1]

     ratings:     [4, 5, 1, 1, 3, 7]
     candies:     [1, 2, 1, 1, 2, 3]

     ratings:     [4, 5, 1, 1, 3, 7]
     candies:     [1, 2, 1, 1, 2, 3]

     time : O(n)
     space : O(n)


     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);

        for (int i = 1; i < candies.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        for (int i = candies.length - 2; i >= 0; i --) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        int res = 0;
        for (int candy : candies) {
            res += candy;
        }
        return res;
    }
}
