package com.tree;

import com.tree.util.TreeNode;

/**
 * @ClassName BuildTreeInAndPost
 * @Author Jacky
 * @Description
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 *
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 **/
public class BuildTreeInAndPost {
    public static void main(String[] args) {
        BuildTreeInAndPost o = new BuildTreeInAndPost();
        int[] inorder = {6, 4, 2, 7, 5, 1, 3};
        int[] postorder = {6, 4, 7, 5, 2, 3, 1};
        TreeNode root = o.buildTree(inorder, postorder);
        System.out.println("中序遍历：");
        root.inOrderList();
        System.out.println("后序遍历：");
        root.postOrderList();
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int length = inorder.length;
        if (length == 0) {
            return null;
        }
        return build(inorder, 0, length - 1,
                postorder, 0, length - 1);
    }

    public TreeNode build(int[] inorder, int inStart, int inEnd,
                          int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        for (int i = inStart, count = 0; i <= inEnd; i++, count++) {
            if (inorder[i] == postorder[postEnd]) {
                root.left = build(inorder, inStart, i - 1,
                        postorder, postStart, postStart + count - 1);
                root.right = build(inorder, i + 1, inEnd,
                        postorder, postStart + count, postEnd - 1);
            }
        }
        return root;
    }
}
