package com.linked_list;

import com.linked_list.util.LinkedListUtil;
import com.linked_list.util.ListNode;

/**
 * @ClassName DeleteDuplicates
 * @Author Jacky
 * @Description
 **/
public class DeleteDuplicates {
    public static void main(String[] args) {
        DeleteDuplicates o = new DeleteDuplicates();
        int[] arr = {1, 1, 2, 3, 3};
        ListNode head = LinkedListUtil.createLinkedList(arr);
        head = o.deleteDuplicates(head);
        System.out.println(head);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        while (temp.next != null) {
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newNode = new ListNode();
        newNode.next = head;
        ListNode pre = newNode;
        ListNode cur = head;
        boolean flag = false;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                flag = true;
            } else {
                if (flag) {
                    pre.next = cur.next;
                    flag = false;
                } else {
                    pre = cur;
                }
            }
            cur = cur.next;
        }
        if(flag){
            pre.next = null;
        }
        return newNode.next;
    }
}
