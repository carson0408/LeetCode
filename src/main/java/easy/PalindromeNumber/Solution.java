package easy.PalindromeNumber;

import java.util.Scanner;

public class Solution {
    public boolean isPalindrome(int x) {

        StringBuilder stringBuilder = new StringBuilder(x+"");
        if(stringBuilder.toString().equals(stringBuilder.reverse().toString()))
            return true;
        return false;

    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        System.out.println(new Solution().isPalindrome(x));
    }
}
