package com.tree.util;

/**
 * @ClassName TreeNode
 * @Author Jacky
 * @Description
 **/
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void addNode(TreeNode node) {
        if (node == null) {
            return;
        }
        // 判断该节点应该放在当前节点的左边还是右边
        if (this.val > node.val) {
            // 当前左边的节点为空，直接将该节点当成当前节点的左节点
            if (this.left == null) {
                this.left = node;
            } else {
                // 当前节点不为空，递归调用，寻找合适的位置
                this.left.addNode(node);
            }
        } else {
            // 当前右边的节点为空，直接将该节点当成当前节点的右节点
            if (this.right == null) {
                this.right = node;
            } else {
                // 当前节点不为空，递归调用，寻找合适的位置
                this.right.addNode(node);
            }
        }
    }

    public void inOrderList() {
        if (left != null) {
            left.inOrderList();
        }
        System.out.println(this);
        if (right != null) {
            right.inOrderList();
        }
    }

    public void preOrderList() {
        System.out.println(this);
        if (left != null) {
            left.preOrderList();
        }
        if (right != null) {
            right.preOrderList();
        }
    }

    public void postOrderList() {
        if (left != null) {
            left.postOrderList();
        }
        if (right != null) {
            right.postOrderList();
        }
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}
