package com.leetcode.链表是否成环判断;

import com.leetcode.common.ListNode;

/**
 * @author Zereao
 * @version 2020/4/19 10:23
 */
class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
