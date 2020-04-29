package com.leetcode.链表_插入排序;


import com.leetcode.common.ListNode;
import com.leetcode.common.Utils;

/**
 * @author Zereao
 * @version 2020/4/17 10:38
 */
class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode h = Utils.buildList(1, 1);
        System.out.println(Utils.print(h));
        ListNode h1 = s.insertionSortList(h);
        System.out.println(Utils.print(h1));
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

}
