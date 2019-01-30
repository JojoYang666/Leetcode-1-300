package leetcode_1To300;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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
public class _272_ClosestBinarySearchTreeValueII {

    /**
     * 272. Closest Binary Search Tree Value II
     * Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.

     Note:
     Given target value is a floating point.
     You may assume k is always valid, that is: k ≤ total nodes.
     You are guaranteed to have only one unique set of k values in the BST that are closest to the target.

          8
         / \
        3  9
      /  \
     2   7

     target : 6     k = 2

     StackTest : pred : 3
     StackTest : succ : 9

      3 1

     res : 7 8

     * @param root
     * @param target
     * @param k
     * @return
     */

    // time : O(n) space : O(n)
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> res = new LinkedList<>();
        helper(res, root, target, k);
        return res;
    }

    private void helper(LinkedList<Integer> res, TreeNode root, double target, int k) {
        if (root == null) return;
        helper(res, root.left, target, k);
        if (res.size() == k) {
            if (Math.abs(target - root.val) < Math.abs(target - res.peekFirst())) {
                res.removeFirst();
            } else return;
        }
        res.add(root.val);
        helper(res, root.right, target, k);
    }

    // time : O(klogn)
    public List<Integer> closestKValues2(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> pred = new Stack<>();
        Stack<TreeNode> succ = new Stack<>();
        iniPred(root, target, pred);
        iniSucc(root, target, succ);
        if (!pred.isEmpty() && !succ.isEmpty() && succ.peek().val == pred.peek().val) {
            helper(pred, false);
        }
        while (k-- > 0) {
            if (succ.isEmpty()) {
                res.add(helper(pred, false));
            } else if (pred.isEmpty()) {
                res.add(helper(succ, true));
            } else {
                double succDiff = Math.abs((double)succ.peek().val - target);
                double predDiff = Math.abs((double)pred.peek().val - target);
                if (succDiff < predDiff) {
                    res.add(helper(succ, true));
                } else {
                    res.add(helper(pred, false));
                }
            }
        }
        return res;
    }

    private void iniSucc(TreeNode root, double target, Stack<TreeNode> succ) {
        while (root != null) {
            if (root.val == target) {
                succ.push(root);
                break;
            } else if (root.val > target) {
                succ.push(root);
                root = root.left;
            } else {
                root = root.right;
            }
        }
    }

    private void iniPred(TreeNode root, double target, Stack<TreeNode> pred) {
        while (root != null) {
            if (root.val == target) {
                pred.push(root);
                break;
            } else if (root.val < target) {
                pred.push(root);
                root = root.right;
            } else {
                root = root.left;
            }
        }
    }

    private int helper(Stack<TreeNode> stack, boolean isSucc) {
        TreeNode cur = stack.pop();
        int res = cur.val;

        if (isSucc) cur = cur.right;
        else cur = cur.left;

        while (cur != null) {
            stack.push(cur);
            if (isSucc) cur = cur.left;
            else cur = cur.right;
        }
        return res;
    }
}
