package com.tree;

import com.tree.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BinaryTreePaths
 * @Author Jacky
 * @Description
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 输入:
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 * 输出: ["1->2->5", "1->3"]
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 **/
public class BinaryTreePaths {
    List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        appendPath(new StringBuilder(), root);
        return result;
    }

    public void appendPath(StringBuilder stringBuilder, TreeNode node) {
        StringBuilder temp = new StringBuilder(stringBuilder);
        if (node == null) {
            return;
        }
        temp.append(node.val).append("->");
        if (isLeaf(node)) {
            result.add(temp.toString().substring(0,temp.length()-2));
        }
        appendPath(temp, node.left);
        appendPath(temp, node.right);
    }

    public boolean isLeaf(TreeNode node) {
        if (node == null) {
            return false;
        }
        return node.left == null && node.right == null;
    }
}
