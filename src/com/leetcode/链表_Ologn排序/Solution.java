package com.leetcode.链表_Ologn排序;

/**
 * @author Zereao
 * @version 2020/4/16 18:36
 */
class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = s.build(2, 1);
        System.out.println(s.print(head));
        ListNode newHead = s.sortList(head);
        System.out.println(s.print(newHead));
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = this.getMiddleNode(head);
        ListNode rightStart = mid.next;
        mid.next = null;
        ListNode leftHead = this.sortList(head);
        ListNode rightHead = this.sortList(rightStart);
        return this.merge(leftHead, rightHead);
    }

    private ListNode getMiddleNode(ListNode start) {
        ListNode fast = start, slow = start;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode merge(ListNode leftHead, ListNode rightHead) {
        if (leftHead == rightHead) {
            return leftHead;
        }
        ListNode leftStart = leftHead;
        ListNode rightStart = rightHead;
        ListNode tmp = new ListNode(0);
        ListNode head = tmp;
        while (leftStart != null && rightStart != null) {
            int minVal;
            if (leftStart.val <= rightStart.val) {
                minVal = leftStart.val;
                leftStart = leftStart.next;
            } else {
                minVal = rightStart.val;
                rightStart = rightStart.next;
            }
            tmp.next = new ListNode(minVal);
            tmp = tmp.next;
        }
        while (leftStart != null) {
            tmp.next = new ListNode(leftStart.val);
            tmp = tmp.next;
            leftStart = leftStart.next;
        }
        while (rightStart != null) {
            tmp.next = new ListNode(rightStart.val);
            tmp = tmp.next;
            rightStart = rightStart.next;
        }
        return head.next;
    }

    private ListNode build(int... vals) {
        if (vals == null || vals.length <= 0) {
            return null;
        }
        ListNode head = new ListNode(vals[0]);
        ListNode p = head;
        for (int i = 1; i < vals.length; i++) {
            p.next = new ListNode(vals[i]);
            p = p.next;
        }
        return head;
    }

    private String print(ListNode head) {
        if (head == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder().append(head.val);
        head = head.next;
        while (head != null) {
            sb.append(" -> ").append(head.val);
            head = head.next;
        }
        return sb.toString();
    }
}
