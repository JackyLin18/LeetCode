package com.linked_list.util;

/**
 * @ClassName LinkedListUtil
 * @Author Jacky
 * @Description
 **/
public class LinkedListUtil {
    public static ListNode createLinkedList(int[] arr) {
        ListNode head = new ListNode();
        ListNode cur = head;
        for (int i = 0; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head.next;
    }
}
