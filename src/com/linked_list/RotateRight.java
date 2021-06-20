package com.linked_list;

import com.linked_list.util.LinkedListUtil;
import com.linked_list.util.ListNode;

import java.util.Stack;

/**
 * @ClassName RotateRight
 * @Author Jacky
 * @Description
 **/
public class RotateRight {
    public static void main(String[] args) {
        RotateRight o = new RotateRight();
        int[] arr = {0, 1, 2};
        ListNode head = LinkedListUtil.createLinkedList(arr);
        head = o.rotateRight(head, 4);
        System.out.println(head);
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int length = 0;
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        length = stack.size();
        k = k % length;
        while (k >= 0) {
            ListNode node = stack.pop();
            if (k == 0) {
                node.next = null;
                break;
            }
            node.next = head;
            head = node;
            k--;
        }
        return head;
    }
}
