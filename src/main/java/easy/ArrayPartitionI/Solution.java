package easy.ArrayPartitionI;

import java.util.Arrays;

public class Solution {
    /**
     *
     * @param nums
     * @return
     * 通过排序，这样每组两个值之间的总差距最小
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int len = nums.length;
        for(int i=0;i<len;i++){
            if(i%2==0){
                ans+=nums[i];
            }
        }
        return ans;

    }
    public static void main(String[] args){
        int[] nums = {1,2,3,5,6};
        System.out.println(new Solution().arrayPairSum(nums));
    }
}
