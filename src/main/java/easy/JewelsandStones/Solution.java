package easy.JewelsandStones;

import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public int numJewelsInStones(String J, String S) {
        if(J==null||J==""||S==null||S=="")
            return 0;
        int ans = 0;
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        int sLen = S.length();
        for(int i = 0;i<sLen;i++){
            if(map.containsKey(S.charAt(i))){
                map.put(S.charAt(i),map.get(S.charAt(i))+1);

            }
            else{
                map.put(S.charAt(i),1);
            }
        }
        int jLen = J.length();
        for(int i =0;i<jLen;i++){
            if(map.containsKey(J.charAt(i))){
                ans += map.get(J.charAt(i));
            }
        }
        return ans;

    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String J = scanner.nextLine();
        String S = scanner.nextLine();
        System.out.println(new Solution().numJewelsInStones(J,S));
    }
}
