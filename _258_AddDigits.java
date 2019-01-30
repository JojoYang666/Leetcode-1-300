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
public class _258_AddDigits {
    /**
     * 258. Add Digits
     * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

     For example:

     Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

     1    1
     2    2
     3    3
     4    4
     5    5
     6    6
     7    7
     8    8
     9    9
     10    1
     11    2
     12    3
     13    4
     14    5
     15    6
     16    7
     17    8
     18    9
     19    1
     20    2

     time : O(logn)
     space : O(1)
     * @param num
     * @return
     */

    public static int addDigits1(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        if (sum >= 10) {
            return addDigits1(sum);
        } else {
            return sum;
        }
    }

    public static int addDigits2(int num) {
        return (num - 1) % 9 + 1;
    }
}
