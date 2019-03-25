package medium.Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        permutation(nums,list);

        return list;


    }
    public static void permutation(int[] nums,List<List<Integer>> list){
        if(nums==null||nums.length==0)
            return;
        List<Integer> temp = new ArrayList<Integer>();
        int len = nums.length;
        for(int i=0;i<len;i++){
            temp.add(nums[i]);
        }
        list.add(new ArrayList<Integer>(temp));
        //list.add(temp);
        for(int i=len-1;i>=0;i--){//为保证字典序，从右往左遍历
            boolean flag = false;
            int index = -1;
            for(int j=i+1;j<len;j++){//寻找i+1及以后比num[i]大且最小的元素
                if(nums[j]>nums[i]){
                    if(index==-1){
                        index = j;
                    }
                    else{
                        if(nums[j]<nums[index]){
                            index = j;
                        }
                    }
                    flag = true;

                }
            }
            if(flag){
                swap(nums,i,index);
                Arrays.sort(nums,i+1,len);
                permutation(nums,list);
            }
        }
    }
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args){
        int[] nums = {0,-1,1};
        List<List<Integer>> list = new Solution().permute(nums);
        for(int i = 0;i<list.size();i++){
            List<Integer> temp = list.get(i);
            for(int j = 0;j<temp.size();j++){
                System.out.print(temp.get(j)+" ");
            }
            System.out.println();
        }
    }

}
