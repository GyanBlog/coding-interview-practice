package com.gyanblog.ds;

import com.gyanblog.utils.ArrayUtils;

/**
 * For explanation: https://www.gyanblog.com/gyan/coding-interview/max-priority-queue-with-heap/
 */
public class MaxPriorityQueue {
    private int[] heap;
    private int maxSize;
    private int heapSize;

    public MaxPriorityQueue(int maxSize) {
        this.maxSize = maxSize;
        this.heap = new int[maxSize];
        this.heapSize = 0;
    }

    @Override
    public String toString() {
        return ArrayUtils.toString(this.heap, this.heapSize);
    }

    private int getLeftChild(int index) { return 2*index + 1;}
    private int getRightChild(int index) { return 2*index + 2;}
    private int getParent(int index) { 
        if (index == 0) {
            return -1;
        }
        return (index-1)/2; 
    }

    private void maxHeapify(int index) {
        int largest = index;
        int l = this.getLeftChild(index);
        int r = this.getRightChild(index);
        
        if (l < this.heapSize && this.heap[l] > this.heap[index]) {
            largest = l;
        }
        if (r < this.heapSize && this.heap[r] > this.heap[largest]) {
            largest = r;
        }
        if (largest != index) {
            ArrayUtils.swap(this.heap, largest, index);
            this.maxHeapify(largest);
        }
    }

    /**
     * Get the max element, do not delete
     */
    public int getMax() throws Exception {
        if (this.heapSize == 0) {
            throw new Exception("Heap underflow");
        }
        return this.heap[0];
    }

    /**
     * Get the max, and delete from heap
     * Runs in O(log n)
     */
    public int extractMax() throws Exception {
        if (this.heapSize == 0) {
            throw new Exception("Heap underflow");
        }

        int ret = this.heap[0];
        this.heap[0] = this.heap[this.heapSize-1];

        this.heapSize --;
        this.maxHeapify(0);

        return ret;
    }

    /**
     * Set the value at index specified to new value specified
     */
    public void increment(int index, int newValue) throws Exception {
        if (index > this.heapSize-1) {
            throw new Exception("Overflow");
        }

        this.heap[index] = newValue;
        while (index > 0 && this.heap[index] > this.heap[this.getParent(index)]) {
            ArrayUtils.swap(this.heap, index, this.getParent(index));
            index = this.getParent(index);
        }
    }

    public void insert(int val) throws Exception {
        if (this.heapSize >= this.maxSize) {
            throw new Exception("Overflow");
        }
        this.heapSize ++;
        this.heap[this.heapSize-1] = Integer.MIN_VALUE;
        this.increment(this.heapSize-1, val);
    }

    public static void main(String[] args) throws Exception {
        MaxPriorityQueue q = new MaxPriorityQueue(10);

        //fresh state
        System.out.println(q);

        //lets insert 5 elements
        q.insert(10); q.insert(5); q.insert(4); q.insert(6); q.insert(20);
        System.out.println(q);
        System.out.println("Max: " + q.getMax());

        System.out.println("Extracting max: " + q.extractMax());
        System.out.println("State: " + q);
        
        System.out.println("Incrementing index-2 to 12");
        q.increment(2, 12);
        System.out.println("State: " + q);
        
        System.out.println("Extracting max: " + q.extractMax());
        System.out.println("State: " + q);
        System.out.println("Extracting max: " + q.extractMax());
        System.out.println("State: " + q);
    }
}
