package leetcode_1To300;

import java.util.HashMap;

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
public class _138_CopyListwithRandomPointer {
    /**
     * 138. Copy List with Random Pointer
     * A linked list is given such that each node contains an additional random pointer which could
     * point to any node in the list or null.

     Return a deep copy of the list

     time : O(n);
     space : O(n);
     * @param head
     * @return
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cur = head;
        while (cur != null) {
            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    /**

     1->1'->2->2'->3->3'->4->4'

     1'->2'->3'->4'
     * @param head
     * @return
     */
    public RandomListNode copyRandomList2(RandomListNode head) {
        RandomListNode cur = head;
        RandomListNode next;
        //next copy
        while (cur != null) {
            next = cur.next;
            RandomListNode copy = new RandomListNode(cur.label);
            cur.next = copy;
            copy.next = next;
            cur = next;
        }
        cur = head;
        //random copy
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        cur = head;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode copy;
        RandomListNode copycur = dummy;

        while (cur != null) {
            next = cur.next.next;
            copy = cur.next;
            copycur.next = copy;
            copycur = copy;
            cur.next = next;
            cur = next;
        }
        return dummy.next;
    }

    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    }
}
