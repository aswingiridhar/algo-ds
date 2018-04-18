package com.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * https://leetcode.com/problems/path-sum/description/
 * 
 * * Binary Tree
 * 
 * 				40
 * 		20				60
 * 	10		30		50		70
 * 
 * @author agiridhar
 *
 */
public class PathSum {
	
	public static void main(String [] args) {
		
		TreeNode root = createBinaryTree();
		
		
		System.out.println("Has Path Sum: " + hasPathSum(root, 170) );
		System.out.println("Has Path Sum: " + hasPathSum(root, 70) );
		System.out.println("Has Path Sum: " + hasPathSum(root, 80) );
		
		System.out.println("Path Sum: " + pathSum(root, 70) );
		
	}
	
	
	public static boolean hasPathSum(TreeNode root, int sum) {
        
		if (root == null) return false;
		
		if (root.data == sum && root.left == null && root.right == null) return true;
		
		return hasPathSum(root.left, sum - root.data) || hasPathSum(root.right, sum - root.data);
    }
	
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		
		List<Integer> path = new ArrayList<Integer>();
		
		dfs(root, sum, path, result);
		
		return result;
		
    }
	
	public static void dfs(TreeNode node, int sum, List<Integer> path, List<List<Integer>> result) {
		
		if (node == null) {
			return;
		}
		
		path.add(node.data);
		
		if (node.data == sum && node.left == null && node.right == null) {
			result.add(new LinkedList<Integer>(path));
		} else {
			dfs(node.left, sum - node.data, path, result);
			dfs(node.right, sum - node.data, path, result);
		}
		// remove so that you can go back
		path.remove(path.size() - 1);
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
