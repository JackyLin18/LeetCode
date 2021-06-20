package com.linked_list;

import com.linked_list.util.ListNode;

/**
 * @ClassName OddEvenList
 * @Author Jacky
 * @Description 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
 * 请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * <p>
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * <p>
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * <p>
 * 示例 2:
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 **/
public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode l = head;
        ListNode r = head.next;
        ListNode lHead = l;
        ListNode rHead = r;
        while (l.next != null && r.next != null) {
            l.next = r.next;
            l = l.next;
            r.next = l.next;
            r = r.next;
            if (r == null) {
                break;
            }
        }
        l.next = rHead;
        return lHead;
    }
}
