package com.tree;

import com.tree.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName IncreasingBST
 * @Author Jacky
 * @Description 给你一棵二叉搜索树，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，
 * 使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 * <p>
 * 示例 1：
 * 输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * <p>
 * 示例 2：
 * 输入：root = [5,1,7]
 * 输出：[1,null,5,null,7]
 **/
public class IncreasingBST {
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode result = new TreeNode();
        Queue<TreeNode> queue = new LinkedList<>();
        pushNode(queue, root);
        TreeNode temp, poll;
        temp = result;
        while (!queue.isEmpty()) {
            poll = queue.poll();
            poll.left = null;
            temp.right = poll;
            temp = poll;
        }
        return result.right;
    }

    public void pushNode(Queue<TreeNode> stack, TreeNode node) {
        if (node.left != null) {
            pushNode(stack, node.left);
        }
        stack.offer(node);
        if (node.right != null) {
            pushNode(stack, node.right);
        }
    }
}
