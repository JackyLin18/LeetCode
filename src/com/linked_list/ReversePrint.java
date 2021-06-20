package com.linked_list;

import com.linked_list.util.LinkedListUtil;
import com.linked_list.util.ListNode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @ClassName ReversePrint
 * @Author Jacky
 * @Description 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 **/
public class ReversePrint {
    public static void main(String[] args) {
        ReversePrint o = new ReversePrint();
        int[] arr = {};
        ListNode head = LinkedListUtil.createLinkedList(arr);
        int[] ans = o.reversePrint(head);
        System.out.println(Arrays.toString(ans));
    }

    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = stack.pop().val;
        }
        return result;
    }
}
