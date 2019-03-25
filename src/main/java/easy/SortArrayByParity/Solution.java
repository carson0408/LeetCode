package easy.SortArrayByParity;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    public int[] sortArrayByParity(int[] A) {
        int left = 0;
        int right = A.length-1;
        while(left<right){
            if(A[left]%2==1&&A[right]%2==0){
                int tmp = A[left];
                A[left] = A[right];
                A[right] = tmp;
            }
            else if(A[left]%2==0){
                left++;
            }
            else{
                right--;
            }
        }
        return A;
    }

    public static void main(String[] args){
        int[] A = {3,1,2,4};
        System.out.println(Arrays.toString(new Solution().sortArrayByParity(A)));
    }
}
