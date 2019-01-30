package leetcode_1To300;

import java.util.HashMap;

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
public class _149_MaxPointsonaLine {
    /**
     * 149. Max Points on a Line
     * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

     1，在x轴
     2，相同点
     3，精度问题(GCD) 1/3 1/3

     * time : O(n^2);
     * space : O(n);
     * @param points
     * @return
     */

    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) return 0;
        if (points.length < 2) return points.length;
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            int samePoint = 0;
            int sameXAxis = 1;
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    if (points[i].x == points[j].x && points[i].y == points[j].y) {
                        samePoint++;
                    }
                    if (points[i].x == points[j].x) {
                        sameXAxis++;
                        continue;
                    }
                    int numerator = points[i].y - points[j].y;
                    int denominator = points[i].x - points[j].x;
                    int gcd = gcd(numerator, denominator);
                    String hashStr = (numerator / gcd) + "/" + (denominator / gcd);
                    map.put(hashStr, map.getOrDefault(hashStr, 1) + 1);
                    res = Math.max(res, map.get(hashStr) + samePoint);
                }
            }
            res = Math.max(res, sameXAxis);
        }
        return res;
    }
    private int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
}
