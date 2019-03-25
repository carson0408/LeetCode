package medium.MinimumAddtoMakeParenthesesValid;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * Given a string S of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or ')', and in any positions ) so that the resulting parentheses string is valid.
 *
 * Formally, a parentheses string is valid if and only if:
 *
 *     It is the empty string, or
 *     It can be written as AB (A concatenated with B), where A and B are valid strings, or
 *     It can be written as (A), where A is a valid string.
 *
 * Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.
 *
 *
 *
 * Example 1:
 *
 * Input: "())"
 * Output: 1
 *
 * Example 2:
 *
 * Input: "((("
 * Output: 3
 *
 * Example 3:
 *
 * Input: "()"
 * Output: 0
 *
 * Example 4:
 *
 * Input: "()))(("
 * Output: 4
 *
 *
 *
 * Note:
 *
 *     S.length <= 1000
 *     S only consists of '(' and ')' characters.
 *
 *
 */
public class Solution {
    public int minAddToMakeValid(String S) {
        Stack stack = new Stack();
        int len = S.length();
        for(int i=0;i<len;i++){
            if(stack.empty()){
                stack.add(S.charAt(i));
            }
            else if((Character) stack.peek()=='('&&S.charAt(i)==')'){
                stack.pop();
            }
            else{
                stack.add(S.charAt(i));
            }
        }
        return stack.size();

    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String S = scanner.nextLine();
        System.out.println(new Solution().minAddToMakeValid(S));
    }
}
