package com.gyanblog.misc;

import java.util.ArrayList;
import java.util.List;

public class NumberCompositions {
	public static void findCompositions(String str, int index, List<List<String>> result, List<String> interResult) {
		if (index == str.length()) {
			System.out.println(interResult);
			result.add(new ArrayList<String>(interResult));
			return;
		}
		for (int i=index+1; i<=str.length(); i++) {
			interResult.add(str.substring(index, i));
			findCompositions(str, i, result, interResult);
			interResult.remove(interResult.size()-1);
		}
	}

	public static void main(String[] args) {
		List<List<String>> result = new ArrayList<>();
		findCompositions("020", 0, result, new ArrayList<String>());

		System.out.println(result);
	}
}
