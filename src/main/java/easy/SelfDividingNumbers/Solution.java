package easy.SelfDividingNumbers;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = left;i<=right;i++){
            boolean flag = true;
            int t = i;
            while(t>0){
                int tmp = t%10;
                t = t/10;
                if(tmp==0||i%tmp!=0){
                    flag = false;
                }
            }
            if(flag){
                list.add(i);
            }
        }
        return list;

    }
}
