package com.tree;

import com.tree.util.TreeNode;

import java.util.Stack;

/**
 * @ClassName MinDiffInBST
 * @Author Jacky
 * @Description 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * <p>
 * 示例 1：
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 * <p>
 * 示例 2：
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 **/
public class MinDiffInBST {
    public int minDiffInBST(TreeNode root) {
        Stack<Integer> stack = new Stack<>();
        inOrder(root, stack);
        int min = stack.pop() - stack.peek();
        while (stack.size() >= 2) {
            min = Math.min(stack.pop() - stack.peek(), min);
        }
        return min;
    }

    public void inOrder(TreeNode root, Stack<Integer> stack) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inOrder(root.left, stack);
        }
        stack.push(root.val);
        if (root.right != null) {
            inOrder(root.right, stack);
        }
    }
}
