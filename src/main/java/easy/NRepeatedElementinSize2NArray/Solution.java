package easy.NRepeatedElementinSize2NArray;

import java.util.Arrays;

public class Solution {
    public int repeatedNTimes(int[] A) {
        Arrays.sort(A);
        int mid = (A.length)/2;
        int left = mid-1;
        if(A[left]==A[left-1])
            return A[left];
        return A[mid];

    }
    public static void main(String[] args){
        int[] A = {1,2,3,3};
        int[] A1 = {2,1,2,5,3,2};
        int[] A2 = {1,1,1,2,3,4};
        int[] A3={5,1,5,2,5,3,5,4};
        System.out.println(new Solution().repeatedNTimes(A3));
    }
}
