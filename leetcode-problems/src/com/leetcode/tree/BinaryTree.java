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
		
		System.out.println("Level of Node 50: " + findLevelOfNode(root, 50, 1));
		
		System.out.println("Max Element: " + findMaxElement(root));
		
		System.out.println("Print Leaf Nodes: ");
		printLeafNodes(root);
		
		System.out.println("Print All Paths to Leaf Nodes: ");
		
		printAllPathsToLeafNodes(root, new int[1000], 0);
		
		System.out.println("Count of Leaf Nodes: " + countLeafNodes(root));
		
		System.out.println("PreOrder: ");
		preOrder(root);
		
		System.out.println("InOrder: ");
		inOrder(root);
		
		System.out.println("PostOrder: ");
		postOrder(root);
		
		System.out.println("LevelOrder: ");
		levelOrder(root);
		
	}
	
	public static int findLevelOfNode(TreeNode node, int key, int level) {
		
		if (node == null) {
			return 0;
		}
		
		if (node.data == key) {
			return level;
		}
		
		int result = findLevelOfNode(node.left, key, level+1);
		
		if (result != 0) {
			return result;
		}
		
		result = findLevelOfNode(node.right, key, level+1);
		
		return result;
		
	}
	
	public static int findMaxElement(TreeNode node) {
		
		int left = 0, right = 0, max = Integer.MIN_VALUE, currentValue = 0;
		
		if (node != null) {
			
			currentValue = node.data;
			
			left = findMaxElement(node.left);
			right = findMaxElement(node.right);
			
			if (left < right) {
				max = right;
			} else {
				max = left;
			}
			
			if (currentValue > max) {
				max = currentValue;
			}
			
		}
		
		return max;
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
	
	public static void printLeafNodes(TreeNode root) {
		
		if (root == null)
			return;
		
		if (root.left == null && root.right == null) {
			System.out.println(root.data);
		} 
		
		printLeafNodes(root.left);
		printLeafNodes(root.right);
		
	}
	
	public static int countLeafNodes(TreeNode root) {
		
		if (root == null) {
			return 0;
		}
		
		if (root.left == null && root.right == null) {
			return 1;
		}
		
		return countLeafNodes(root.left) + countLeafNodes(root.right);
	}
	
	public static void printAllPathsToLeafNodes(TreeNode node, int []path, int len) {
		
		if (node == null)
			return;
		
		path[len] = node.data;
		len++;
		
		if (node.left == null && node.right == null) {
			printArray(path, len);
			return;
		}
		printAllPathsToLeafNodes(node.left, path, len);
		printAllPathsToLeafNodes(node.right, path, len);
	}
	
	public static void  printArray(int[] path,int len)
	{
		for (int i = 0; i < len; i++) {
			System.out.print(" "+path[i]);
		}
		System.out.println();
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
