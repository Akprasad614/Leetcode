class Solution {
    int[][] dp;
    int countPath(int m,int n){
        if(m < 0 || n < 0){
            return 0;
        }
        if(m == 0 && n == 0){
            return 1;
        }
        if(dp[m][n] != -1){
            return dp[m][n];
        }
        int up = countPath(m-1,n);
        int left = countPath(m,n-1);
        return dp[m][n] = left + up;
    }
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        for(int[] rows : dp){
           Arrays.fill(rows,-1);
        }
        return countPath(m-1,n-1);
    }
}