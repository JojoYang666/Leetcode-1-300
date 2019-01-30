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
public class _296_BestMeetingPoint {

    /**
     * 296. Best Meeting Point
     * A group of two or more people wants to meet and minimize the total travel distance.
     * You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group.
     * The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

     For example, given three people living at (0,0), (0,4), and (2,2):

     1 - 0 - 0 - 0 - 1
     |   |   |   |   |
     0 - 0 - 0 - 0 - 0
     |   |   |   |   |
     0 - 0 - 1 - 0 - 0
     The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal. So return 6.

     A    C   E  D         B
     ------------------------

     time : O(m * n)
     space : O(n)


     * @param grid
     * @return
     */

    public int minTotalDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        List<Integer> I = new ArrayList<>();
        List<Integer> J = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    I.add(i);
                }
            }
        }

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1) {
                    J.add(j);
                }
            }
        }

        return min(I) + min(J);
    }

    private int min(List<Integer> list) {
        int i = 0, j = list.size() - 1;
        int sum = 0;
        while (i < j) {
            sum += list.get(j--) - list.get(i++);
        }
        return sum;
    }
}
