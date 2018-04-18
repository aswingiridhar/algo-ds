package com.leetcode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/description/
 * 
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 * 
 * @author agiridhar
 *
 */
public class BinaryTreeTraversal {
	
	public static void main(String [] args) {
		
		TreeNode root = createBinaryTree();
		
		List<List<Integer>> list = levelOrderBottom(root);
		System.out.println(printBT(list));
		
		List<List<Integer>> list2 = levelOrder(root);
		System.out.println(printBT(list2));
		
		List<List<Integer>> list3 = zigzagLevelOrder(root);
		System.out.println(printBT(list3));
		
		System.out.println("PreOrder Traversal: " + preorderTraversal(root));
		System.out.println("InOrder Traversal: " + inorderTraversal(root));
		
	}
	
	public static String printBT(List<List<Integer>> list) {
		StringBuilder levelOrder = new StringBuilder();
		levelOrder.append("[");
		
		for (List<Integer> sublist : list) {
			levelOrder.append("[");
			for (Integer val : sublist) {
				levelOrder.append(val + ", ");
			}
			
			levelOrder.append("]");
		}
		levelOrder.append("]");
		
		return levelOrder.toString();
	}
	
	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> list = new LinkedList<List<Integer>>();
		
		if (root == null) return list;
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			int queueSize = queue.size();
			
			List<Integer> subList = new LinkedList<Integer>();
			
			for (int i = 0; i < queueSize; i++) {
				if (queue.peek().left != null) 
					queue.add(queue.peek().left);
				
				if (queue.peek().right != null)
					queue.add(queue.peek().right);
				
				subList.add(queue.poll().data);
			}
			
			list.add(0, subList);
			
		}
		
		
		
		return list;
    }
	
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list = new LinkedList<List<Integer>>();
		
		if (root == null) return list;
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		
		queue.add(root);
		
		while(!queue.isEmpty()) {
			int queueSize = queue.size();
			List<Integer> sublist = new LinkedList<Integer>();
			for (int i = 0; i < queueSize; i++) {
				if (queue.peek().left != null)
					queue.add(queue.peek().left);
				
				if (queue.peek().right != null)
					queue.add(queue.peek().right);
				
				sublist.add(queue.poll().data);
			}
			
			list.add(sublist);
		}
		
		return list;
	}
	
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		
		List<List<Integer>> list = new LinkedList<List<Integer>>();
		
		if (root == null) return list;
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		
		queue.add(root);
		
		int level = 1;
		
		while(!queue.isEmpty()) {
			int queueSize = queue.size();
			List<Integer> sublist = new LinkedList<Integer>();
			for (int i = 0; i < queueSize; i++) {
				if (queue.peek().left != null)
					queue.add(queue.peek().left);
				
				if (queue.peek().right != null)
					queue.add(queue.peek().right);
				
				if (level % 2 == 0) {
					sublist.add(0, queue.poll().data);
				} else {
					sublist.add(queue.poll().data);
				}
				
			}
			
			list.add(sublist);
			
			level++;
		}
		
		return list;
	}
	
	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new LinkedList<Integer>();
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		
		while (!stack.isEmpty()) {
			
			TreeNode node = stack.pop();
			if (node != null) {
				list.add(node.data);
				
				if (node.right != null) {
					stack.push(node.right);
				}
				
				if (node.left != null) {
					stack.push(node.left);
				}
			}
			
		}
		
		return list;
	}
	
	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new LinkedList<Integer>();
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		TreeNode current = root;
		
		while (current != null || !stack.empty()) {
			
			if (current != null) {
				stack.push(current);
				current = current.left;
			} else {
				TreeNode node = stack.pop();
				list.add(node.data);
				current = node.right;
			}
			
		}
		
		return list;
	}
	
	public static List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new LinkedList<Integer>();
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		TreeNode current = root;
		
		while (current != null || !stack.empty()) {
			
			if (current != null) {
				stack.push(current);
				current = current.left;
			} else {
				TreeNode node = stack.pop();
				list.add(node.data);
				current = node.right;
			}
			
		}
		
		return list;
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
