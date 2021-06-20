package com.tree;

import com.tree.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName HasPathSum
 * @Author Jacky
 * @Description
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，
 * 找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点。
 *
 * 示例 1：
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 *
 * 示例 2：
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：[]
 *
 * 示例 3：
 * 输入：root = [1,2], targetSum = 0
 * 输出：[]
 **/
public class PathSum {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        findSum(root, new ArrayList<Integer>(), targetSum, 0);
        return result;
    }

    public void findSum(TreeNode node, List<Integer> list,
                        int target, int sum) {
        if (node == null) {
            return;
        }
        List<Integer> temp = new ArrayList<>(list);
        temp.add(node.val);
        int newSum = sum + node.val;
        if (newSum == target && isLeaf(node)) {
            result.add(temp);
        }
        findSum(node.left, temp, target, newSum);
        findSum(node.right, temp, target, newSum);
    }

    public boolean isLeaf(TreeNode node) {
        if (node == null) {
            return false;
        }
        return node.left == null && node.right == null;
    }
}
