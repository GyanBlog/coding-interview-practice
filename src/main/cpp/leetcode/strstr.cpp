/* Adding CPP implementation of Problem : https://oj.leetcode.com/problems/implement-strstr/ */

/* Assuming n=length of haystack, m=length of needle, then -
O(nm) runtime, O(1) space complexity */

/* BRUTE FORCE: Scan the needle with the haystack from its first position and start matching all subsequent letters one by one.
If one of the letters does not match, we start over again with the next position in the haystack. */

class Solution {
public:
    int strStr(string haystack, string needle) {
        for (int i=0; ; i++) {
            for (int j=0; ; j++) {
                if (j == needle.length())   return i;
                if (i+j == haystack.length())   return -1;
                if (needle[j] != haystack[i+j])     break;
            }
        }      
    }
};