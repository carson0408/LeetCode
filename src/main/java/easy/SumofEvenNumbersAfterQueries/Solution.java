package easy.SumofEvenNumbersAfterQueries;

public class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int len = queries.length;
        int[] ans = new int[len];
        int aLen = A.length;
        for(int i =0;i<len;i++){
            A[queries[i][1]] += queries[i][0];
            int tmp = 0;
            for(int j =0;j<aLen;j++){
                if(A[j]%2==0){
                    tmp+=A[j];
                }
            }
            ans[i] = tmp;
        }
        return ans;
    }
}
