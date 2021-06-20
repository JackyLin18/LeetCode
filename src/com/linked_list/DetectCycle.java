package com.linked_list;

import com.linked_list.util.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName DetectCycle
 * @Author Jacky
 * @Description
 **/
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        ListNode temp = head;
        while (temp != null) {
            if (set.add(temp)) {
                temp = temp.next;
            } else {
                return temp;
            }
        }
        return null;
    }
}
