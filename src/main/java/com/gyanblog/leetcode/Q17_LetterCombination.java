package com.gyanblog.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Q17_LetterCombination {
	
	public List<String> letterCombinations3(String digits) {
	    Map<Integer, String> map = new HashMap();
	    map.put(2, "abc");
	    map.put(3, "def");
	    map.put(4, "ghi");
	    map.put(5, "jkl");
	    map.put(6, "mno");
	    map.put(7, "pqrs");
	    map.put(8, "tuv");
	    map.put(9, "wxyz");

	    List<String> res = new ArrayList();
	    if (digits.length() == 0) return res;

	    String c1 = map.get(digits.charAt(0) - '0');
	    for (int i=0; i<c1.length(); i++) {
	      res.add(c1.charAt(i) + "");
	    }

	    for (int i=1;i<digits.length(); i++) {
	      res = merge(res, map.get(digits.charAt(i) - '0'));
	    }

	    return res;
	}
	private List<String> merge(List<String> l1, String s2) {
	  List<String> r = new ArrayList();
	  for (int i=0; i<l1.size(); i++) {
	    for (int j=0; j<s2.length(); j++) {
	      r.add(l1.get(i) + s2.charAt(j));
	    }
	  }
	  return r;
	}

	public List<String> letterCombinations2(String digits) {
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc"); map.put(3, "def"); map.put(4, "ghi");
        map.put(5, "jkl"); map.put(6, "mno"); map.put(7, "pqrs");
        map.put(8, "tuv"); map.put(9, "wxyz");
        
        int l = digits.length();
        List<String> list = new ArrayList<>();
        for (int i=0; i<l; i++) {
        	list.add(map.get(digits.charAt(i) - '0')); 
        }
        
        List<String> result = new ArrayList<>();
        result.add("");
        
        List<String> result2 = null;
        for (String s : list) {
        	l = s.length();
        	result2 = new ArrayList<>();
        	for (int i=0; i<l; i++) {
        		for (String res : result) {
            		result2.add(res + s.charAt(i));
            	}
        	}
        	result = result2;
        }
        
        System.out.println(result2);
        
        return null;
    }
	
	public List<String> letterCombinations(String digits) {
		int l = digits.length();
		if (l == 0) return new ArrayList();
		String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		
		Queue<String> q = new LinkedList<String>();
		q.add("");
		
		List<String> result = new ArrayList();
		while (!q.isEmpty()) {
			String pop = q.remove();
			
			if (pop.length() == l) result.add(pop);
			else {
				String mapping = map[digits.charAt(pop.length())-'0'];
				int lMap = mapping.length();
				for (int i=0; i<lMap; i++) {
					q.add(pop + mapping.charAt(i));
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		String digits = "23";
		Q17_LetterCombination q = new Q17_LetterCombination();
		List<String> res = q.letterCombinations(digits);
		System.out.println(res);
	}
	
//	ab -> a b
//	de
//	
//	ad ae bd be
//	gh
//	
//	adg adh aeg aeh bdg bdh beg beh
	
}
