package com.gyanblog.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Q30_SubstringConcatWords {
	
	public List<Integer> findSubstring(String s, String[] words) {
		ArrayList<Integer> result = new ArrayList<Integer>();
	    if (s == null || s.length() == 0 || words == null || words.length == 0){
	        return result;
	    }
	    
		Map<String, Integer> map = new HashMap<>();
		for (String word : words) {
			if (map.containsKey(word)) {
				map.put(word, map.get(word) + 1);
			}
			else {
				map.put(word, 1);
			}
		}
		
		int totalWords = words.length;
		int sLen = s.length();
		int wLen = words[0].length();
		int totalCharsToMatch = wLen * words.length;
		for (int i=0; i<=sLen-totalCharsToMatch; i++) {
			Map<String, Integer> tMap = new HashMap<>(map);
			
			int wordsToMatch = totalWords;
			for (int j=i; j<=sLen-wLen; j += wLen) {
				String w = s.substring(j, j+wLen);
				if (!tMap.containsKey(w) || tMap.get(w) == 0) {
					//not found, or frequency not matched...
					break;
				}
				
				tMap.put(w, tMap.get(w)-1);
				wordsToMatch --;
			}
			
			if (wordsToMatch == 0) {
				result.add(i);
			}
		}
		
		return result;
	}

	private List<String> combineWords(String cWord, String word, int wLen) {
		Set<String> res = new HashSet<>();
		
		int l = cWord.length();
		for (int i=0; i<=l;) {
			res.add(cWord.substring(0, i) + word + cWord.substring(i));
			i += wLen;
		}
		return new ArrayList<>(res);
	}
	
	private List<String> getWordCombinations(String[] words) {
		if (words.length == 0) return new ArrayList<>();
		int wLen = words[0].length();
		
		Set<String> res = new HashSet<>();
		res.add(words[0]);
		for (int i=1; i<words.length; i++) {
			Set<String> res2 = new HashSet<>();
			for (String s : res) {
				res2.addAll(this.combineWords(s, words[i], wLen));
				System.out.println(res2);
			}
			
			res = res2;
		}
		
		return new ArrayList<>(res);
	}
	
	public List<Integer> findSubstring2(String s, String[] words) {
        List<String> combs = this.getWordCombinations(words);
        System.out.println(combs);
        
        Set<Integer> positions = new HashSet<>();
        for (String c : combs) {
        	int pos = s.indexOf(c);
        	while (pos != -1) {
        		positions.add(pos);
        		pos = s.indexOf(c, pos+1);
        	}
        }
        
		return new ArrayList<>(positions);
    }
	
	public static void main(String[] args) {
		Q30_SubstringConcatWords q = new Q30_SubstringConcatWords();
		
		String s = "wordgoodgoodgoodbestword";
		String[] words = {"word","good","best","good"}; 
		
		List<Integer> res = q.findSubstring2(s, words);
		System.out.println(res);
	}
}

