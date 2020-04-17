package com.leetcode.链表_插入排序;


/**
 * @author Zereao
 * @version 2020/4/17 10:38
 */
class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode h = s.build(1, 1);
        System.out.println(s.print(h));
        ListNode h1 = s.insertionSortList(h);
        System.out.println(s.print(h1));
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        while (p.next != null) {
            if (p.next.val >= p.val) {
                p = p.next;
                continue;
            }
            ListNode tmp = p.next;
            p.next = p.next.next;
            if (tmp.val < head.val) {
                tmp.next = head;
                head = tmp;
            } else {
                ListNode q = head;
                while (q != p) {
                    if (q.val <= tmp.val && tmp.val <= q.next.val) {
                        tmp.next = q.next;
                        q.next = tmp;
                        break;
                    } else {
                        q = q.next;
                    }
                }
            }
        }
        return head;
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
