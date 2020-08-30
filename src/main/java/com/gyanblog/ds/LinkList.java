package com.gyanblog.ds;

public class LinkList {

	public static class Node {
		public int data;
		public Node next;
		public Node(int data) {
			this.data = data;
			next = null;
		}
	}
	
	private Node head;
	
	public LinkList appendNode(int val) {
		Node newNode = new Node(val);
		if (this.head == null) {
			this.head = newNode;
			return this;
		}
		
		Node t = this.head;
		while (t.next != null) {
			t = t.next;
		}
		t.next = newNode;
		
		return this;
	}
	
	public void reverseNonRecursive() {
		Node prev = null;
		Node curr = this.head;
		Node fwd = curr;
		
		while (curr != null) {
			fwd = curr.next;
			curr.next = prev;
			prev = curr;
			curr = fwd;
		}
		this.head = prev;
	}
	
	private Node reverseRecursiveHelper(Node t1, Node t2) {
		if (t2 == null) {
			return t1;
		}
		
		Node t = this.reverseRecursiveHelper(t2, t2.next);
		
		t2.next = t1;
		return t;
	}
	public void reverseRecursive() {
		this.head = this.reverseRecursiveHelper(null, this.head);
	}
	
	private Node reverseRecursiveHelper2(Node node) {
		if (node.next == null) {
			return node;
		}
		
		Node t = this.reverseRecursiveHelper2(node.next);
		node.next.next = node;
		node.next = null;
		
		return t;
	}
	public void reverseRecursive2() {
		this.head = this.reverseRecursiveHelper2(this.head);
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		Node t = this.head;
		while (t != null) {
			sb.append(t.data);
			t = t.next;
			
			if (t != null) {
				sb.append(" -> ");
			}
			else {
				sb.append(" -> null");
			}
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		LinkList list = new LinkList();
		list.appendNode(10).appendNode(20).appendNode(30).appendNode(40).appendNode(50);
		
		System.out.println("Linklist: " + list.toString());
//		list.reverseNonRecursive();
//		list.reverseRecursive();
		list.reverseRecursive2();
		System.out.println("Linklist: " + list.toString());
	}
}
