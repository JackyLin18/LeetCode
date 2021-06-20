package com.linked_list;

import com.linked_list.util.ListNode;

import java.util.Stack;

/**
 * @ClassName ReorderList
 * @Author Jacky
 * @Description 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例 1:
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * <p>
 * 示例 2:
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 **/
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = slow;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode temp;
        if (fast == null) {
            temp = slow;
        } else {
            temp = slow.next;
        }
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        temp = head;
        ListNode next;
        while (temp != slow) {
            next = temp.next;
            temp.next = stack.pop();
            temp = temp.next;
            temp.next = next;
            temp = next;
        }
        slow.next = null;
    }
}
