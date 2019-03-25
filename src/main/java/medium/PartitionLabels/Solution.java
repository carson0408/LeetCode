package medium.PartitionLabels;

import java.util.*;

/**
 *  A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.
 *
 * Example 1:
 *
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 *
 * Note:
 *
 *     S will have length in range [1, 500].
 *     S will consist of lowercase letters ('a' to 'z') only.
 */
public class Solution {
    /**
     * O(2n)
     * @param S
     * @return
     */
    public List<Integer> partitionLabels(String S) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        List<Integer> list = new ArrayList<Integer>();
        int sLen = S.length();
        for(int i=0;i<sLen;i++){
            map.put(S.charAt(i),i);
        }
        int index = 0;
        int tmp = 0;
        for(int i = 0;i<sLen;i++){
            index = Math.max(index,map.get(S.charAt(i)));
            tmp++;
            if(index==i){
                list.add(tmp);
                tmp=0;
            }
        }
        return list;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String S = scanner.nextLine();
        System.out.println(Arrays.toString(new Solution().partitionLabels(S).toArray()));
    }
}
