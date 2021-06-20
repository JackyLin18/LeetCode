package com.linked_list;

import com.linked_list.util.LinkedListUtil;
import com.linked_list.util.ListNode;

/**
 * @ClassName RemoveElements
 * @Author Jacky
 * @Description
 **/
public class RemoveElements {
    public static void main(String[] args) {
        RemoveElements o = new RemoveElements();
        int[] arr = {1, 2, 2, 1};
        ListNode head = LinkedListUtil.createLinkedList(arr);
        System.out.println("删除前：" + head);
        head = o.removeElements(head, 2);
        System.out.println("删除后：" + head);
    }

    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            }else{
                temp = temp.next;
            }
        }
        return head;
    }
}
