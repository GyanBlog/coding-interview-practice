package com.gyanblog.leetcode.q4_median_sorted_arrays;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
   Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

   For detailed explanation: https://www.gyanblog.com/gyan/coding-interview/leetcode-find-median-two-sorted-arrays/
 */
public class OptimizedSolution {
    private int[] arr1;
    private int[] arr2;

    public OptimizedSolution(int[] arr1, int[] arr2) {
        this.arr1 = arr1;
        this.arr2 = arr2;
    }

    public double getMedian() {
        //lets take shorter array first
        if (this.arr1.length > this.arr2.length) {
            //swap references
            int[] t = this.arr1;
            this.arr1 = this.arr2;
            this.arr2 = t;
        }

        int l1 = this.arr1.length;
        int l2 = this.arr2.length;

        //need to partition shorter array first, then 2nd so that both partition have equal elements (+- 1)
        int ps = 0;     //partition start index
        int pe = l1;    //partition end index (Note it is not the last index)

        int halfElements = (l1 + l2 + 1)/2;

        while (ps <= pe) {
            //index of partition of 1st array
            int partitionA = (ps + pe) / 2;

            //calculate partition index of 2nd array
            int partitionB = halfElements - partitionA;

            System.out.println();
            this.printArrayWithPartition(this.arr1, partitionA);
            System.out.println();
            this.printArrayWithPartition(this.arr2, partitionB);

            //compare elements
            if (partitionA > 0 && this.arr1[partitionA-1] > this.arr2[partitionB]) {
                pe = partitionA - 1;
            }
            else if (partitionA < l1 && this.arr2[partitionB-1] > this.arr1[partitionA]) {
                ps = partitionA + 1;
            } 
            else {
                //found balanced both partitions

                System.out.println("\nFound balanced partition");
                System.out.println("ArrayA: " );
                this.printArrayWithPartition(this.arr1, partitionA);
                
                System.out.println("\nArrayB:");
                this.printArrayWithPartition(this.arr2, partitionB);

                int maxLeft = this.getMaxOfLeftPartition(partitionA, partitionB);
                //get median
                if ((l1 + l2) % 2 != 0) {
                    return maxLeft;
                }

                int minRight = this.getMinOfRightPartition(partitionA, partitionB);
                return (maxLeft + minRight)/2;
            }
        }

        return 0.0;
    }

    private int getMaxOfLeftPartition(int partitionA, int partitionB) {
        if (partitionA == 0) return this.arr2[partitionB-1];
        if (partitionB == 0) return this.arr1[partitionA-1];
        return Math.max(this.arr1[partitionA-1], this.arr2[partitionB-1]);
    }

    private int getMinOfRightPartition(int partitionA, int partitionB) {
        if (partitionA == this.arr1.length) return this.arr2[partitionB];
        if (partitionB == this.arr2.length) return this.arr1[partitionA];
        return Math.min(this.arr1[partitionA], this.arr2[partitionB]);
    }

    private void printArrayWithPartition(int[] arr, int partition) {
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
            if (i == (partition-1)) {
                System.out.print("| ");
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 8, 9, 15};
        int[] arr2 = {7, 11, 18, 19, 21, 25};

        OptimizedSolution os = new OptimizedSolution(arr1, arr2);
        System.out.println("\nMedian: " + os.getMedian());

        System.out.println("------------------------");

        arr1 = new int[]{1, 3, 5, 7, 9, 11, 13};
        arr2 = new int[]{2, 4};
        os = new OptimizedSolution(arr1, arr2);
        System.out.println("\nMedian: " + os.getMedian());
    }
}