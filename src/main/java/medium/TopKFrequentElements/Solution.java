package medium.TopKFrequentElements;

import java.util.*;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 * Note:
 *
 *     You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 *     Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        List<Integer> result = new ArrayList<Integer>();
        int len = nums.length;
        for(int i=0;i<len;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }
            else{
                map.put(nums[i],1);
            }
        }

        List<Map .Entry<Integer,Integer>> arrayList = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        Collections.sort(arrayList, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        for(int i =0;i<k&&i<arrayList.size();i++){
            String[] temp = arrayList.get(i).toString().split("=");
            result.add(Integer.valueOf(temp[0]));
        }
        return result;

    }
    public static void main(String[] args){
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        List<Integer> list =  new Solution().topKFrequent(nums,k);
        for(int i = 0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }

    }
}


