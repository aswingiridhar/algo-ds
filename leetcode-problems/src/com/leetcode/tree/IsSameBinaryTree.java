package com.leetcode.tree;

/**
 * 
 * Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 * 
 * Example 1:

Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true

Example 2:

Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false
Example 3:

Input:     1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

Output: false

 * @author agiridhar
 *
 */
public class IsSameBinaryTree {
	
	public static void main(String[]args) {
		
		TreeNode p = createBinaryTree1();
		TreeNode q = createBinaryTree1();
		
		System.out.println("Is Same Binary Tree: " + isSameTree(p, q)); 
		
		TreeNode p1 = createBinaryTree1();
		TreeNode q1 = createBinaryTree2();
		
		System.out.println("Is Same Binary Tree: " + isSameTree(p1, q1)); 
	}
	
	public static TreeNode createBinaryTree1() {
		TreeNode rootNode = new TreeNode(1);
		TreeNode leftRootNode = new TreeNode(2);
		TreeNode rightRootNode = new TreeNode(3);
		
		
		rootNode.left=leftRootNode;
		rootNode.right=rightRootNode;
 
		return rootNode;
	}
	
	public static TreeNode createBinaryTree2() {
		TreeNode rootNode = new TreeNode(1);
		TreeNode leftRootNode = new TreeNode(2);
		
		
		rootNode.left=leftRootNode;
 
		return rootNode;
	}
	
	public static boolean isSameTree(TreeNode p, TreeNode q) {
        
		if (p == null && q == null) return true;
		if (p == null || q == null) return false;
		
		if (p.data == q.data) {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}
		
		return false;
    }

}
