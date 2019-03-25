package medium.FindAllDuplicatesinanArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 *
 * Find all the elements that appear twice in this array.
 *
 * Could you do it without extra space and in O(n) runtime?
 *
 * Example:
 *
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [2,3]
 */
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int[] cal = new int[nums.length+1];//用数组下标为对应的数字，值为出现次数
        List<Integer> list = new ArrayList<Integer>();//存放重复数字。
        for(int i=0;i<nums.length;i++){
            cal[nums[i]]+=1;
        }
        for(int i=0;i<cal.length;i++){
            if(cal[i]>1)
                list.add(i);
        }
        return list;

    }
}
