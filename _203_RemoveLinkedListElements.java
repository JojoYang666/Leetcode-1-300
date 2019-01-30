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
public class _203_RemoveLinkedListElements {
    /**
     * 203. Remove Linked List Elements
     * Remove all elements from a linked list of integers that have value val.

     Example
     Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
     Return: 1 --> 2 --> 3 --> 4 --> 5

     Credits:
     Special thanks to @mithmatt for adding this problem and creating all test cases.

     time : O(n);
     space : O(1);
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return dummy.next;
    }

    public static ListNode removeElements2(ListNode head, int val) {
        if (head == null) return head;
        ListNode p = head;
        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head.val == val ? head.next : head;
    }

    public static ListNode removeElements3(ListNode head, int val) {
        if (head == null) return head;
        head.next = removeElements3(head.next, val);
        return head.val == val ? head.next : head;
    }
}

