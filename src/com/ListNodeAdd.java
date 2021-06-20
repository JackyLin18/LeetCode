package com;

import com.linked_list.util.ListNode;

/**
 * @ClassName ListNodeAdd
 * @Author Jacky
 **/
public class ListNodeAdd {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        l2.next.next.next = new ListNode(9);
        System.out.println(new ListNodeAdd().addTwoNumbers(l1,l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode tail = null;
        int temp = 0;
        while (l1 != null || l2 != null) {
            int n1 = (l1 != null ? l1.val : 0);
            int n2 = (l2 != null ? l2.val : 0);
            int sum = n1 + n2 + temp;
            temp = (n1 + n2 + temp) / 10;
            if (result == null) {
                result = new ListNode(sum % 10);
                tail = result;
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
        }
        if (temp > 0) {
            tail.next = new ListNode(temp);
        }
        return result;
    }
}
