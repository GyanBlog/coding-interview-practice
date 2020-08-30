package com.gyanblog.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q22_GenerateParenthesis {

	private Set<String> generate(int num) {
        if (num == 1) {
            Set<String> set = new HashSet<String>();
            set.add("()");
            return set;
        }

        Set<String> res = generate(num-1);
        Set<String> res2 = new HashSet();
        for (String s : res) {
            int l = s.length();
            res2.add("()" + s);
            for (int i=0; i<l; i++) {
                if (s.charAt(i) == '(') {
                    res2.add(s.substring(0, i+1) + "()" + s.substring(i+1));
                }
            }
        }

        return res2;
    }

    public List<String> generateParenthesis(int n) {
        return new ArrayList(generate(n));
    }
    
    private void dfs(List<String> res, String str, int open, int close) {
    	if (open > close) return;
    	if (open == 0 && close == 0) {
    		res.add(str);
    		return;
    	}
    	
    	if (open > 0)
    		dfs(res, str + "(", open-1, close);
    	
    	if (close > 0)
    		dfs(res, str + ")", open, close-1);
	}

	public List<String> generateParenthesis2(int n) {
		List<String> res = new ArrayList<>();
		dfs(res, "", n, n);
		return res;
	}
    

    public static void main(String[] args) {
		Q22_GenerateParenthesis q = new Q22_GenerateParenthesis();
		List<String> res = q.generateParenthesis2(3);
		System.out.println(res);
	}
}
