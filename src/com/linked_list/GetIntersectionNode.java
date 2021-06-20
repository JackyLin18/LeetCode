package com.linked_list;

import com.linked_list.util.ListNode;

/**
 * @ClassName GetIntersectionNode
 * @Author Jacky
 * @Description 编写一个程序，找到两个单链表相交的起始节点。
 * <p>
 * 输入：intersectVal = 8, listA = [4,1,8,4,5],
 * listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
 * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * <p>
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
 * 由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 解释：这两个链表不相交，因此返回 null。
 **/
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode aTemp = headA;
        ListNode bTemp = headB;
        boolean aFlag = false;
        boolean bFlag = false;
        while (true) {
            if (aTemp == bTemp) {
                return aTemp;
            }
            if (aTemp != null) {
                aTemp = aTemp.next;
            } else {
                if (!aFlag) {
                    aTemp = headB;
                    aFlag = true;
                } else {
                    return null;
                }
            }
            if (bTemp != null) {
                bTemp = bTemp.next;
            } else {
                if (!bFlag) {
                    bTemp = headA;
                    bFlag = true;
                } else {
                    return null;
                }
            }
        }
    }
}
