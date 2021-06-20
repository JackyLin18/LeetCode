package com.tree;

import com.tree.util.TreeNode;

/**
 * @ClassName IsValidBST
 * @Author Jacky
 * @Description
 **/
public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isMaxInList(root)) {
            return false;
        }
        if (!isMinInList(root)) {
            return false;
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }

    public boolean isMaxInList(TreeNode root) {
        boolean flag = true;
        if (root == null) {
            return true;
        }
        while (root.left != null) {
            if (root.left.val >= root.val) {
                flag = false;
                break;
            }
            root = root.left;
        }
        return flag;
    }

    public boolean isMinInList(TreeNode root) {
        boolean flag = true;
        if (root == null) {
            return true;
        }
        while (root.right != null) {
            if (root.right.val <= root.val) {
                flag = false;
                break;
            }
            root = root.right;
        }
        return flag;
    }
}
