package medium.BeautifulArrangement;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array that is constructed by these N numbers successfully if one of the following is true for the ith position (1 <= i <= N) in this array:
 *
 *     The number at the ith position is divisible by i.
 *     i is divisible by the number at the ith position.
 *
 *
 *
 * Now given N, how many beautiful arrangements can you construct?
 *
 * Example 1:
 *
 * Input: 2
 * Output: 2
 * Explanation:
 *
 * The first beautiful arrangement is [1, 2]:
 *
 * Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).
 *
 * Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).
 *
 * The second beautiful arrangement is [2, 1]:
 *
 * Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).
 *
 * Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.
 *
 *
 *
 * Note:
 *
 *     N is a positive integer and will not exceed 15.
 */
public class Solution {


    public  int countArrangement(int N) {
        int[] num = new int[N];

        for(int i = 0;i<N;i++){
            num[i] = i+1;
        }
        int result=0;
        List<int[]> list = new ArrayList<int[]>();
        permutation(num,list);


        for(int i = 0;i<list.size();i++){
            int[] temp = list.get(i);
            boolean flag1 = true;
            System.out.println(Arrays.toString(temp));
            for(int j=0;j<N;j++) {
                if ((temp[j] % (j + 1) != 0) && ((j + 1) % temp[j] != 0)) {
                    flag1 = false;
                }
            }
            if(flag1)
                result++;
        }

        return result;


    }

    /**
     *
     * @param num
     *
     */

    public static void permutation(int[] num,List<int[]> list){
        if(num==null||num.length==0)
            return ;
        int n = num.length;

        int[] temp = new int[num.length];
        for(int i = 0;i<num.length;i++){
            temp[i] = num[i];
        }
        list.add(temp);
        //System.out.println(Arrays.toString(num));
        for(int i=n-1;i>=0;i--){//为保证字典序，从右往左遍历
            boolean flag = false;
            int index = -1;
            for(int j=i+1;j<n;j++){//寻找i+1及以后比num[i]大且最小的元素
                if(num[j]>num[i]){
                    if(index==-1){
                        index = j;
                    }
                    else{
                        if(num[j]<num[index]){
                            index = j;
                        }
                    }
                    flag = true;

                }
            }
            if(flag){
                swap(num,i,index);
                Arrays.sort(num,i+1,n);
                permutation(num,list);
            }
        }
    }
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }





    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        System.out.println(new Solution().countArrangement(N));

    }
}
