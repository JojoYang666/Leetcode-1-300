package leetcode_1To300;

import java.util.HashSet;

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
public class _266_PalindromePermutation {
    /**
     * 266. Palindrome Permutation
     * Given a string, determine if a permutation of the string could form a palindrome.

     For example,
     "code" -> False, "aab" -> True, "carerac" -> True.

     time : O(n)
     * @param s
     * @return
     */

    //space : O(n)
    public boolean canPermutePalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        return set.size() <= 1;
    }

    //space : O(1)
    public boolean canPermutePalindrome2(String s) {
        char[] count = new char[256];
        int res = 0;
        for (char c : s.toCharArray()) {
            if (count[c] > 0) {
                count[c]--;
            } else {
                count[c]++;
            }
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) res++;
        }
        return res <= 1;
    }
}
