package medium.RandomPickIndex;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Given an array of integers with possible duplicates, randomly output the index of a given target number. You can assume that the given target number must exist in the array.
 *
 * Note:
 * The array size can be very large. Solution that uses too much extra space will not pass the judge.
 *
 * Example:
 *
 * int[] nums = new int[] {1,2,3,3,3};
 * Solution solution = new Solution(nums);
 *
 * // pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
 * solution.pick(3);
 *
 * // pick(1) should return 0. Since in the array only nums[0] is equal to 1.
 * solution.pick(1);
 */
public class Solution {
    private final int[] nums;

    public Solution(int[] nums) {
        this.nums=nums;

    }

    /**
     *
     * @param target
     * @return
     * 解题思路：就是一个随机数的获取，new Random().nextInt(获取最大值+1);
     */
    public int pick(int target) {
        int numsLen = nums.length;
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<numsLen;i++){
            if(nums[i]==target){
                list.add(i);
            }
        }
        Random r = new Random();

        return  list.get(r.nextInt(list.size()));
    }
    public static void main(String[] args){
        int[] nums = new int[]{1,2,3,3,3};
        Solution s = new Solution(nums);
        System.out.println(s.pick(3));

    }
}
