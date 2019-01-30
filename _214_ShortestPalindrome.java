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
public class _214_ShortestPalindrome {
    /**
     * 214. Shortest Palindrome
     * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it.
     * Find and return the shortest palindrome you can find by performing this transformation.

     For example:

     Given "aacecaaa", return "aaacecaaa".

     Given "abcd", return "dcbabcd".

     I agree for smaller strings charAt function may be fast. But when coming to big strings,
     I think the scenario is different. Because when I see the code for string last night
     I have found that toCharArray uses function System.arraycopy.
     We know System.arraycopy(I think it is native call) is faster.

     So when we use for loop based operations on String, we are directly moving to index for char array whereas
     we need to call the function for charAt. So for Bigger strings calling the function multiple times
     may reduce the performance of the method.


     * @param s
     * @return
     */

    // time :  O(n^2) for aaaaabcaaaaa
    public String shortestPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        int end = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                i = 0;
                end--;
                j = end;
            }
        }
        return new StringBuilder(s.substring(end + 1)).reverse().toString() + s;
    }
}
