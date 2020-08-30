package com.gyanblog.leetcode;

public class Q21_MergeLinkList {
	
	private ListNode head = null;
    private ListNode end = null;

	public static class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; next = null;}
	}
	
	private void append(int val) {
		ListNode node = new ListNode(val);
    	if (head == null) {
    		head = node;
    		end = head;
    	}
    	else {
    		end.next = node;
    		end = node;
    	}
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
        	append(l1.val <= l2.val ? l1.val : l2.val);
            
            if (l1.val <= l2.val) {
                l1 = l1.next;
            }
            else {
                l2 = l2.next;
            }
        }
        while (l1 != null) {
        	append(l1.val);
        	
            l1 = l1.next;
        }
        while (l2 != null) {
        	append(l2.val);
            l2 = l2.next;
        }
        
        return head;
    }
    
    public static void main(String[] args) {
    	ListNode l1 = getNode(1);
    	l1.next = getNode(2);
    	l1.next.next = getNode(4);
    	
    	ListNode l2 = getNode(1);
    	l2.next = getNode(3);
    	l2.next.next = getNode(4);
    	
    	print(l1); print(l2);
    	
    	Q21_MergeLinkList q = new Q21_MergeLinkList();
    	ListNode res = q.mergeTwoLists(l1, l2);
    	print(res);
	}
    
    private static ListNode getNode(int val) {
    	return new ListNode(val);
    }
    private static void print(ListNode l) {
    	while (l != null) {
    		System.out.print(l.val + " -> ");
    		l = l.next;
    	}
    	System.out.print("null");
    	System.out.println();
    }
}
