package com.tree;

import com.tree.util.TreeNode;

/**
 * @ClassName IsSymmetric
 * @Author Jacky
 * @Description 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 但是 [1,2,2,null,3,null,3] 则不是镜像对称的:
 **/
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return compare(root.left, root.right);
    }

    public boolean compare(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        if (!compare(p.left, q.right)) {
            return false;
        }
        if (!compare(p.right, q.left)) {
            return false;
        }
        return true;
    }
}
