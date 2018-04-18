package com.leetcode.tree;

/**
 * 
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
 * 
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T 
that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.


 * 
 * @author agiridhar
 *
 */


public class LowestCommonAncestor {
	
	public static void main(String []args) {
		TreeNode root = createBinaryTree();
		
		TreeNode lca = lowestCommonAncestor(root, new TreeNode(10), new TreeNode(30));
		
		System.out.println("lca: " + lca.data);
	}
	
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
		if(root == null)
			return null;
		if(root.data == p.data || root.data == q.data )
			return root;
		
		TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null)
            return right;
        else if (right == null)
            return left;
        else
            return root;
		
    }
	
	public TreeNode lowestCommonAncestorForBST(TreeNode root, TreeNode p, TreeNode q) {
        if(root.data > p.data && root.data > q.data){
            return lowestCommonAncestor(root.left, p, q);
        }else if(root.data < p.data && root.data < q.data){
            return lowestCommonAncestor(root.right, p, q);
        }else{
            return root;
        }
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
