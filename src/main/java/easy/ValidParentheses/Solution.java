package easy.ValidParentheses;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack stack = new Stack();
        HashMap<Character,Character> map = new HashMap<Character, Character>();
        map.put('(',')');
        map.put(')','(');
        map.put('{','}');
        map.put('}','{');
        map.put('[',']');
        map.put(']','[');
        int len = s.length();
        for(int i=0;i<len;i++){
            if(stack.empty()){
                stack.add(s.charAt(i));
            }
            else if(map.get( stack.peek())==s.charAt(i)){
                stack.pop();
            }
            else{
                stack.add(s.charAt(i));
            }
        }
        if(stack.empty())
            return true;
        return false;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(new Solution().isValid(str));
    }
}
