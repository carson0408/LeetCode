package medium.IntegertoRoman;

import java.util.Scanner;

public class Solution {
    public String intToRoman(int num) {
        int[] value = {1000,500,100,50,10,5,1};
        char[] symbol = {'M','D','C','L','X','V','I'};
        String ans = "";
        int i=0;
        if(num==4){
            ans+="IV";
            num=0;
        }
        if(num==9){
            ans+="IX";
            num=0;
        }
        if(num==40){
            ans+="XL";
            num=0;
        }
        if(num==90){
            ans+="XC";
            num=0;
        }
        if(num==400){
            ans+="CD";
            num=0;
        }
        if(num==900){
            ans+="CM";
            num=0;
        }
        while(num>0&&i<7){

            int t = num/value[i];
            int g = num%value[i];
            if(g==4){
                ans+="IV";
                break;
            }
            if(g==9){
                ans+="IX";
                break;
            }
            if(g==40){
                ans+="XL";
                break;
            }
            if(g==90){
                ans+="XC";
                break;
            }
            if(g==400){
                ans+="CD";
                break;
            }
            if(g==900){
                ans+="CM";
                break;
            }
            for(int j = 0;j<t;j++){
                ans+=symbol[i];
            }
            num = g;
            i++;

        }
        return ans;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(new Solution().intToRoman(num));
    }
}
