package com.tree;

import com.tree.util.TreeNode;

/**
 * @ClassName DiameterOfBinaryTree
 * @Author Jacky
 * @Description
 **/
public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        int maxDiameter = 0;
        if (root == null) {
            return maxDiameter;
        }
        maxDiameter = 1 + depth(root.right) + depth(root.left);
        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);
        maxDiameter = Math.max(maxDiameter, leftDiameter);
        maxDiameter = Math.max(maxDiameter, rightDiameter);
        return maxDiameter - 1;
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(depth(root.left), depth(root.right));
    }
}
