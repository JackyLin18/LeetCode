package com.tree;

import com.linked_list.util.LinkedListUtil;
import com.linked_list.util.ListNode;
import com.tree.util.TreeNode;

/**
 * @ClassName SortedListToBST
 * @Author Jacky
 * @Description
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 **/
public class SortedListToBST {
    public static void main(String[] args) {
        SortedListToBST o = new SortedListToBST();
        int[] arr = {-10, -3, 0, 5, 9};
        ListNode head = LinkedListUtil.createLinkedList(arr);
        TreeNode root = o.sortedListToBST(head);
        root.inOrderList();
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = new ListNode();
        pre.next = slow;
        while (fast != null && fast.next != null) {
            pre = pre.next;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
}
