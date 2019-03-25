package easy.RobotReturntoOrigin;

import java.util.Scanner;

public class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        int len = moves.length();
        for(int i =0;i<len;i++){
            if(moves.charAt(i)=='L'){
                x-=1;
            }
            else if(moves.charAt(i)=='R'){
                x+=1;
            }
            else if(moves.charAt(i)=='U'){
                y+=1;
            }
            else{
                y-=1;
            }
        }
        if(x==0&&y==0)
            return true;
        return false;

    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String moves = scanner.nextLine();
        System.out.println(new Solution().judgeCircle(moves));
    }
}
