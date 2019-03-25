package medium.MinimumMovestoEqualArrayElementsII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given a non-empty integer array, find the minimum number of moves required to make all array elements equal, where a move is incrementing a selected element by 1 or decrementing a selected element by 1.
 *
 * You may assume the array's length is at most 10,000.
 *
 * Example:
 *
 * Input:
 * [1,2,3]
 *
 * Output:
 * 2
 *
 * Explanation:
 * Only two moves are needed (remember each move increments or decrements one element):
 *
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 */
public class Solution {
    public int minMoves2(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        int len = nums.length;
        List<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<len;i++){
            if(!list.contains(nums[i])){
                list.add(nums[i]);
            }
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }
            else{
                map.put(nums[i],1);
            }
        }
        long ans = Integer.MAX_VALUE;
        int listLen = list.size();
        for(int i=0;i<listLen;i++){
            long temp = 0;
            for(int j = 0;j<listLen;j++){
                if(i!=j){
                    temp+=Math.abs(list.get(j)-list.get(i))*map.get(list.get(j));
                }
            }
            ans = Math.min(temp,ans);
        }
        return (int)ans;


    }
    public static void main(String[] args){
        int[] nums = {203125577,-349566234,230332704,48321315,66379082,386516853,50986744,-250908656,-425653504,-212123143};
        System.out.println(new Solution().minMoves2(nums));
    }
}
