package com.leetcode.链表环的入口结点;

import com.leetcode.common.ListNode;
import com.leetcode.common.Utils;

/**
 * 解析参考：https://blog.csdn.net/Zereao/article/details/100576173
 *
 * @author Zereao
 * @version 2020/4/18 23:10
 */
class Solution {

    public static void main(String[] args) {
        ListNode head = Utils.buildList(1, 2);
        head.next.next = head;
        Solution s = new Solution();
        ListNode m = s.getMeetNode(head);
        System.out.println(m.val);
        ListNode i = s.detectCycle(head);
        System.out.println(i.val);
    }

    public ListNode detectCycle(ListNode head) {
        ListNode meetNode = this.getMeetNode(head);
        if (meetNode == null || meetNode == head) {
            return meetNode;
        }
        ListNode p1 = head, p2 = meetNode;
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
            if (p1 == p2) {
                break;
            }
        }
        return p1;
    }

    private ListNode getMeetNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // 这里随便返回 fast 或者 slow 都可以
                return slow;
            }
        }
        return null;
    }
}
