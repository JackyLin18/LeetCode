package com.linked_list;

import com.linked_list.util.LinkedListUtil;
import com.linked_list.util.ListNode;

import java.util.Stack;

/**
 * @ClassName ReverseBetween
 * @Author Jacky
 * @Description 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * 示例 1：
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * <p>
 * 示例 2：
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 **/
public class ReverseBetween {
    public static void main(String[] args) {
        ReverseBetween o = new ReverseBetween();
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = LinkedListUtil.createLinkedList(arr);
        head = o.reverseBetween(head, 1, 4);
        System.out.println(head);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }
        if (left == right) {
            return head;
        }
        ListNode lHeadPre = new ListNode();
        lHeadPre.next = head;
        ListNode rNode = head;
        for (int i = 1; i < right; i++) {
            if (i < left) {
                lHeadPre = lHeadPre.next;
            }
            rNode = rNode.next;
        }
        ListNode rHeadNext = rNode.next;
        ListNode temp = lHeadPre.next;
        Stack<ListNode> stack = new Stack<>();
        while (temp != rNode.next) {
            stack.push(temp);
            temp = temp.next;
        }
        temp = lHeadPre;
        while (!stack.isEmpty()) {
            temp.next = stack.pop();
            temp = temp.next;
        }
        temp.next = rHeadNext;
        if (temp == head) {
            head = lHeadPre.next;
        }
        return head;
    }
}
