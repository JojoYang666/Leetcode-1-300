package leetcode_1To300;

import java.util.LinkedList;
import java.util.Queue;

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
public class _210_CourseScheduleII {
    /**
     * 210. Course Schedule II
     * There are a total of n courses you have to take, labeled from 0 to n - 1.

     Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
     which is expressed as a pair: [0,1]

     Given the total number of courses and a list of prerequisite pairs, return the resing of courses you should
     take to finish all courses.

     There may be multiple correct ress, you just need to return one of them. If it is impossible to finish all courses,
     return an empty array.

     For example:

     2, [[1,0]]
     There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course res
     is [0,1]

     4, [[1,0],[2,0],[3,1],[3,2]]
     There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2.
     Both courses 1 and 2 should be taken after you finished course 0. So one correct course res is [0,1,2,3].
     Another correct resing is[0,2,1,3].


       -> 1 ->
     0         3
       -> 2 ->


     入度 = 0 => BFS

     0 : 0
     1 : 0
     2 : 0
     3 : 0

     queue : 3
     res : 0,1,2,3

     time : O(V + E)
     space : O(n)

     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findres(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        int[] res = new int[numCourses];
        int k = 0;
        for (int[] pair : prerequisites) {
            indegree[pair[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                res[k++] = i;
            }
        }
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            for (int[] pair : prerequisites) {
                if (pair[1] == pre) {
                    indegree[pair[0]]--;
                    if (indegree[pair[0]] == 0) {
                        queue.offer(pair[0]);
                        res[k++] = pair[0];
                    }
                }
            }
        }
        return (k == numCourses) ? res : new int[0];
    }
}
