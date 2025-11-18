package com.javastack.datastructures.binarytree;

import java.util.ArrayList;
import java.util.List;

public class HeightOfBinaryTree {

    public static void main(String[] args) {
        // Manual construction of a binary tree
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(50);
        root.left.right.left = new TreeNode(70);
        root.right.right = new TreeNode(60);

        System.out.println("Height of the tree is: " + height(root));
    }

    public static int dfsPostOrder(TreeNode root)
    {
        List<Integer> result = new ArrayList();
        if(root==null) return 0;
        int leftHeight = dfsPostOrder(root.left);
        int rightHeight = dfsPostOrder(root.right);
        return Math.max(leftHeight,rightHeight) +1;
    }

    public static int height(TreeNode root)
    {
        return dfsPostOrder(root);
    }

}
