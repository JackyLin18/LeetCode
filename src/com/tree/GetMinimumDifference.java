package com.tree;

import com.tree.util.TreeNode;

import java.util.Stack;

/**
 * @ClassName GetMinimumDifference
 * @Author Jacky
 * @Description
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *
 * 示例：
 * 输入：
 *    1
 *     \
 *      3
 *     /
 *    2
 * 输出：
 * 1
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 **/
public class GetMinimumDifference {
    public int getMinimumDifference(TreeNode root) {
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
