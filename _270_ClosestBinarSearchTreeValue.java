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
public class _270_ClosestBinarSearchTreeValue {

    /**
     * 270. Closest Binary Search Tree Value
     * @param root
     * @param target
     * @return
     */

    // time : O(logn) space : O(1)
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        while (root != null) {
            if (Math.abs(target - root.val) < Math.abs(target - res)) {
                res = root.val;
            }
            root = root.val > target ? root.left : root.right;
        }
        return res;
    }


    // time : O(logn) space : O(n)
    public int closestValue2(TreeNode root, double target) {
        return helper(root, target, root.val);
    }

    public int helper(TreeNode root, double target, int val) {
            if (root == null) return val;
            if (Math.abs(root.val - target) < Math.abs(val - target)) {
                val = root.val;
            }
            if (root.val < target) {
                val = helper(root.right, target, val);
            } else if (root.val > target) {
                val = helper(root.left, target, val);
            }
            return val;
    }
}
