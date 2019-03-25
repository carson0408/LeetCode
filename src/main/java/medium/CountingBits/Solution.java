package medium.CountingBits;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 *
 * Example 1:
 *
 * Input: 2
 * Output: [0,1,1]
 *
 * Example 2:
 *
 * Input: 5
 * Output: [0,1,1,2,1,2]
 *
 * Follow up:
 *
 *     It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
 *     Space complexity should be O(n).
 *     Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 */
public class Solution {
    public int[] countBits(int num) {
        int[] ans = new int[num+1];
        if(num==0)
            return ans;
        ans[1]=1;
        int k =0;
        for(int i = 2;i<=num;i++){
            int t = (int)Math.pow(2,k);
            int t1 = (int)Math.pow(2,k+1);

            if(i==t1){
                ans[i]=1;
                k++;
            }
            else{
                ans[i] = ans[t]+ans[i-t];
            }
        }
        return ans;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(Arrays.toString(new Solution().countBits(num)));
    }
}
