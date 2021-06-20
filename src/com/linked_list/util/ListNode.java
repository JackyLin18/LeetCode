package com.linked_list.util;

/**
 * @ClassName ListNode
 * @Author Jacky
 **/
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        ListNode temp = this;
        result.append("ListNode:{");
        while (temp != null) {
            result.append(temp.val);
            temp = temp.next;
            if (temp != null) {
                result.append(",");
            }
        }
        result.append("}");
        return result.toString();
    }
}
