package com.tree;

import com.tree.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName InorderTraversal
 * @Author Jacky
 * @Description 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * <p>
 * 示例 1：
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * <p>
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 * <p>
 * 示例 4：
 * 输入：root = [1,2]
 * 输出：[2,1]
 * <p>
 * 示例 5：
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 **/
public class InorderTraversal {
    List<Integer> list = new ArrayList<>();

    // 递归实现
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        if (root.left != null) {
            inorderTraversal(root.left);
        }
        list.add(root.val);
        if (root.right != null) {
            inorderTraversal(root.right);
        }
        return list;
    }

    // 迭代实现
    public List<Integer> inorder(TreeNode root) {
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        pushLeftNode(root, stack);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            pushLeftNode(node.right, stack);
        }
        return list;
    }

    public void pushLeftNode(TreeNode node, Stack<TreeNode> stack) {
        TreeNode temp = node;
        while (temp != null) {
            stack.push(temp);
            temp = temp.left;
        }
    }
}
