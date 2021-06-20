package com.linked_list;

import com.linked_list.util.LinkedListUtil;
import com.linked_list.util.ListNode;

/**
 * @ClassName SplitListToParts
 * @Author Jacky
 * @Description
 **/
public class SplitListToParts {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        SplitListToParts o = new SplitListToParts();
        ListNode root = LinkedListUtil.createLinkedList(arr);
        o.splitListToParts(root,3);
    }

    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] result = new ListNode[k];
        int length = findLength(root);
        int size = length / k;
        int leave = length % k;
        ListNode start = root;
        for (int i = 0; i < k; i++) {
            ListNode temp;
            if (i < leave) {
                temp = findKThNode(start, size + 1);
            } else {
                temp = findKThNode(start, size);
            }
            System.out.println("第" + i + "次:" + temp);
            if (temp == null) {
                break;
            }
            start = temp.next;
            temp.next = null;
            result[i] = temp;
        }
        return result;
    }

    public int findLength(ListNode root) {
        ListNode temp = root;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public ListNode findKThNode(ListNode node, int k) {
        int count = 1;
        while (count != k && node != null) {
            count++;
            node = node.next;
        }
        return node;
    }
}
