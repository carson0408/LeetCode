package medium.LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        HashMap<Character,Integer> map = new HashMap();//map键存储字符，而值存储下标，一旦有重复则只需要将重复下标相减即可。
        int ans = 0;//记录连续不重复字符长度
        int t = 0;//t则记录最新的重复点
        for(int i =0;i<len;i++){
            char tmp = s.charAt(i);
            if(!map.containsKey(tmp)){
                map.put(tmp,i);
                ans = Math.max(ans,i-t+1);//t以后没有重复则每次更新长度值
            }
            else{
                int length = 0;
                if(map.get(tmp)>=t) {
                    length = i - map.get(tmp);
                    length = Math.max(length,map.get(tmp)-t+1);//以上两行则是以map.get(tmp)为中点比较前后连续长度哪个长。
                    length = Math.max(length,i-1-t+1);
                    t = map.get(tmp)+1;
                }

                else
                    length = i - t;

                map.put(tmp,i);
                ans = Math.max(length,ans);
            }
        }
        ans = Math.max(ans,len -t);
        return ans;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(new Solution().lengthOfLongestSubstring(s));
    }
}
