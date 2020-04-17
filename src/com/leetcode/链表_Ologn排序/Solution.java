package com.leetcode.链表_Ologn排序;

/**
 * @author Zereao
 * @version 2020/4/16 18:36
 */
class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = s.build(1, 5, 2, 6, 6, 7, 3, 9);
        System.out.println(s.print(head));
        ListNode newHead = s.sortList(head);
        System.out.println(s.print(newHead));
    }

    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode end = head;
        while (end.next != null) {
            end = end.next;
        }
        return this.sortList(head, end);
    }

    private ListNode sortList(ListNode start, ListNode end) {
        ListNode mid = this.getMiddleNode(start, end);
        if (mid == null) {
            return start;
        }
        this.sortList(start, mid);
        this.sortList(mid.next, end);
        return this.merge(start, end);
    }


    private ListNode getMiddleNode(ListNode start, ListNode end) {
        ListNode fast = start, slow = start;
        while (fast.next != null && fast.next != end && fast.next.next != end) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return fast == slow ? null : slow;
    }

    private ListNode merge(ListNode start, ListNode end) {
        ListNode mid = this.getMiddleNode(start, end);
        if (mid == null) {
            return start;
        }
        ListNode leftStart = start, leftEnd = mid;
        ListNode rightStart = mid.next, rightEnd = end;
        ListNode tmp = new ListNode(0);
        ListNode head = tmp;
        while (leftStart != leftEnd && rightStart != rightEnd) {
            ListNode minNode = leftStart.val < rightStart.val ? leftStart : rightStart;
            tmp.next = new ListNode(minNode.val);
            tmp = tmp.next;
            leftStart = leftStart.next;
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
