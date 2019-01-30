package leetcode_1To300;

import java.util.PriorityQueue;

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
public class _215_KthLargestElementinanArray {

    /**
     * 215. Kth Largest Element in an Array
     * 最坏：O(n^2) 平均：O(nlogn)
     * space : O(1)
     * @param nums
     * @param k
     * @return
     */

    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0;
        int right = nums.length - 1;
        while (true) {
            int pos = partition(nums, left, right);
            if (pos + 1 == k) {
                return nums[pos];
            } else if (pos + 1 > k) {
                right = pos - 1;
            } else {
                left = pos + 1;
            }
        }
    }

    /**
     *   3,2,1,5,6,4  k = 3
     *   0 1 2 3 4 5
     pivot : 3  [3, 2, 1, 5, 6, 4]
     [3, 4, 6, 5, 1, 2]   3

     pivot : 5  [5, 4, 6, 3, 1, 2]
     [5, 6, 4, 3, 1, 2]   1

     pivot : 4  [6, 5, 4, 3, 1, 2]
     [6, 5, 4, 3, 1, 2]   2
     */

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left + 1;
        int r = right;
        while (l <= r) {
            if (nums[l] < pivot && nums[r] > pivot) {
                swap(nums, l++, r--);
            }
            if (nums[l] >= pivot) l++;
            if (nums[r] <= pivot) r--;
        }
        swap(nums, left, r);
        return r;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * time : O(nlogk)
     * space : O(k)
     *
     * @param nums
     * @param k
     * @return
     */


    public int findKthLargest2(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }
}
