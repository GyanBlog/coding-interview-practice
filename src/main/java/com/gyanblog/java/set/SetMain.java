package com.gyanblog.java.set;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class SetMain {

	public static void main(String[] args) {
		HashSetImpl<Integer> set = new HashSetImpl<>();
		
		set.add(4);
		set.add(5);
		set.add(1);
		set.add(2);
		
		if (set.contains(4)) {
			System.out.println("Found 4");
		}
		else {
			System.out.println("Not found 4");
		}
		
		Collection<Integer> c = Arrays.asList(1, 2);
		if (set.containsAll(c)) {
			System.out.println("Found all");
		}
		else {
			System.out.println("Not found all");
		}
	}
}
