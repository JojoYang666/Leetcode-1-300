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
public class _288_UniqueWordAbbreviation {
    /**
     * 288. Unique Word Abbreviation
     * An abbreviation of a word follows the form <first letter><number><last letter>.
     * Below are some examples of word abbreviations:

     a) it                      --> it    (no abbreviation)

     1
     b) d|o|g                   --> d1g

     1    1  1
     1---5----0----5--8
     c) i|nternationalizatio|n  --> i18n

     1
     1---5----0
     d) l|ocalizatio|n          --> l10n
     Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary.
     A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.

     Example:
     Given dictionary = [ "deer", "door", "cake", "card" ] "make"

     isUnique("dear") -> false
     isUnique("cart") -> true
     isUnique("cane") -> false
     isUnique("make") -> true


     * @param dictionary
     */

    HashMap<String, String> map;

    // time : O(n)
    public _288_UniqueWordAbbreviation(String[] dictionary) {
        map = new HashMap<>();
        for (String s : dictionary) {
            String key = getKey(s);
            if (map.containsKey(key)) {
                if (!map.get(key).equals(s)) {
                    map.put(key, "");
                }
            } else {
                map.put(key, s);
            }
        }
    }

    public boolean isUnique(String word) {
        return !map.containsKey(getKey(word)) || map.get(getKey(word)).equals(word);
    }

    private String getKey(String s) {
        if (s.length() <= 2) return s;
        return s.charAt(0) + Integer.toString(s.length() - 2) + s.charAt(s.length() - 1);
    }
}
