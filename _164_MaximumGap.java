package leetcode_1To300;

import java.util.Arrays;

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
public class _164_MaximumGap {
    /**
     * 164. Maximum Gap
     * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

     Try to solve it in linear time/space.

     Return 0 if the array contains less than 2 elements.

     time : O(n)
     space : O(n)


     * @param nums
     * @return
     */
    public static int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) return 0;

        int len = nums.length;
        int max = nums[0];
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        int gap = (int)Math.ceil((double)(max - min) / (len - 1));
        int[] bucketsMin = new int[len - 1];
        int[] bucketsMax = new int[len - 1];
        Arrays.fill(bucketsMax, Integer.MIN_VALUE);
        Arrays.fill(bucketsMin, Integer.MAX_VALUE);
        for (int num : nums) {
            if (num == min || num == max) continue;
            int bucket = (num - min) / gap;
            bucketsMin[bucket] = Math.min(num, bucketsMin[bucket]);
            bucketsMax[bucket] = Math.max(num, bucketsMax[bucket]);
        }

        int res = 0;
        int pre = min;
        for (int i = 0; i < len - 1; i++) {
            if (bucketsMin[i] == Integer.MAX_VALUE && bucketsMax[i] == Integer.MIN_VALUE) {
                continue;
            }
            res = Math.max(res, bucketsMin[i] - pre);
            pre = bucketsMax[i];
        }
        res = Math.max(res, max - pre);
        return res;
    }
}
