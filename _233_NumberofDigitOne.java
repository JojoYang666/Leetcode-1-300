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
public class _233_NumberofDigitOne {
    /**
     * 233. Number of Digit One
     * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

     For example:
     Given n = 13,
     Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.

     10 : 1    个位
     100 : 10  十位
     1000: 100 百位

     例子:
     以算百位上1为例子:   假设百位上是0, 1, 和 >=2 三种情况:
     case 1: n=3141092, a= 31410, b=92. 计算百位上1的个数应该为 3141 *100 次.
     case 2: n=3141192, a= 31411, b=92. 计算百位上1的个数应该为 3141 *100 + (92+1) 次.
     case 3: n=3141592, a= 31415, b=92. 计算百位上1的个数应该为 (3141+1) *100 次.

     http://blog.csdn.net/xudli/article/details/46798619

     time : O(logn)
     space : O(1)

     * @param n
     * @return
     */

    public int countDigitOne(int n) {
        int res = 0;
        for (long m = 1; m <= n; m *= 10) {
            long a = n / m;
            long b = n % m;
            res += (a + 8) / 10 * m;
            if (a % 10 == 1) res += b + 1;
        }
        return res;
    }
}
