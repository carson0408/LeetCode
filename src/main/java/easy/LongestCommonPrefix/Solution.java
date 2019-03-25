package easy.LongestCommonPrefix;

import java.util.Scanner;

public class Solution {
    public String longestCommonPrefix(String[] strs) {

        //首先判断是否是空数组
        if(strs.length==0 || strs==null)
            return "";
        String temp = strs[0];
        String ans = "";
        int strsLen = strs.length;
        int minLen = Integer.MAX_VALUE;
        for(int i = 0;i<strsLen;i++){
            minLen = Math.min(minLen,strs[i].length());

        }
        boolean flag ;
        //逐个比较，用flag做标记位
        out:
        for(int i = 0;i<minLen;i++){
            flag = true;
            for(int j=1;j<strsLen;j++){
                if(temp.charAt(i)!=strs[j].charAt(i)){
                    flag = false;
                }
            }
            if(flag){
                ans +=temp.charAt(i)+"";
            }
            //一旦不同便跳出整个循环
            else{
                break out;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        //String str = scanner.nextLine();
        String[] strs = {"abc","cba","flight"};
        System.out.println(new Solution().longestCommonPrefix(strs));
    }
}
