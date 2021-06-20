package com;

import com.linked_list.util.ListNode;

import java.util.Stack;

/**
 * @ClassName RemoveNthFromEnd
 * @Author Jacky
 * @Description
 **/
public class RemoveNthFromEnd {
    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        for (int i = 0; i < n; i++) {
            temp = stack.pop();
        }
        if(stack.isEmpty()){
            head = head.next;
            return head;
        }
        ListNode pre = stack.pop();
        pre.next = temp.next;
        return head;
    }
}
