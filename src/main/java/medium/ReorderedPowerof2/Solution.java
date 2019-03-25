package medium.ReorderedPowerof2;

import java.util.*;

public class Solution {
    public boolean reorderedPowerOf2(int N) {
        List<Integer> list = new ArrayList<Integer>();
        while(N>0){
            list.add(N%10);
            N/=10;
        }
        int listLen = list.size();
        System.out.println();
        int temp = 1;
        List<Integer> out = new ArrayList<Integer>();
        int size = (temp+"").length();
        boolean flag = true;
        Collections.sort(list);
        out:
        while(size<=list.size()){
            flag = true;

            out = new ArrayList<Integer>();
            if(listLen==size){
                while(temp>0){
                    out.add(temp%10);
                    temp/=10;
                }

                Collections.sort(out);
                for(int i =0;i<listLen;i++){
                    if(list.get(i)!=out.get(i)){

                        flag = false;
                    }
                    else{
                        flag = false;
                    }
                }

            }
            temp = temp*2;
            size = (temp+"").length();

        }
        return flag;

    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        System.out.println(new Solution().reorderedPowerOf2(N));
    }
}
