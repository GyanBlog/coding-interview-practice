package com.gyanblog.leetcode;

public class Q25_ReverseNodesGroups {
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
	public static class NodeHandles {
		public ListNode head;
		public ListNode end;
		public ListNode next;
		public NodeHandles(ListNode head, ListNode end) {
			this.head = head;
			this.end = end;
			this.next = null;
		}
		public NodeHandles(ListNode head, ListNode end, ListNode next) {
			this.head = head;
			this.end = end;
			this.next = next;
		}
	}
	
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null) return null;
		if (k == 1) return head;
	
		NodeHandles rev = this.reverse(head, k-1);
		if (rev == null) return head;
		
		head = rev.head;
		while (rev != null) {
			ListNode end = rev.end;
			end.next = rev.next;
			if (rev.next == null) {
				break;
			}
			rev = this.reverse(rev.next, k-1);
			if (rev != null) {
				end.next = rev.head;
			}
		}
		
		return head;
    }
	
	private NodeHandles reverse(ListNode h, int count) {
		if (h.next == null && count > 0) {
			return null;
		}
		if (h.next == null || count == 0) {
			return new NodeHandles(h, null, h.next);
		}
		
		NodeHandles newPair = reverse(h.next, --count);
		if (newPair == null) {
			return null;
		}
		h.next.next = h;
		h.next = null;
		
		newPair.end = h;
		return newPair;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
//		head.next = new ListNode(2);
//		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(4);
//		head.next.next.next.next = new ListNode(5);
//		head.next.next.next.next.next = new ListNode(6);
//		head.next.next.next.next.next.next = new ListNode(7);
//		head.next.next.next.next.next.next.next = new ListNode(8);
		
		Q25_ReverseNodesGroups q = new Q25_ReverseNodesGroups();
		int k = 2;
		ListNode rev = q.reverseKGroup(head, k);
		System.out.println(rev);
	}
}
