package medium.CustomSortString;

import java.util.HashMap;
import java.util.Scanner;

/**
 * S and T are strings composed of lowercase letters. In S, no letter occurs more than once.
 *
 * S was sorted in some custom order previously. We want to permute the characters of T so that they match the order that S was sorted. More specifically, if x occurs before y in S, then x should occur before y in the returned string.
 *
 * Return any permutation of T (as a string) that satisfies this property.
 *
 * Example :
 * Input:
 * S = "cba"
 * T = "abcd"
 * Output: "cbad"
 * Explanation:
 * "a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a".
 * Since "d" does not appear in S, it can be at any position in T. "dcba", "cdba", "cbda" are also valid outputs.
 *
 *
 *
 * Note:
 *
 *     S has length at most 26, and no character is repeated in S.
 *     T has length at most 200.
 *     S and T consist of lowercase letters only.
 */
public class Solution {
    public String customSortString(String S, String T) {
        String s = "";
        String ans = "";
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        int sLen = S.length();
        int tLen = T.length();
        for(int i = 0;i<sLen;i++){
            map.put(S.charAt(i),0);
        }
        for(int j = 0;j<tLen;j++){
            if(map.containsKey(T.charAt(j))){
                map.put(T.charAt(j),map.get(T.charAt(j))+1);
            }
            else{
                s+=T.charAt(j);
            }
        }
        for(int i = 0;i<sLen;i++){
            int t = map.get(S.charAt(i));
            for(int j = 0;j<t;j++){
                ans += S.charAt(i);
            }
        }
        ans += s;
        return ans;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String S = scanner.nextLine();
        String T = scanner.nextLine();
        System.out.println(new Solution().customSortString(S,T));
    }
}
