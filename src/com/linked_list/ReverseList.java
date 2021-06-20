package com.linked_list;

import com.linked_list.util.ListNode;

/**
 * @ClassName ReverseList
 * @Author Jacky
 * @Description
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 **/
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = new ListNode();
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur;
            head = cur.next;
            cur = head;
            temp.next = result.next;
            result.next = temp;
        }
        return result.next;
    }
}
