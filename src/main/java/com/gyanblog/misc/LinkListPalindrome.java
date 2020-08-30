package com.gyanblog.misc;

public class LinkListPalindrome {

	public static class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x) { val = x; }
		 @Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			ListNode t = this;
			while (t != null) {
				sb.append(t.val).append(" -> ");
				t = t.next;
			}
			return sb.toString();
		}
	}
	public static class NodeWrapper {
		public ListNode node;
		public NodeWrapper(ListNode node) {
			this.node = node;
		}
	}
	
	private boolean isPalindrome(NodeWrapper n1, ListNode n2) {
		if (n2 == null) {
			return true;
		}
		
		boolean result = isPalindrome(n1, n2.next);
		if (!result) return false;

		System.out.println(n1.node.val + " == " + n2.val);
		result = n1.node.val == n2.val;
		
		//move left hand to next
		n1.node = n1.node.next;
		
		return result;
	}
	
	public boolean isPalindrome(ListNode head) {
		if (head == null) return false;
		if (head.next == null) return true;
		
		return this.isPalindrome(new NodeWrapper(head), head.next);
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(4);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(2);
		head.next.next.next.next.next = new ListNode(1);
		
		System.out.println(head);
		
		LinkListPalindrome l = new LinkListPalindrome();
		boolean res = l.isPalindrome(head);
		System.out.println(res);
	}
}
