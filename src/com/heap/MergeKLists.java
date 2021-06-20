package com.heap;

import com.linked_list.util.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName MergeKLists
 * @Author Jacky
 * @Description
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 *
 * 示例 2：
 * 输入：lists = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：lists = [[]]
 * 输出：[]
 **/
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(
                Comparator.comparingInt(x -> x.val));
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }
        ListNode head = new ListNode();
        ListNode temp = head;
        while (!queue.isEmpty()) {
            ListNode minNode = queue.poll();
            temp.next = minNode;
            temp = temp.next;
            if (minNode.next != null) {
                queue.offer(minNode.next);
            }
        }
        return head.next;
    }

}
