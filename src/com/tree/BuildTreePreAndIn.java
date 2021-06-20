package com.tree;

import com.tree.util.TreeNode;

/**
 * @ClassName BuildTree
 * @Author Jacky
 * @Description
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 *
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 **/
public class BuildTreePreAndIn {
    public static void main(String[] args) {
        BuildTreePreAndIn o = new BuildTreePreAndIn();
        int[] preOrder = {1, 2};
        int[] inOrder = {1, 2};
        TreeNode treeNode = o.buildTree(preOrder, inOrder);
        System.out.println("前序遍历：");
        treeNode.preOrderList();
        System.out.println("中序遍历：");
        treeNode.inOrderList();
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;
        if (length == 0) {
            return null;
        }
        return build(preorder, 0, length,
                inorder, 0, length - 1);
    }

    public TreeNode build(int[] preOrder, int preStart, int preEnd,
                          int[] inOrder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preOrder[preStart]);
        for (int i = inStart, count = 0; i <= inEnd; i++, count++) {
            if (inOrder[i] == preOrder[preStart]) {
                root.left = build(preOrder, preStart + 1, preStart + count,
                        inOrder, inStart, i - 1);
                root.right = build(preOrder, preStart + count + 1, preEnd,
                        inOrder, i + 1, inEnd);
            }
        }
        return root;
    }
}
