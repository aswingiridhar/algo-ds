package com.leetcode.tree;

/**
 * 
 * https://leetcode.com/problems/balanced-binary-tree/
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * 
 * @author agiridhar
 *
 */
public class BinaryTreeDepth {
	
	public static void main(String[]args) {
		
		TreeNode root = createBinaryTree1();
		
		System.out.println("Is Balanced: " + isBalanced(root));
		System.out.println("MinDepth: " + minDepth(root));
		System.out.println("MaxDepth: " + maxDepth(root));
		
		TreeNode root2 = createBinaryTree2();
		
		System.out.println("Is Balanced: " + isBalanced(root2));
		System.out.println("MinDepth: " + minDepth(root2));
		System.out.println("MaxDepth: " + maxDepth(root2));
	}

	public static int depth(TreeNode root) {
		if (root == null)
			return 0;
		
		return Math.max(depth(root.left), depth(root.right)) + 1;
	}

	public static boolean isBalanced(TreeNode root) {
		
		if (root == null)
			return true;
		
		int left = depth(root.left);
		int right = depth(root.right);
		
		return Math.abs(left - right) <= 1 && isBalanced(root.left)  && isBalanced(root.right);
	}
	
	public static int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		
		int left = minDepth(root.left);
		int right = minDepth(root.right);
		
		return (left == 0 || right == 0 ? left + right + 1 : Math.min(left, right) + 1);
	}
	
	public static int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		
		return (left == 0 || right == 0 ? left + right + 1 : Math.max(left, right) + 1);
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
		TreeNode leftRootNodeleft = new TreeNode(3);
		
		
		rootNode.left=leftRootNode;
		leftRootNode.left=leftRootNodeleft;
		
		rootNode.right = new TreeNode(4);
		
		return rootNode;
	}

}
