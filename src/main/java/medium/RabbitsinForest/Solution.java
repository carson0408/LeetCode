package medium.RabbitsinForest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * In a forest, each rabbit has some color. Some subset of rabbits (possibly all of them) tell you how many other rabbits have the same color as them. Those answers are placed in an array.
 *
 * Return the minimum number of rabbits that could be in the forest.
 *
 * Examples:
 * Input: answers = [1, 1, 2]
 * Output: 5
 * Explanation:
 * The two rabbits that answered "1" could both be the same color, say red.
 * The rabbit than answered "2" can't be red or the answers would be inconsistent.
 * Say the rabbit that answered "2" was blue.
 * Then there should be 2 other blue rabbits in the forest that didn't answer into the array.
 * The smallest possible number of rabbits in the forest is therefore 5: 3 that answered plus 2 that didn't.
 *
 * Input: answers = [10, 10, 10]
 * Output: 11
 *
 * Input: answers = []
 * Output: 0
 *
 * Note:
 *
 *     answers will have length at most 1000.
 *     Each answers[i] will be an integer in the range [0, 999].
 */
public class Solution {
    /**
     *
     * @param answers
     * @return
     * 这题就是个找规律的题目，先用map统计每种答案的个数，然后逐个取不同答案，获取其个数，如果个数小于等于答案+1，则说明这类颜色兔子为答案加1个
     * 否则，除以答案加1，获取对数，如果有余数则对数加1。然后对数*（答案+1），就是这个答案对应的兔子。
     */
    public int numRabbits(int[] answers) {
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        if(answers==null||answers.length==0)
            return 0;
        int ansLen = answers.length;
        int result = 0;
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0;i<ansLen;i++){
            if(map.containsKey(answers[i])){
                map.put(answers[i],map.get(answers[i])+1);
            }
            else{
                list.add(answers[i]);
                map.put(answers[i],1);
            }
        }
        int listLen = list.size();
        for(int i = 0;i<listLen;i++){
            int temp = map.get(list.get(i));
            if(temp<=(list.get(i)+1)){
                result+=(list.get(i)+1);
            }
            else{
                if(list.get(i)==0)
                    result+=temp;
                else {
                    int t = temp / (list.get(i)+1);
                    if (temp % (list.get(i)+1) > 0) {
                        t = t + 1;
                    }
                    result += (list.get(i) + 1) * t;
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        int[] answers = {0,0,1,1,1};
        System.out.println(new Solution().numRabbits(answers));
    }
}
