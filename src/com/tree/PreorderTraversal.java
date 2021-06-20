package com.tree;

import com.tree.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName PreorderTraversal
 * @Author Jacky
 * @Description
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 *
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 *
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 *
 * 示例 4：
 * 输入：root = [1,2]
 * 输出：[1,2]
 *
 * 示例 5：
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 **/
public class PreorderTraversal {
    List<Integer> list = new ArrayList<>();

    // 递归实现
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        list.add(root.val);
        if (root.left != null) {
            preorderTraversal(root.left);
        }
        if (root.right != null) {
            preorderTraversal(root.right);
        }
        return list;
    }

    // 迭代实现
    public List<Integer> preOrder(TreeNode root) {
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        pushLeftNode(root, stack);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            pushLeftNode(node.right, stack);
        }
        return list;
    }

    public void pushLeftNode(TreeNode node, Stack<TreeNode> stack) {
        TreeNode temp = node;
        while (temp != null) {
            list.add(temp.val);
            stack.push(temp);
            temp = temp.left;
        }
    }
}
