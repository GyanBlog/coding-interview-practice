/* Adding CPP implementation of the problem: https://oj.leetcode.com/problems/string-to-integer-atoi/ */

/*
*Implementing function to convert string to an integer.

*If no valid conversion could be performed, a zero value is returned.

*If the correct value is out of the range of representable values, the maximum integer value (2147483647) or the minimum integer value (–2147483648) is returned.

*For more explanation, visit- https://www.gyanblog.com/gyan/coding-interview/leetcode-string-integer-atoi/
*/

class Solution {
public:
    int myAtoi(string str) {
        int sign=1, i=0;
        int maxdiv = INT_MAX/10;
        while (str[i]==' ')     i++;
        if (i<str.length() && str[i]=='+') i++;
        else if (i<str.length() && str[i]=='-') {
            sign=-1;
            i++;
        }
        int num=0;
        while (i<str.length()) {
            if (str[i]<'0' || str[i]>'9')
                return sign*num;
            int digit = str[i]-'0';
            if (num > maxdiv || num==maxdiv && digit>=8)
                return sign==1 ? INT_MAX : INT_MIN;
            num = num*10 + digit;
            i++;
        }
        return sign*num;
    }
};
