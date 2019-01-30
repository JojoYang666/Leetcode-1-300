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
public class _151_ReverseWordsinaString {
    /**
     * 151. Reverse Words in a String
     * For example,
     Given s = "the sky is blue",
     return "blue is sky the".

     * @param s
     * @return
     */

    //time : O(n), space : O(n)
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        StringBuilder sb = new StringBuilder();
        String[] words = s.trim().split("\\s+");
        for (int i = words.length - 1; i >=0; i--) {
            sb.append(words[i] + " ");
        }
        return sb.toString().trim();
    }

    // time : O(n) space : O(n)
    public String reverseWords2(String s) {
        if (s == null || s.length() == 0) return s;
        char[] ch = s.toCharArray();
        reverse(ch, 0, s.length() - 1);
        reverseWord(ch, s.length());
        return cleanSpaces(ch, s.length());
    }

    private void reverse(char[] ch, int i, int j) {
        while (i < j) {
            char temp = ch[i];
            ch[i++] = ch[j];
            ch[j--] = temp;
        }
    }
    private void reverseWord(char[] ch, int len) {
        int i = 0;
        int j = 0;
        while (i < len) {
            while (i < j || i < len && ch[i] == ' ') i++;
            while (j < i || j < len && ch[j] != ' ') j++;
            reverse(ch, i, j - 1);
        }
    }
    private String cleanSpaces(char[] ch, int len) {
        int i = 0;
        int j = 0;
        while (j < len) {
            while (j < len && ch[j] == ' ') j++;
            while (j < len && ch[j] != ' ') ch[i++] = ch[j++];
            while (j < len && ch[j] == ' ') j++;
            if (j < len) ch[i++] = ' ';
        }
        return String.valueOf(ch).substring(0, i);
    }
}
