package medium.ProductofArrayExceptSelf;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 *
 * Example:
 *
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 *
 * Note: Please solve it without division and in O(n).
 *
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 */

/**
 * 思路，需要考虑几种情况，这个是除当前元素外的所有积即为新元素，分为有0和没有0的情况：
 * 没有零则需要求积然后除以相应元素即相应位置的值；
 * 有0，分为多个0和一个0的区别，多个零则全部元素为0，一个0，则除0所在位置以外全为0，0对应的值为非零值的积
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {

        int multi = 1;
        //首先要计0的个数
        int zeroN = 0;
        int sumWithOutZero=1;
        int index = -1;
        int len = nums.length;
        for(int i=0;i<len;i++){
            if(nums[i]==0){
                zeroN++;
                index = i;
            }
            else{
                sumWithOutZero*=nums[i];
            }
        }
        if(zeroN==1){
            nums[index] = sumWithOutZero;
            for(int i = 0;i<len;i++){
                if(i!=index){
                    nums[i]=0;
                }
            }
        }
        else {
            for (int i = 0; i < len; i++) {
                multi = multi * nums[i];
            }
            for (int i = 0; i < len; i++) {
                if(nums[i]!=0)
                    nums[i] = multi / nums[i];
            }
        }
        return nums;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().split(" ");
        int strLen = str.length;
        int[] nums = new int[strLen];
        for(int i=0;i<strLen;i++){
            nums[i] = Integer.valueOf(str[i]);
        }
        System.out.println(Arrays.toString(new Solution().productExceptSelf(nums)));
    }
}
