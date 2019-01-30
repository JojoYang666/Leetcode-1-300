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
public class _222_CountCompleteTreeNodes {

    /**
     * 222. Count Complete Tree Nodes
     * Given a complete binary tree, count the number of nodes.

     Definition of a complete binary tree from Wikipedia:
     In a complete binary tree every level, except possibly the last, is completely filled, and all nodes
     in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

           3
         /   \
        9     20
      /  \   /  \
     15   7 1

     2^h - 1

     time : O(logn * logn)
     space : O(n) / O(logn) 不确定

     * @param root
     * @return
     */

    public int countNodes(TreeNode root) {
        // int left = helper(root, true);
        // int right = helper(root, false);
        int left = leftDepth(root);
        int right = rightDepth(root);

        if (left == right) {
            return (1 << left) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    private int leftDepth(TreeNode root) {
        int res = 0;
        while (root != null) {
            root = root.left;
            res++;
        }
        return res;
    }

    private int rightDepth(TreeNode root) {
        int res = 0;
        while (root != null) {
            root = root.right;
            res++;
        }
        return res;
    }

    private int helper(TreeNode root, boolean isLeft) {
        if (root == null) return 0;
        return isLeft ? helper(root.left, isLeft) + 1: helper(root.right, isLeft) + 1;
    }

    public int countNodes2(TreeNode root) {
        if (root == null)
            return 0;
        TreeNode left = root, right = root;
        int height = 0;
        while (right != null) {
            left = left.left;
            right = right.right;
            height++;
        }
        if (left == null)
            return (1 << height) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
