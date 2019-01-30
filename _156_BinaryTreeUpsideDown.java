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
public class _156_BinaryTreeUpsideDown {
    /**
     * 156. Binary Tree Upside Down
     * Given a binary tree where all the right nodes are either leaf nodes with a
     * sibling (a left node that shares the same parent node) or empty,
     * flip it upside down and turn it into a tree where the original right nodes
     * turned into left leaf nodes. Return the new root.

     For example:
     Given a binary tree {1,2,3,4,5},
         1
        / \
       2   3
      / \
     4   5
     return the root of the binary tree [4,5,2,#,#,3,1].
       4
      / \
     5   2
        / \
       3   1

         1         1
        / \       /
       2   3     2 - 3
      / \       /
     4   5     4 - 5

     time : O(n);
     space : O(n);
     * @param root
     * @return
     */
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return root;
        }
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;

        root.left = null;
        root.right = null;
        return newRoot;
    }

}
