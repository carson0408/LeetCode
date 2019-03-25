package easy.TwoSum;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        int len = nums.length;
        for(int i=0;i<len;i++){
            int temp = nums[i];
            for(int j=i+1;j<len;j++){
                if(temp+nums[j]==target){
                    ans[0]=i;
                    ans[1]=j;
                    break;
                }
            }
        }
        return ans;

    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] strs = scanner.nextLine().split(" ");
        int[] nums = new int[strs.length];
        for(int i=0;i<strs.length;i++){
            nums[i] = Integer.parseInt(strs[i]);
        }
        int target = scanner.nextInt();
        System.out.println(Arrays.toString(new Solution().twoSum(nums,target)));
    }
}
