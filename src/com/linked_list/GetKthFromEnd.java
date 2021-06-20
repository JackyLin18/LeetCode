package com.linked_list;

import com.linked_list.util.ListNode;

import java.util.Stack;

/**
 * @ClassName GetKthFromEnd
 * @Author Jacky
 * @Description 输入一个链表，输出该链表中倒数第k个节点。
 * 为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * <p>
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。
 * 这个链表的倒数第 3 个节点是值为 4 的节点。
 * <p>
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * 返回链表 4->5.
 **/
public class GetKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        ListNode result = null;
        for (int i = 0; i < k; i++) {
            result = stack.pop();
        }
        return result;
    }

    public ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode fast = head;
        ListNode late = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            late = late.next;
        }
        return late;
    }
}
