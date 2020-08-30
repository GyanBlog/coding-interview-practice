package com.gyanblog.leetcode;

public class Q23_MergeSortedLists {
	public static class HeapData {
		public int val;
		public int index;
		public HeapData(int val, int index) {
			this.val = val;
			this.index = index;
		}
	}
	public static class Heap {
		private int size;
		private int heapSize;
		private HeapData[] heap;
		
		public Heap(int size) {
			this.size = size;
			this.heapSize = 0;
			this.heap = new HeapData[size];
			for (int i=0; i<size; i++) {
				this.heap[i] = new HeapData(Integer.MAX_VALUE, -1);
			}
		}
		
		private void heapifyDown(int index) {
			int left = 2*index + 1;
			int right = 2*index + 2;
			
			int minIndex = index;
			if (left < this.heapSize && this.heap[left].val < this.heap[index].val) {
				minIndex = left;
			}
			if (right < this.heapSize && this.heap[right].val < this.heap[minIndex].val) {
				minIndex = right;
			}
			
			if (index != minIndex) {
				HeapData t = this.heap[index];
				this.heap[index] = this.heap[minIndex];
				this.heap[minIndex] = t;
				
				heapifyDown(minIndex);
			}
		}
		
		private void heapifyUp(int index) {
			if (index < 0 || index >= this.heapSize) {
				return;
			}
			int parentIdx = (index-1)/2;
			while (this.heap[index].val < this.heap[parentIdx].val) {
				HeapData t = this.heap[index];
				this.heap[index] = this.heap[parentIdx];
				this.heap[parentIdx] = t;
				
				index = parentIdx;
				parentIdx = (index-1)/2;
			}
		}
		
		public void add(HeapData data) { //throws Exception {
			if (this.heapSize >= this.size) {
//				throw new Exception("Overflow...");
				return;
			}
			this.heap[this.heapSize] = data;
			this.heapSize ++;
			this.heapifyUp(this.heapSize-1);
		}
		
		public HeapData getMin() {// throws Exception {
			if (this.heapSize == 0) {
//				throw new Exception("Underflow...");
				return null;
			}
			
			HeapData t = this.heap[0];
			
			this.heap[0] = this.heap[this.heapSize-1];
			this.heapSize --;
			
			this.heapifyDown(0);
			
			return t;
		}
		
		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			for (int i=0; i<this.heapSize; i++) {
				sb.append("val=").append(this.heap[i].val).append(",index=").append(this.heap[i].index).append("->");
			}
			return sb.toString();
		}
	}
	
	private ListNode head;
	private ListNode end;
	
	public Q23_MergeSortedLists() {
		this.head = null;
		this.end = null;
	}
	private void append(int data) {
		ListNode newNode = new ListNode(data);
		
		if (this.end != null) {
			this.end.next = newNode;
			this.end = this.end.next;
		}
		else if (this.head == null) {
			this.head = newNode;
			this.end = newNode;
		}
	}

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
	
	public ListNode mergeKLists_2(ListNode[] lists) {
		int l = lists.length;
		while (true) {
			boolean found = false;

			int min = Integer.MAX_VALUE;
			int listIndex = -1;
			
			for (int i=0; i<l; i++) {
				if (lists[i] != null) {
					if (min > lists[i].val) {
						min = lists[i].val;
						listIndex = i;
						
						found = true;
					}
				}
			}
			
			if (!found) break;

			lists[listIndex] = lists[listIndex].next;
			append(min);
		}
		
		return this.head;
	}
	
	public ListNode mergeKLists(ListNode[] lists) {
		int l = lists.length;
		Heap heap = new Heap(l);
		
		for (int i=0; i<l; i++) {
			if (lists[i] == null) continue;
			
			heap.add(new HeapData(lists[i].val, i));
			lists[i] = lists[i].next;
		}
		
		System.out.println(heap);		
		HeapData data = heap.getMin();
		System.out.println(heap);
		while (data != null) {
			append(data.val);
			
			//add to the heap from the list where we picked the min element
			if (lists[data.index] != null) {
				heap.add(new HeapData(lists[data.index].val, data.index));
				lists[data.index] = lists[data.index].next;
			}
			
			data = heap.getMin();
		}
		
		return this.head;
	}
	
	public static void main(String[] args) throws Exception {
		Q23_MergeSortedLists q = new Q23_MergeSortedLists();
		
		//[1,4,5],[1,3,4],[2,6]]
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(5);
		
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		
		ListNode l3 = new ListNode(2);
		l3.next = new ListNode(6);
		
		ListNode[] list = {l1, l2, l3}; 

		ListNode res = q.mergeKLists(list);
		System.out.println(res);
	}
}
