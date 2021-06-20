package com.linked_list;

import com.linked_list.util.LinkedListUtil;
import com.linked_list.util.ListNode;

/**
 * @ClassName SwapPairs
 * @Author Jacky
 * @Description
 **/
public class SwapPairs {
    public static void main(String[] args) {
        SwapPairs o = new SwapPairs();
        int[] arr = {1, 2,3,4,5,6,7};
        ListNode linkedList = LinkedListUtil.createLinkedList(arr);
        linkedList = o.swapPairs(linkedList);
        System.out.println(linkedList);
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        ListNode pre = null;
        ListNode l1, l2;
        while (temp != null && temp.next != null) {
            l1 = temp;
            l2 = temp.next;
            if (pre == null) {
                head = l2;
                l1.next = l2.next;
                l2.next = l1;
                pre = l1;
                temp = l1.next;
                continue;
            }
            swap(pre, l1, l2);
            if (temp.next == null) {
                break;
            }
            pre = temp;
            temp = temp.next;
        }
        return head;
    }

    private void swap(ListNode pre, ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return;
        }
        l1.next = l2.next;
        l2.next = l1;
        pre.next = l2;
    }
}
