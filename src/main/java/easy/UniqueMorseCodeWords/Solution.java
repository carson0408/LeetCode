package easy.UniqueMorseCodeWords;

import java.util.HashSet;

public class Solution {
    //[".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
    public int uniqueMorseRepresentations(String[] words) {
        String[] refer = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> set = new HashSet<String>();
        int len = words.length;
        for(int i=0;i<len;i++){
            String tmp="";
            String pre = words[i];
            int pLen = pre.length();
            for(int j=0;j<pLen;j++){
                tmp+=refer[(int)pre.charAt(j)-97];
            }
            set.add(tmp);

        }
        return set.size();
    }
    public static void main(String[] args){
        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println(new Solution().uniqueMorseRepresentations(words));
    }
}
