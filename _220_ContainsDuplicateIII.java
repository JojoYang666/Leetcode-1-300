package leetcode_1To300;

import java.util.HashMap;
import java.util.TreeSet;

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
public class _220_ContainsDuplicateIII {
    /**
     * 220. Contains Duplicate III
     * Given an array of integers, find out whether there are two distinct indices i and j in the array such
     * that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference
     * between i and j is at most k.

     time : O(nlogk)
     space : O(k)

     * @param nums
     * @param k
     * @param t
     * @return
     */

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if( k < 1 || t < 0) return false;
        TreeSet<Long> set = new TreeSet<>();
        for(int i = 0; i < nums.length; i++){
            Long floor = set.floor((long)nums[i] + t);
            Long ceil = set.ceiling((long)nums[i] - t);

            if((floor != null && floor >= nums[i])
                    || (ceil != null && ceil <= nums[i]) )
                return true;

            set.add((long)nums[i]);
            if(i >= k){
                set.remove((long)nums[i-k]);
            }
        }
        return false;
    }

    /**

     time : O(n)
     space : O(k)

     * @param nums
     * @param k
     * @param t
     * @return
     */

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        HashMap<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long) t + 1);
            if (map.containsKey(bucket)
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                    || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
                return true;
            if (map.entrySet().size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum);
        }
        return false;
    }
}
