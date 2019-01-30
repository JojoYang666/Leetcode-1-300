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
public class _298_BinaryTreeLongestConsecutiveSequence {

    /**
     * 298. Binary Tree Longest Consecutive Sequence
     * Given a binary tree, find the length of the longest consecutive sequence path.

     The path refers to any sequence of nodes from some starting node to any node
     in the tree along the parent-child connections. The longest consecutive path need to
     be from parent to child (cannot be the reverse).

     For example,
      1
      \
       3
      / \
     2   4
          \
           5
     Longest consecutive sequence path is 3-4-5, so return 3.
        2
         \
         3
        /
       2
      /
     1
     Longest consecutive sequence path is 2-3,not3-2-1, so return 2.

     time : O(n);
     space : O(n);
     * @param root
     * @return
     */

    private int res = 0;

    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        helper(root, 0, root.val);
        return res;
    }

    public void helper(TreeNode root, int max, int target) {
        if (root == null) return;
        if (root.val == target) {
            max++;
        } else max = 1;
        res = Math.max(res, max);
        helper(root.left, max, root.val + 1);
        helper(root.right, max, root.val + 1);
    }

}
