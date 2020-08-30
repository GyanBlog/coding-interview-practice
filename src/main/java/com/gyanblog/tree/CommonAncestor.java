package com.gyanblog.tree;

public class CommonAncestor {
	public static class Node {
		public int data;
		public Node left;
		public Node right;
		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	/**
	 * To check whether a node exists in a root element
	 */
	private boolean covers(Node root, Node toSearch) {
		if (root == null || toSearch == null) {
			return false;
		}
		if (root.data == toSearch.data) {
			return true;
		}
		
		return this.covers(root.left, toSearch) || this.covers(root.right, toSearch);
	}
	
	private Node helper1(Node root, Node node1, Node node2) {
		if (root == null) {
			return null;
		}
		if (root.data == node1.data || root.data == node2.data) {
			return root;
		}
		
		boolean firstNodeFoundOnLeft = this.covers(root.left, node1);
		boolean firstNodeFoundOnRight = this.covers(root.left, node2);
		
		if (firstNodeFoundOnLeft != firstNodeFoundOnRight) {
			//both are on different sides. Found result.
			return root;
		}
		
		//both are on the same side.
		return this.helper1(firstNodeFoundOnLeft ? root.left : root.right, 
				node1, node2);
	}
	
	public Node findCommonAncestor_1(Node root, Node node1, Node node2) {
		if (!this.covers(root, node1) || !this.covers(root, node2)) {
			//one or both nodes are not in the tree
			System.out.println("Not covered");
			return null;
		}
		
		return this.helper1(root, node1, node2);
	}
	
	private int getDepth(Node root) {
		if (root == null) return 0;

		return 1 + Math.max(getDepth(root.left), getDepth(root.right));
	}
	
	//returns length of array where element found
	private int findPathToNode(Node root, Node node, int[] arr, int level) {
		if (root == null) {
			return 0;
		}
		arr[level] = root.data;
		if (root.data == node.data) {
			//found
			System.out.println("Found here");
			return level;
		}
		int l1 = findPathToNode(root.left, node, arr, level+1);
		if (l1 != 0) return l1;
		int l2 = findPathToNode(root.right, node, arr, level+1);
		if (l2 != 0) return l2;
		
		return 0;
	}
	
	public Node findCommonAncestor_2(Node root, Node node1, Node node2) {
		int depth = this.getDepth(root);
		int[] arr = new int[depth];
		
		System.out.println("Finding " + node1.data);
		int l1 = this.findPathToNode(root, node1, arr, 0);
		for(int i=0; i<=l1; i++) {
			System.out.print(arr[i]);
			System.out.print(" ");
		}
		System.out.println();

		int l2 = this.findPathToNode(root, node2, arr, 0);
		for(int i=0; i<=l2; i++) {
			System.out.print(arr[i]);
			System.out.print(" ");
		}
		System.out.println();
		
		return null;
	}
	
	public static void main(String[] args) {
		CommonAncestor ca = new CommonAncestor();
		Node root = TreeHelper.buildSampleTree();
		
		Node node = ca.findCommonAncestor_2(root, new Node(40), new Node(80));

//		Node node = ca.findCommonAncestor_1(root, new Node(40), new Node(80));
//		
		if (node != null) {
			System.out.println(node.data);
		}
		else {
			System.out.println("Not found");
		}
	}
}
