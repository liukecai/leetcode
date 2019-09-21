package cn.edu.kust.easy;

import cn.edu.kust.util.TreeNode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 * pass
 * 
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LowestCommonAncestor {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }else if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }else{
            return root;
        }
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		
		TreeNode p = new TreeNode(1);
		TreeNode q = new TreeNode(3);
		
		LowestCommonAncestor lca = new LowestCommonAncestor();
		
		TreeNode node = lca.lowestCommonAncestor(root, p, q);
		System.out.println(node.val);
	}
}

