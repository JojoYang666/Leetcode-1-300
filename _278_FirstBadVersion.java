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
public class _278_FirstBadVersion {
    /**
     * 278. First Bad Version
                 bad
     1, 2, 3, 4, 5, 6, 7

     time : O(logn)
     space : O(1)
     * @param n
     * @return
     */

    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;

        while (start < end) {
            int mid = (end - start) / 2 + start;
            if (isBadVersion(mid)) {
                end = mid;
            } else start = mid + 1;
        }

        return start;
    }

    public int firstBadVersion2(int n) {
        int start = 1;
        int end = n;

        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (isBadVersion(mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    public int firstBadVersion3(int n) {
        int start = 1;
        int end = n;

        while (start + 1< end) {
            int mid = (end - start) / 2 + start;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (isBadVersion(start)) {
            return start;
        }
        return end;
    }

    public boolean isBadVersion(int mid) {
        return true;
    }
}
