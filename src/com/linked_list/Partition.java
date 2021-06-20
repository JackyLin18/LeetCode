package com.linked_list;

import com.linked_list.util.LinkedListUtil;
import com.linked_list.util.ListNode;

/**
 * @ClassName Partition
 * @Author Jacky
 * @Description
 **/
public class Partition {
    public static void main(String[] args) {
        Partition o = new Partition();
        int[] arr = {1, 4, 3, 2, 5, 2};
        ListNode head = LinkedListUtil.createLinkedList(arr);
        head = o.partition(head, 3);
        System.out.println(head);
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode l = null;
        ListNode r = null;
        ListNode lHead = null;
        ListNode rHead = null;
        ListNode temp = head;
        while (temp != null) {
            if (temp.val < x) {
                if (l == null) {
                    l = temp;
                    lHead = l;
                } else {
                    l.next = temp;
                    l = temp;
                }
            } else {
                if (r == null) {
                    r = temp;
                    rHead = r;
                } else {
                    r.next = temp;
                    r = temp;
                }
            }
            temp = temp.next;
        }
        if (r != null) {
            r.next = null;
        }
        if (l == null) {
            return rHead;
        } else {
            l.next = rHead;
        }
        return lHead;
    }
}
