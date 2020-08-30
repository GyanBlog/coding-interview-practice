package com.gyanblog.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q13_RomanToInteger {

	public int romanToInt(String s) {
	    Map<String, Integer> map = new HashMap();
	    map.put("I", 1); map.put("V", 5); map.put("X", 10);
	    map.put("L", 50); map.put("C", 100); map.put("D", 500); map.put("M", 1000);
	    
	    map.put("IV", 4); map.put("IX", 9); map.put("XL", 40); map.put("XC", 90);
	    map.put("CD", 400); map.put("CM", 900);

	    int num = 0;
	    int l = s.length();
	    for (int i=0; i<l; ) {
	        String single = new String(new char[]{s.charAt(i)});
	        String two = null;
	        if (i+1 < l) {
	            two = new String(new char[]{s.charAt(i), s.charAt(i+1)});
	        }

	        if (two != null && map.get(two) != null) {
	            num += map.get(two);
	            i += 2;
	        }
	        else {
	            num += map.get(single);
	            i++;
	        }
	    }

	    return num;
	}
	
	public Q13_RomanToInteger() {
		Q13_RomanToInteger q = new Q13_RomanToInteger();
		int number = q.romanToInt("LVIII");
		System.out.println(number);
	}
}
