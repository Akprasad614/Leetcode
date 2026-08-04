class Solution {
    int[][] dp;
    int countPath(int m,int n){
        dp[0][0] = 1;
        for(int i =0;i<m; i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0) continue;
                int up = 0;
                int left = 0;

                if(i>0) up = dp[i-1][j];
                if(j>0) left = dp[i][j-1];
                dp[i][j] = left + up;
            }
        }
        return dp[m-1][n-1];
    }
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        return countPath(m,n);
    }
}


// class Solution {            // DP 
//     int[][] dp;
//     int countPath(int m,int n){
//         if(m < 0 || n < 0){
//             return 0;
//         }
//         if(m == 0 && n == 0){
//             return 1;
//         }
//         if(dp[m][n] != -1){
//             return dp[m][n];
//         }
//         int up = countPath(m-1,n);
//         int left = countPath(m,n-1);
//         return dp[m][n] = left + up;
//     }
//     public int uniquePaths(int m, int n) {
//         dp = new int[m][n];
//         for(int[] rows : dp){
//            Arrays.fill(rows,-1);
//         }
//         return countPath(m-1,n-1);
//     }
// }