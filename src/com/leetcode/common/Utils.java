package com.leetcode.common;

/**
 * @author Zereao
 * @version 2020/4/18 20:54
 */
public class Utils {
    public static ListNode build(int... values) {
        if (values == null || values.length <= 0) {
            return null;
        }
        ListNode head = new ListNode(values[0]);
        ListNode p = head;
        for (int i = 1; i < values.length; i++) {
            p.next = new ListNode(values[i]);
            p = p.next;
        }
        return head;
    }

    public static String print(ListNode head) {
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
