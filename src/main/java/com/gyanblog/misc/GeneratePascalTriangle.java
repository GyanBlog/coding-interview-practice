package com.gyanblog.misc;

import java.util.ArrayList;
import java.util.List;

public class GeneratePascalTriangle {

	public static List<List<Integer>> pascal(int n) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> levelList = new ArrayList();
		levelList.add(1);
		res.add(levelList);
		
		int currentLevel = 1;
		while (currentLevel < n) {
			levelList = new ArrayList();
			levelList.add(1);
			List<Integer> previousLevel = res.get(currentLevel-1);
			for (int i=1; i<previousLevel.size(); i++) {
				levelList.add(previousLevel.get(i-1) + previousLevel.get(i));
			}
			levelList.add(1);
			res.add(levelList);
			
			currentLevel ++;
		}
		
		return res;
	}
}
