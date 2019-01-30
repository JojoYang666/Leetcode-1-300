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
public class _299_BullsandCows {
    /**
     * 299. Bulls and Cows
     * For example:

     Secret number:  "1807"
     Friend's guess: "7810"
     Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
     Write a function to return a hint according to the secret number and friend's guess,
     use A to indicate the bulls and B to indicate the cows. In the above example, your function should return "1A3B".

     Secret number:  "1123"
     Friend's guess: "0111"
     In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, and your function should return "1A1B".

     time : O(n)
     space : O(1)


     * @param secret
     * @param guess
     * @return
     */

    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] count = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                if (count[secret.charAt(i) - '0']++ < 0) cows++;
                if (count[guess.charAt(i) - '0']-- > 0) cows++;
            }
        }
        return bulls + "A" + cows + "B";
    }
}
