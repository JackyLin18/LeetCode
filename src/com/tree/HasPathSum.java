package com.tree;

import com.tree.util.TreeNode;

/**
 * @ClassName HasPathSum
 * @Author Jacky
 * @Description 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，
 * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * 示例 1：
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：root = [1,2], targetSum = 0
 * 输出：false
 **/
public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return sum(root, targetSum, 0);
    }

    public boolean sum(TreeNode node, int target, int sum) {
        if (node == null) {
            return false;
        }
        int newSum = sum + node.val;
        if (newSum == target && isLeaf(node)) {
            return true;
        }
        return sum(node.left, target, newSum) || sum(node.right, target, newSum);
    }

    public boolean isLeaf(TreeNode node) {
        if (node == null) {
            return false;
        }
        return node.left == null && node.right == null;
    }
}
