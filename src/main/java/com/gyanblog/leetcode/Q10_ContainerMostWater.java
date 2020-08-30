package com.gyanblog.leetcode;

public class Q10_ContainerMostWater {

	public int maxArea_2(int[] height) {
		int max = 0;
		int l = height.length;
		
		for (int i=0; i<l; i++) {
			for (int j=i+1; j<l; j++) {
				int area = (j-i) * Math.min(height[i], height[j]);
				if (area > max) {
					max = area;
				}
			}
		}
		
		return max;
	}
	public int maxArea(int[] height) {
        int l = height.length;
        int result = 0;
        int i=0;
        int j = l-1;

        while (i < j) {
            int area = (j-i) * Math.min(height[i], height[j]);
            if (result < area) {
                result = area;
            }

            if (height[i] < height[j]) {
                i++;
            }
            else j--;
        }

        return result;
    }
	
	public static void main(String[] args) {
		Q10_ContainerMostWater q = new Q10_ContainerMostWater();
		
		int[] points = {1,8,6,2,5,4,8,3,7};
		int area = q.maxArea(points);
		System.out.println(area);
	}
}
