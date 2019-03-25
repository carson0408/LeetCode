package medium.IntervalListIntersections;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.
 *
 * Return the intersection of these two interval lists.
 *
 * (Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)
 *
 *
 *
 * Example 1:
 *
 * Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
 * Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 * Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.
 */
public class Solution {
    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        int aLen = A.length;
        int bLen = B.length;
        List<Interval> list = new ArrayList<Interval>();
        for(int i=0;i<aLen;i++){
            for(int j = 0;j<bLen;j++){
                int left = Math.max(A[i].start,B[j].start);
                int right = Math.min(A[i].end,B[j].end);
                if(left<=right){
                    Interval interval = new Interval(left,right);
                    list.add(interval);
                }
            }
        }
        Interval[] ans = new Interval[list.size()];
        for(int i =0;i<list.size();i++){
            ans[i] = list.get(i);
        }
        return ans;

    }
}
