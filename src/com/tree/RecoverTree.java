package com.tree;

import com.tree.util.TreeNode;

import java.util.Stack;

/**
 * @ClassName RecoverTree
 * @Author Jacky
 * @Description
 * 给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。
 * 请在不改变其结构的情况下，恢复这棵树。
 * 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？
 *
 * 示例 1：
 * 输入：root = [1,3,null,null,2]
 * 输出：[3,1,null,null,2]
 * 解释：3 不能是 1 左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
 *
 * 示例 2：
 * 输入：root = [3,1,4,null,null,2]
 * 输出：[2,1,4,null,null,3]
 * 解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。
 **/
public class RecoverTree {
    TreeNode p;
    TreeNode q;

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        inOrder(stack, root);
        swapNode(p, q);
    }

    public void inOrder(Stack<TreeNode> stack, TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(stack, node.left);
        if (!stack.isEmpty() && stack.peek().val > node.val) {
            if (p == null) {
                p = stack.peek();
            } else {
                q = node;
            }
        }
        stack.push(node);
        inOrder(stack, node.right);
    }

    public void swapNode(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return;
        }
        int temp = p.val;
        p.val = q.val;
        q.val = temp;
    }
}
