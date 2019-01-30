package leetcode_1To300;

import java.util.LinkedList;
import java.util.Queue;

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
public class _297_SerializeandDeserializeBinaryTree {

    /**
     * 297. Serialize and Deserialize Binary Tree
     *
     *
       1
      / \
     2   3
        / \
       4   5
     as "[1,2,3,null,null,4,5]"
     * time : O(n);
     * space : O(n);
     * @param root
     * @return
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
       if (root == null) return "";
       StringBuilder res = new StringBuilder();
       Queue<TreeNode> queue = new LinkedList<>();
       queue.offer(root);
       while (!queue.isEmpty()) {
           TreeNode cur = queue.poll();
           if (cur == null) {
               res.append("null ");
               continue;
           }
           res.append(cur.val + " ");
           queue.offer(cur.left);
           queue.offer(cur.right);
       }
       return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") return null;
        String[] str = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 1; i < str.length; i++) {
            TreeNode cur = queue.poll();
            if (!str[i].equals("null")) {
                cur.left = new TreeNode(Integer.parseInt(str[i]));
                queue.offer(cur.left);
            }
            if (!str[++i].equals("null")) {
                cur.right = new TreeNode(Integer.parseInt(str[i]));
                queue.offer(cur.right);
            }
        }
        return root;
    }
}
