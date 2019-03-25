package medium.NextGreaterElementII;

import java.util.Arrays;

/**
 *  Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.
 *
 * Example 1:
 *
 * Input: [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2;
 * The number 2 can't find next greater number;
 * The second 1's next greater number needs to search circularly, which is also 2.
 *
 * Note: The length of given array won't exceed 10000.
 * Accepted
 * 45,652
 * Submissions
 * 90,793
 */
public class Solution {
    /**
     *
     * @param nums
     * @return
     * 解题思路：注意极端情况，注意循环
     */
    public int[] nextGreaterElements(int[] nums) {
        if(nums==null||nums.length==0)
            return new int[0];
        int[] ans = new int[nums.length];
        int numsLen = nums.length;

        int max = nums[0];
        for(int i = 1;i<numsLen;i++){
            if(nums[i]>max){
                max = nums[i];
            }
        }

        for(int i = 0;i<numsLen;i++){
            if(nums[i]==max){
                ans[i] = -1;
                continue;
            }
            int j = i+1;
            while(true){
                if(nums[j%numsLen]>nums[i]){
                    ans[i] = nums[j%numsLen];
                    break;
                }
                else{
                    j++;
                }

            }
        }
        return ans;
    }
    public static void main(String[] args){
        int[] nums = {1,2,1};
        System.out.println(Arrays.toString(new Solution().nextGreaterElements(nums)));
    }
}
