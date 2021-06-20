package com.linked_list;

import com.linked_list.util.ListNode;

import java.util.Stack;

/**
 * @ClassName IsPalindrome
 * @Author Jacky
 * @Description
 **/
public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        temp = head;
        while (temp != null && !stack.isEmpty()) {
            if (temp.val != stack.pop().val) {
                return false;
            }
            temp = temp.next;
        }
        return true;
    }
}
