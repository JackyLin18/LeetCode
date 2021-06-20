package com.tree;

import com.tree.util.TreeNode;

/**
 * @ClassName LowestCommonAncestor
 * @Author Jacky
 * @Description
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 示例 1：
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 *
 * 示例 2：
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 *
 * 示例 3：
 * 输入：root = [1,2], p = 1, q = 2
 * 输出：1
 **/
public class LowestCommonAncestor2 {
    public TreeNode lowestCommonAncestor(TreeNode root,
                                         TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root;
        while (true) {
            boolean flag = false;
            if (containsNode(temp.left, p) && containsNode(temp.left, q)) {
                flag = true;
                temp = temp.left;
            }
            if (containsNode(temp.right, p) && containsNode(temp.right, q)) {
                flag = true;
                temp = temp.right;
            }
            if(!flag){
                return temp;
            }
        }
    }

    public boolean containsNode(TreeNode parent, TreeNode node) {
        if (parent == null || node == null) {
            return false;
        }
        if (parent.val == node.val) {
            return true;
        }
        if (parent.left != null && parent.left.val == node.val) {
            return true;
        }
        if (parent.right != null && parent.right.val == node.val) {
            return true;
        }
        return containsNode(parent.left, node) || containsNode(parent.right, node);
    }
}
