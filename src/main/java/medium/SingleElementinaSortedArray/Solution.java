package medium.SingleElementinaSortedArray;

import java.util.Scanner;

/**
 *  Given a sorted array consisting of only integers where every element appears twice except for one element which appears once. Find this single element that appears only once.
 *
 * Example 1:
 *
 * Input: [1,1,2,3,3,4,4,8,8]
 * Output: 2
 *
 * Example 2:
 *
 * Input: [3,3,7,7,10,11,11]
 * Output: 10
 *
 * Note: Your solution should run in O(log n) time and O(1) space.
 */
public class Solution {
    public int singleNonDuplicate(int[] nums) {
        int ans = 0;
        int len = nums.length;
        for(int i=0;i<len;i++){
            ans = ans^nums[i];
        }
        return ans;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] strs = scanner.nextLine().split(" ");
        int len = strs.length;
        int[] nums = new int[len];
        for(int i=0;i<len;i++){
            nums[i]  = Integer.valueOf(strs[i]);
        }
        System.out.println(new Solution().singleNonDuplicate(nums));
    }
}
