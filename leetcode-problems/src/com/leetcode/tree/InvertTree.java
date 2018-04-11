package com.leetcode.tree;

import java.util.Stack;

/**
 * 
 * https://leetcode.com/problems/invert-binary-tree/description/
 * 
 * Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
to

     4
   /   \
  7     2
 / \   / \
9   6 3   1
 * 
 * @author agiridhar
 *
 */
public class InvertTree {
	
	public static void main(String []args) {
		
		TreeNode root = createBinaryTree();
		System.out.println("Tree : ");
		print(root);
		
		invertTree(root);
		System.out.println("Inverted Tree : ");
		print(root);
	}
	
	
	
	public static TreeNode invertTree(TreeNode root) {
        
		if (root == null) return root;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		stack.push(root);
		
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			TreeNode left = node.left;
			
			node.left = node.right;
			node.right = left;
			
			
			if (node.left != null) {
				stack.push(node.left);
			}
			
			if (node.right != null) {
				stack.push(node.right);
			}
			
		}
		
		return root;
    }
	
	public static TreeNode createBinaryTree() {
		TreeNode rootNode =new TreeNode(40);
		TreeNode node20=new TreeNode(20);
		TreeNode node10=new TreeNode(10);
		TreeNode node30=new TreeNode(30);
		TreeNode node60=new TreeNode(60);
		TreeNode node50=new TreeNode(50);
		TreeNode node70=new TreeNode(70);
		
		rootNode.left=node20;
		rootNode.right=node60;
 
		node20.left=node10;
		node20.right=node30;
 
		node60.left=node50;
		node60.right=node70;
 
		return rootNode;
	}
	
	public static void print(TreeNode root) {
		
		if (root == null)
			return;
		
		System.out.print(root.data + " ");
		print(root.left);
		print(root.right);
	}

}
