package com.gyanblog.tree;

import com.gyanblog.tree.CommonAncestor.Node;

public class TreeHelper {

	/**
	 *               50
	 *            /      \
	 *          80        30
	 *        /    \    /    \
	 *      20     40  90     10
	 * 
	 */
	public static Node buildSampleTree() {
		Node root = new Node(50);
		root.left = new Node(80);
		root.right = new Node(30);
		
		root.left.left = new Node(20);
		root.left.right = new Node(40);
		
		root.right.left = new Node(90);
		root.right.right = new Node(10);
		
		return root;
	}
	
	private static Node findHelperBinaryTree(Node root, Node node) {
		if (root == null || node == null) return null;
		
		if (root.data == node.data) {
			return root;
		}
		System.out.println("Searching at: " + root.data);
		Node left = findHelperBinaryTree(root.left, node);
		if (left != null) {
			return left;
		}
		
		Node right = findHelperBinaryTree(root.right, node);
		if (right != null) {
			return right;
		}
		return null;
	}
	
	public static Node findNode(Node root, Node node) {
		return findHelperBinaryTree(root, node);
	}
}
