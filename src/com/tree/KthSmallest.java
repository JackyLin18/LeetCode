package com.tree;

import com.tree.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName KthSmallest
 * @Author Jacky
 * @Description
 **/
public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        Queue<Integer> queue = new LinkedList<>();
        inOrderPush(queue, root);
        for (int i = 1; i < k; i++) {
            queue.poll();
        }
        assert !queue.isEmpty();
        return queue.poll();
    }

    public void inOrderPush(Queue<Integer> queue, TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderPush(queue, node.left);
        queue.offer(node.val);
        inOrderPush(queue, node.right);
    }
}
