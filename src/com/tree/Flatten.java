package com.tree;

import com.tree.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Flatten
 * @Author Jacky
 * @Description
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *     展开后的单链表应该同样使用 TreeNode ，
 *     其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 *     展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 * 示例 1：
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 *
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：root = [0]
 * 输出：[0]
 **/
public class Flatten {
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        pushNodeByPreOrder(root, queue);
        createLinkedList(queue);
    }

    public void pushNodeByPreOrder(TreeNode node, Queue<TreeNode> queue) {
        if (node == null) {
            return;
        }
        queue.offer(node);
        pushNodeByPreOrder(node.left, queue);
        pushNodeByPreOrder(node.right, queue);
    }

    public void createLinkedList(Queue<TreeNode> queue) {
        TreeNode temp = queue.poll();
        assert temp != null;
        temp.left = null;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            node.left = null;
            temp.right = node;
            temp = temp.right;
        }
    }
}
