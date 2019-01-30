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
public class _245_ShortestWordDistanceIII {
    /**
     * 245. Shortest Word Distance III
     * This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.

     Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

     word1 and word2 may be the same and they represent two individual words in the list.

     For example,
     Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

     Given word1 = “makes”, word2 = “coding”, return 1.
     Given word1 = "makes", word2 = "makes", return 3.

     time : O(n)
     space : O(1)

     PS：这里忽略了equals的时间复杂度，要不equals也是 O(n)


     * @param words
     * @param word1
     * @param word2
     * @return
     */
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int res = words.length;
        int a = -1;
        int b = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                a = i;
            }
            if (words[i].equals(word2)) {
                if (word1.equals(word2)) {
                    a = b;
                }
                b = i;
            }
            if (a != -1 && b != -1) {
                res = Math.min(res, Math.abs(a - b));
            }
        }
        return res;
    }
}
