package medium.StringtoIntegeratoi;

import java.util.Scanner;

/**
 * Implement atoi which converts a string to an integer.
 *
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
 *
 * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 *
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 *
 * If no valid conversion could be performed, a zero value is returned.
 *
 * Note:
 *
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 * Example 1:
 *
 * Input: "42"
 * Output: 42
 * Example 2:
 *
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign.
 *              Then take as many numerical digits as possible, which gets 42.
 * Example 3:
 *
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 * Example 4:
 *
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical
 *              digit or a +/- sign. Therefore no valid conversion could be performed.
 * Example 5:
 *
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 *              Thefore INT_MIN (−231) is returned.
 */
public class Solution {

    public int myAtoi(String str) {
        str = str.trim();
        String ans = "";
        if(str=="")
            return 0;
        int len = str.length();
        boolean flag = false;
        if(str.charAt(0)=='-'){
            flag = true;
            ans+="-";
            str = str.substring(1);
            len = len-1;
        }
        if(str.charAt(0)=='+'){

            ans+="+";
            str = str.substring(1);
            len = len-1;
        }
        int i = 0;
        while(i<len){
            if(str.charAt(i)>='0'&&str.charAt(i)<='9'){
                ans+=str.charAt(i);
                i++;
            }
            else{
                break;
            }
        }
        if(ans.equals("")||ans.equals("-")||ans.equals("+"))
            return 0;
        String INT_MAX= "2147483647";
        String INT_MIN = "-2147483648";
        if(!flag) {
            int comMax = compare(ans, INT_MAX);
            if(comMax==1)
                return 2147483647;
            else
                return Integer.parseInt(ans);
        }
        int comMin = -compare(ans,INT_MIN);
        if(comMin==-1)
            return -2147483648;

        return Integer.parseInt(ans);

    }
    public static int compare(String s1,String s2){
        int l1 = s1.length();
        int l2 = s2.length();
        if(l1>l2)
            return 1;
        else if(l1<l2)
            return -1;
        else{

            int i =0;
            while(i<l1){
                if(s1.charAt(i)>s2.charAt(i)){
                    return 1;
                }
                else if(s1.charAt(i)<s2.charAt(i))
                    return -1;
                else{
                    i++;
                }
            }
            return 0;
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(new Solution().myAtoi(str));
    }

}
