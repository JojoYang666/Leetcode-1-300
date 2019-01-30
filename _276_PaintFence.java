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
public class _276_PaintFence {
    /**
     * 276. Paint Fence
     * There is a fence with n posts, each post can be painted with one of the k colors.

     You have to paint all the posts such that no more than two adjacent fence posts have the same color.

     Return the total number of ways you can paint the fence.

     1 2 3

     不同: (k - 1) * total
     相同: 2 3 相同，= 2和1 不同的种类

     time : O(n)
     space : O(1)

     * @param n
     * @param k
     * @return
     */
    public int numWays(int n, int k) {
        if (n == 0) return 0;
        if (n == 1) return k;
        int same = 0, diff = k, total = k;
        for (int i = 2; i <= n; i++) {
            same = diff;
            diff = (k - 1) * total;
            total = same + diff;
        }
        return total;
    }
}
