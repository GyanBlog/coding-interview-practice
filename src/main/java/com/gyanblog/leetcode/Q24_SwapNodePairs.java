package com.gyanblog.leetcode;

public class Q24_SwapNodePairs {

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
	
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) return head;
		
		ListNode first = head;
		ListNode second = head.next;
		ListNode prev = null;
		
		ListNode result = second;
		while (first != null && second != null) {
			first.next = second.next;
			second.next = first;
			
			if (prev != null) {
				prev.next = second;
			}
			
			prev = first;
			
			first = first.next;
			if (first != null) {
				second = first.next;
			}
		}
		
		return result;
    }
	
	public static void main(String[] args) {
		ListNode list = new ListNode(1);
		list.next = new ListNode(2);
//		list.next.next = new ListNode(3);
//		list.next.next.next = new ListNode(4);
//		list.next.next.next.next = new ListNode(5);
//		list.next.next.next.next.next = new ListNode(6);
		
		Q24_SwapNodePairs q = new Q24_SwapNodePairs();
		ListNode res = q.swapPairs(list);
		System.out.println(res);
	}
}
