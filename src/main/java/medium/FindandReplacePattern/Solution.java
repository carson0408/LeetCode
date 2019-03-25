package medium.FindandReplacePattern;

import java.util.*;

/**
 * You have a list of words and a pattern, and you want to know which words in words matches the pattern.
 *
 * A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.
 *
 * (Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.)
 *
 * Return a list of the words in words that match the given pattern.
 *
 * You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
 * Output: ["mee","aqq"]
 * Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}.
 * "ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation,
 * since a and b map to the same letter.
 *
 *
 *
 * Note:
 *
 *     1 <= words.length <= 50
 *     1 <= pattern.length = words[i].length <= 20
 */
public class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<String>();
        int size = words.length;
        for(int i = 0;i<size;i++){
            HashMap<Character,Character> map = new HashMap<Character, Character>();
            HashMap<Character,Character> map1 = new HashMap<Character, Character>();
            boolean flag = true;
            if(words[i].length()!=pattern.length())
                continue;
            String word = words[i];
            int len = word.length();
            for(int j = 0;j<len;j++){
                if(!map.containsKey(pattern.charAt(j))){
                    map.put(pattern.charAt(j),word.charAt(j));
                }
                else{
                    if(map.get(pattern.charAt(j))==word.charAt(j)) {
                        continue;
                    }
                    else{
                        flag = false;
                    }
                }
            }
            for(int j = 0;j<len;j++){
                if(!map1.containsKey(word.charAt(j))){
                    map1.put(word.charAt(j),pattern.charAt(j));
                }
                else{
                    if(map1.get(word.charAt(j))==pattern.charAt(j)) {
                        continue;
                    }
                    else{
                        flag = false;
                    }
                }
            }
            if(flag){
                list.add(words[i]);
            }
        }
        return list;
    }
    public static void main(String[] args){
        String[] words = {"ef","fq","ao","at","lx"};
        String pattern = "ya";
        System.out.println(Arrays.toString(new Solution().findAndReplacePattern(words,pattern).toArray()));

    }
}
