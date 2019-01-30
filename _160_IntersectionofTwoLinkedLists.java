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
public class _160_IntersectionofTwoLinkedLists {
    /**
     * 160. Intersection of Two Linked Lists
     * For example, the following two linked lists:

     A:          a1 → a2
                         ↘
                         c1 → c2 → c3
                         ↗
     B:     b1 → b2 → b3
     begin to intersect at node c1.

     time : O(n);
     space : O(1);

     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int lenA = len(headA);
        int lenB = len(headB);
        if (lenA > lenB) {
            while (lenA != lenB) {
                headA = headA.next;
                lenA--;
            }
        } else {
            while (lenA != lenB) {
                headB = headB.next;
                lenB--;
            }
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    public int len(ListNode head) {
        int len = 1;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }

    /**
     *
     A:          a1 → a2
                         ↘
                         c1 → c2 → c3
                         ↗
     B:     b1 → b2 → b3
     begin to intersect at node c1.

     A : a1 → a2 -> c1 → c2 → c3 -> b1 → b2 → b3 -> c1 → c2 → c3
     B : b1 → b2 → b3 -> c1 → c2 → c3 -> a1 → a2 -> c1 → c2 → c3

     time : O(m + n);
     space : O(1);

     * @param headA
     * @param headB
     * @return
     */

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}
