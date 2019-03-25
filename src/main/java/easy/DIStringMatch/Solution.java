package easy.DIStringMatch;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public int[] diStringMatch(String S) {
        int n = S.length();
        int[] ans = new int[n+1];
        int i = 0;
        int k =0;
        int up = n;
        for(int j=0;j<n;j++){
            if(S.charAt(j)=='I'){
                ans[i++]=k++;
            }
            else{
                ans[i++]=up--;
            }
        }
        ans[i++]=k;
        return ans;
    }
    public static void main(String[] args){
        Scanner scanner  = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(Arrays.toString(new Solution().diStringMatch(str)));
    }
}
