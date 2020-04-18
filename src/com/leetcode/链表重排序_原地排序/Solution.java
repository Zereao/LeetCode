package com.leetcode.链表重排序_原地排序;

import com.leetcode.common.ListNode;
import com.leetcode.common.Utils;

/**
 * @author Zereao
 * @version 2020/4/18 21:00
 */
class Solution {

    public static void main(String[] args) {
        ListNode head = Utils.build(1, 4, 2, 3);
        Solution s = new Solution();
        s.reorderList(head);
        System.out.println(Utils.print(head));
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        // 不管链表的结点数是 基数还是偶数，都只需要迭代到 长度的一半 即可
        ListNode p = head;
        while (p.next != null) {
            ListNode nodeBeforeTail = this.getNodeBeforeTail(p);
            if (p == nodeBeforeTail) {
                break;
            }
            ListNode tail = nodeBeforeTail.next;
            nodeBeforeTail.next = null;
            tail.next = p.next;
            p.next = tail;
            p = tail.next;
        }
    }

    private ListNode getNodeBeforeTail(ListNode node) {
        while (node.next.next != null) {
            node = node.next;
        }
        return node;
    }
}
