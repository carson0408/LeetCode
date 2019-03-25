package hard.MedianofTwoSortedArrays;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 * Example 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 */
public class Solution {
    /**
     * 有序数列的合并
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double ans = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = nums1.length+nums2.length;
        int[] nums = new int[len];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i<len1&&j<len2){
            if(nums1[i]<=nums2[j]){
                nums[k++]=nums1[i++];
            }
            else{
                nums[k++] = nums2[j++];
            }
        }
        while(i<len1){
            nums[k++] = nums1[i++];
        }
        while(j<len2){
            nums[k++] = nums2[j++];
        }
        if(len%2==1){
            ans = nums[(len-1)/2];
        }
        else{
            ans = (nums[(len-1)/2]+nums[len/2])/2.0;
        }
        return ans;
    }
    public static void main(String[] args){
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        System.out.println(new Solution().findMedianSortedArrays(nums1,nums2));
    }
}
