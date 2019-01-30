package leetcode_1To300;

import java.util.ArrayList;
import java.util.List;

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
public class _257_BinaryTreePaths {
    /**
     * 257. Binary Tree Paths
     * Given a binary tree, return all root-to-leaf paths.

     For example, given the following binary tree:
          3
         / \
        9  20
      /  \
     15   7
     ["3->9->15", "3->9->7", "3->20]

     case :
           3
          / \
         9  20
       /  \
     15   7
     3->9->15
     3->9->7
     3->20
     ["3->9->15", "3->9->7", "3->20]

     time : O(n);
     space : O(n);
     * @param root
     * @return
     */
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, root, "");
        return res;
    }
    public static void helper(List<String> res, TreeNode root, String path) {
        if (root.left == null && root.right == null) {
            res.add(path + root.val);
        }
        if (root.left != null) {
            helper(res, root.left, path + root.val + "->");
        }
        if (root.right != null) {
            helper(res, root.right, path + root.val + "->");
        }
    }
}
