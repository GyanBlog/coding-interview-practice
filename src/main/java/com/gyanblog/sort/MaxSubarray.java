package com.gyanblog.sort;

public class MaxSubarray {

	public static class MaxSubarrayData {
		private int lindex;
		private int rindex;
		private int sum;
		public MaxSubarrayData(int lindex, int rindex, int sum) {
			super();
			this.lindex = lindex;
			this.rindex = rindex;
			this.sum = sum;
		}
		public int getLindex() {
			return lindex;
		}
		public void setLindex(int lindex) {
			this.lindex = lindex;
		}
		public int getRindex() {
			return rindex;
		}
		public void setRindex(int rindex) {
			this.rindex = rindex;
		}
		public int getSum() {
			return sum;
		}
		public void setSum(int sum) {
			this.sum = sum;
		}
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("sum=").append(this.sum);
			sb.append(",").append("leftIndex=").append(this.lindex);
			sb.append(",").append("rightIndex=").append(this.rindex);
			return sb.toString();
		}
	}
	
	public static MaxSubarrayData calculate_bad(int[] a) {
		int maxSum = Integer.MIN_VALUE;
		int len = a.length;
		
		MaxSubarrayData result = new MaxSubarrayData(0, 0, a[0]);
		
		for (int i=0; i<len; i++) {
			int sum = 0;
			for (int j=i; j<len; j++) {
				sum += a[j];
				if (sum > maxSum) {
					maxSum = sum;
					
					result.setLindex(i);
					result.setRindex(j);
					result.setSum(maxSum);
				}
			}
		}
		
		return result;
	}
	
	public static MaxSubarrayData calculate_good_crossing(int[] arr, int l, int m, int r) {
		
		MaxSubarrayData res = new MaxSubarrayData(l, r, 0);
		
		int maxLeft = 0;
		int sum = 0;
		for (int i=m; i>=l; i--) {
			sum += arr[i];
			if (sum > maxLeft) {
				maxLeft = sum;
				res.setLindex(i);
			}
		}
		
		int maxRight = 0;
		sum = 0;
		for (int i=m+1; i<=r; i++) {
			sum += arr[i];
			if (sum > maxRight) {
				maxRight = sum;
				res.setRindex(i);
			}
		}
		
		res.setSum(maxLeft + maxRight);
		return res;
	}
	
	public static MaxSubarrayData calculate_good(int[] arr, int l, int r) {
		if (l == r) {
			return new MaxSubarrayData(l, r, arr[l]);
		}
		else {
			int m = (l+r)/2;
			MaxSubarrayData left = calculate_good(arr, l, m);
			MaxSubarrayData right = calculate_good(arr, m+1, r);
			
			MaxSubarrayData crossing = calculate_good_crossing(arr, l, m, r);
			
			if (left.getSum() > right.getSum() && left.getSum() > crossing.getSum()) {
				return left;
			}
			else if (right.getSum() > left.getSum() && right.getSum() > crossing.getSum()) {
				return right;
			}
			else {
				return crossing;
			}
		}
	}
	
	public static MaxSubarrayData calculate_best(int[] arr) {
		MaxSubarrayData res = new MaxSubarrayData(0, 0, arr[0]);
		
		int maxSum = 0;
		int sum = 0;
		int len = arr.length;
		for (int i=0; i<len; i++) {
			sum += arr[i];
			
			if (sum > maxSum) {
				maxSum = sum;
				
				res.setRindex(i);
				res.setSum(maxSum);
			}
			if (sum < 0) {
				sum = 0;
				res.lindex = i+1;
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
		MaxSubarrayData res = calculate_bad(arr);
		System.out.println(res);
		
		MaxSubarrayData res_best = calculate_best(arr);
		System.out.println(res_best);
		
		MaxSubarrayData res_good = calculate_good(arr, 0, arr.length-1);
		System.out.println(res_good);
	}
}
