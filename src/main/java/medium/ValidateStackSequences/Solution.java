package medium.ValidateStackSequences;

import java.util.Stack;

/**
 * Given two sequences pushed and popped with distinct values, return true if and only if this could have been the result of a sequence of push and pop operations on an initially empty stack.
 *
 *
 *
 * Example 1:
 *
 * Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * Output: true
 * Explanation: We might do the following sequence:
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 *
 * Example 2:
 *
 * Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * Output: false
 * Explanation: 1 cannot be popped before 2.
 *
 *
 *
 * Note:
 *
 *     0 <= pushed.length == popped.length <= 1000
 *     0 <= pushed[i], popped[i] < 1000
 *     pushed is a permutation of popped.
 *     pushed and popped have distinct values.
 */
public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int pushLen = pushed.length;
        int popLen = popped.length;
        Stack<Integer> stack = new Stack<Integer>();
        int k = 0;
        //模拟出入栈
        for(int i=0;i<pushLen;i++){
            if(pushed[i]==popped[k]){
                k++;
                while(!stack.isEmpty()&&k<popLen){
                    if(stack.peek()==popped[k]){
                        stack.pop();
                        k++;
                    }
                    else{
                        break;
                    }
                }
            }
            else{
                stack.add(pushed[i]);
            }
        }
        if(stack.isEmpty())
            return true;
        return false;

    }
    public static void main(String[] args){
        int[] pushed = {1,2,3,4,5};
        int[] poped = {4,3,5,2,1};
        System.out.println(new Solution().validateStackSequences(pushed,poped));
    }
}
