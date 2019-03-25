package medium.LongestPalindromicSubstring;

import java.util.Scanner;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 */
public class Solution {
    /**
     * 最大回文串的求解
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        StringBuffer stringBuffer = null;
        String ans = "";
        int len = s.length();
        int length = 0;
        for(int i = 0;i<len;i++){
            for(int j = i+1;j<=len;j++){
                stringBuffer = new StringBuffer(s.substring(i,j));
                if(stringBuffer.toString().equals(stringBuffer.reverse().toString())){
                    if(j-i>length){
                        ans = stringBuffer.toString();
                        length = j-i;
                    }
                }
                stringBuffer = null;
            }
        }

        return ans;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(new Solution().longestPalindrome(s));
    }
}
