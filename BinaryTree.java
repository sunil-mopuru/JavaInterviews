package com.javastack.datastructures.binarytree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree
{
   public static List<Integer> result = new ArrayList();

    public static void main(String[] args) {

        // Manual construction of a binary tree
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(50);
        root.left.right.left = new TreeNode(70);
        root.right.right = new TreeNode(60);

        // Test pre-order traversal
        System.out.println("Pre-order traversal:");
        result.clear();
        dfsPreOrder(root);
        System.out.println(result); // [10, 20, 40, 50, 70, 30, 60]

        // Test in-order traversal
        System.out.println("In-order traversal:");
        result.clear();
        dfsInOrder(root);
        System.out.println(result); // [20, 40, 50, 70, 10, 30, 60]

        // Test post-order traversal
        System.out.println("Post-order traversal:");
        result.clear();
        dfsPostOrder(root);
        System.out.println(result); // [20, 40, 50, 70, 30, 60, 10]
    }

    public static void dfsPreOrder(TreeNode root) {
        if(root==null) return;
        result.add(root.val); // pre-order
        dfsPreOrder(root.left);
        dfsPreOrder(root.right);
    }
    public static void dfsInOrder(TreeNode root)
    {
        if(root==null) return;
        dfsPreOrder(root.left);
        result.add(root.val); // In-order
        dfsPreOrder(root.right);
    }
    public static void dfsPostOrder(TreeNode root)
    {
        if(root==null) return;
        dfsPreOrder(root.left);
        dfsPreOrder(root.right);
        result.add(root.val); // Post-order
    }
}
