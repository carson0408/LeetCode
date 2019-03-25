package medium.PalindromicSubstrings;

import java.util.Scanner;

/**
 * Given a string, your task is to count how many palindromic substrings in this string.
 *
 * The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
 *
 * Example 1:
 *
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 *
 *
 *
 * Example 2:
 *
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 *
 *
 *
 * Note:
 *
 *     The input string length won't exceed 1000.
 */
public class Solution {
    public int countSubstrings(String s) {
        int sLen = s.length();
        int ans = 0;
        for(int i=0;i<sLen;i++){
            for(int j = i;j<sLen;j++){
                String s1 = s.substring(i,j+1);
                String s2 = new StringBuffer(s.substring(i,j+1)).reverse().toString();
                if(s1.equals(s2)){
                    ans++;
                }
            }
        }
        return ans;

    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(new Solution().countSubstrings(s));
    }
}
