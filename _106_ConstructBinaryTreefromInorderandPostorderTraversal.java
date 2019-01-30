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
public class _106_ConstructBinaryTreefromInorderandPostorderTraversal {
    /**
     * 106. Construct Binary Tree from Inorder and Postorder Traversal
     *      3
         /    \
        9     20
      /  \   /  \
     15   7 1    5

     inorder : 15 9 7 3 1 20 5
     postorder : 15 7 9 1 5 20 3

     time : O(n)
     space : O(n)
     * @param inorder
     * @param postorder
     * @return
     */

    int pInorder;
    int pPostorder;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        pInorder = inorder.length - 1;
        pPostorder = postorder.length - 1;
        return helper(inorder, postorder, null);
    }

    public TreeNode helper(int[] inorder, int[] postorder, TreeNode end) {
        if (pPostorder < 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[pPostorder--]);
        if (inorder[pInorder] != root.val) {
            root.right = helper(inorder, postorder, root);
        }
        pInorder--;
        if ((end == null) || (inorder[pInorder] != end.val)) {
            root.left = helper(inorder, postorder, end);
        }
        return root;
    }
}
