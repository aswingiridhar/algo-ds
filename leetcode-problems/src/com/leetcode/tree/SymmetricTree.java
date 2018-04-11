package com.leetcode.tree;

import java.util.Stack;

public class SymmetricTree {
	
	public static void main(String[]args) {
		
		TreeNode root = createBinaryTree1();
		
		System.out.println("Is Symmetric Binary Tree: " + isSymmetricUsingStack(root)); 
		
		TreeNode root2 = createBinaryTree2();
		
		System.out.println("Is Symmetric Binary Tree: " + isSymmetricUsingStack(root2)); 
	}
	
	public static TreeNode createBinaryTree1() {
		TreeNode rootNode = new TreeNode(1);
		TreeNode leftRootNode = new TreeNode(2);
		TreeNode rightRootNode = new TreeNode(2);
		
		TreeNode leftRootChildNodeLeft = new TreeNode(3);
		TreeNode leftRootChildNodeRight = new TreeNode(4);
		
		TreeNode rightRootChildNodeLeft = new TreeNode(4);
		TreeNode rightRootChildNodeRight = new TreeNode(3);
		
		
		rootNode.left=leftRootNode;
		leftRootNode.left = leftRootChildNodeLeft;
		leftRootNode.right = leftRootChildNodeRight;
		
		rootNode.right=rightRootNode;
		rightRootNode.left = rightRootChildNodeLeft;
		rightRootNode.right = rightRootChildNodeRight;
 
		return rootNode;
	}
	
	public static TreeNode createBinaryTree2() {
		TreeNode rootNode = new TreeNode(1);
		TreeNode leftRootNode = new TreeNode(2);
		TreeNode rightRootNode = new TreeNode(3);
		
		
		rootNode.left=leftRootNode;
		rootNode.right=rightRootNode;
 
		return rootNode;
	}
	
	public static boolean isSymmetric(TreeNode root) {
		
		if (root == null)
			return true;
		
		return isSymmetric(root.left, root.right);
        
    }
	
	private static boolean isSymmetric(TreeNode left, TreeNode right) {
		
		if (left == null || right == null) 
			return left == right;
		
		if (left.data != right.data) 
			return false;
		
		return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left); 
		
	}
	
	public static boolean isSymmetricUsingStack(TreeNode root) {
		
		if (root == null)
			return true;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		TreeNode left = root.left;
		TreeNode right = root.right;
		
		if (left == null || right == null)
			return left == right;
		
		stack.push(left);
		stack.push(right);
		
		while(!stack.isEmpty()) {
			
			if (stack.size() % 2 != 0)
				return false;
			
			right = stack.pop();
			left = stack.pop();
			
			if (left == null && right == null) 
				continue;
			
			if (left == null || right == null) {
				return false;
			}
			
			if (left.data != right.data)
				return false;
			
			stack.push(left.left);
			stack.push(right.right);
			stack.push(left.right);
			stack.push(right.left);
			
		}
		
		
		return true;
	}

}
