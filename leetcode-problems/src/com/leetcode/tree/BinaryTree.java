package com.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * Binary Tree
 * 
 * 				40
 * 		20				60
 * 	10		30		50		70
 * 
 * PreOrder: 40 20 10 30 60 50 70 
 * InOrder: 10 20 30 40 50 60 70
 * PostOrder: 10 30 20 50 70 60 40
 * @author agiridhar
 *
 */
public class BinaryTree {
	
	public static void main(String []args) {
		
		TreeNode root = createBinaryTree();
		
		System.out.println("Print Leaf Nodes: ");
		printLeadNodes(root);
		System.out.println("Count of Leaf Nodes: " + countLeadNodes(root));
		System.out.println("PreOrder: ");
		preOrder(root);
		System.out.println("InOrder: ");
		inOrder(root);
		System.out.println("PostOrder: ");
		postOrder(root);
		System.out.println("LevelOrder: ");
		levelOrder(root);
		
	}
	
	public static void preOrder(TreeNode root) {
		
		if (root == null)
			return;
		
		System.out.println(root.data);
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public static void inOrder(TreeNode root) {
		
		if (root == null)
			return;
		
		inOrder(root.left);
		System.out.println(root.data);
		inOrder(root.right);
	}
	
	public static void postOrder(TreeNode root) {
		
		if (root == null)
			return;
		
		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.data);
	}
	
	public static void levelOrder(TreeNode root) {
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			
			TreeNode node = queue.poll();
			
			System.out.println(node.data);
			
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
			
		}
		
	}
	
	public static void printLeadNodes(TreeNode root) {
		
		if (root == null)
			return;
		
		if (root.left == null && root.right == null) {
			System.out.println(root.data);
		} 
		
		printLeadNodes(root.left);
		printLeadNodes(root.right);
		
	}
	
	public static int countLeadNodes(TreeNode root) {
		
		if (root == null) {
			return 0;
		}
		
		if (root.left == null && root.right == null) {
			return 1;
		}
		
		return countLeadNodes(root.left) + countLeadNodes(root.right);
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

}
