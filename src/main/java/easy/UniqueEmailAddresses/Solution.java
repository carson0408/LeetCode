package easy.UniqueEmailAddresses;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public int numUniqueEmails(String[] emails) {
        //特殊情况的考虑
        if(emails.length==0||emails==null)
            return 0;
        int len = emails.length;
        HashSet<String> set = new HashSet<String>();
        //根据规则判断处理
        for(int i=0;i<len;i++){
            String tmp = emails[i];
            String[] strs = tmp.split("@");
            String first = strs[0];
            String second = strs[1];
            int fLen = first.length();
            String newFirst="";

            for(int j=0;j<fLen;j++){
                if(first.charAt(j)=='+'){
                    break;
                }
                else if(first.charAt(j)=='.'){
                    continue;
                }
                else{
                    newFirst = newFirst+first.charAt(j);
                }
            }


            String newString = newFirst+"@"+second;
            set.add(newString);
            System.out.println(newString);


        }

        return set.size();

    }
    public static void main(String[] args){
        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(new Solution().numUniqueEmails(emails));
    }
}
