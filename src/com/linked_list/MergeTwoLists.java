package com.linked_list;

import com.linked_list.util.ListNode;

/**
 * @ClassName MergeTwoLists
 * @Author Jacky
 * @Description
 **/
public class MergeTwoLists {
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode cur = result;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1 == null){
            cur.next = l2;
        }else{
            cur.next = l1;
        }
        return result.next;
    }
}
