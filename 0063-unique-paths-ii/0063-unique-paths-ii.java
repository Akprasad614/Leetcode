class Solution {
    int[][] dp;
    int countPath(int m,int n,int[][] obstacleGrid){
        if(obstacleGrid[0][0] == 1){
            return 0;
        }
        dp[0][0] = 1;
        for(int i =0;i<m; i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0) continue;

                if(obstacleGrid[i][j] == 1){
                    dp[i][j] =0;
                    continue;
                }
                int up = 0;
                int left = 0;

                if(i>0) up = dp[i-1][j];
                if(j>0) left = dp[i][j-1];
                dp[i][j] = left + up;
            }
        }
        return dp[m-1][n-1];
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        dp = new int[m][n];
        return countPath(m,n,obstacleGrid);
    }
}

// class Solution {
//     int[] prev;
//     int countPath(int m,int n,int[][] obstacleGrid){
//         dp[0][0] = 1;
//         for(int i =0;i<m; i++){
//             for(int j=0;j<n;j++){
//                 if(i==0 && j==0) continue;
//                 int up = 0;
//                 int left = 0;

//                 if(i>0 && obstacleGrid[m][n] != 1) up = dp[i-1][j];
//                 if(j>0 &&obstacleGrid[m][n] != 1) left = dp[i][j-1];
//                 dp[i][j] = left + up;
//             }
//         }
//         return dp[m-1][n-1];
//     }
//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         int m = obstacleGrid.length;
//         int n = obstacleGrid[0].length;
//         dp = new int[n];
//         return countPath(m-1,n-1,obstacleGrid);
//     }
// }


// class Solution {
//     int[][] dp;
//     int countPath(int m,int n,int[][] obstacleGrid){
//         if(m < 0 || n < 0 || obstacleGrid[m][n] == 1){
//             return 0;
//         }
            
//         if(m == 0 && n == 0){
//             return 1;
//         }
//         if(dp[m][n] != -1){
//             return dp[m][n];
//         }
//         int up = countPath(m-1,n,obstacleGrid);
//         int left = countPath(m,n-1,obstacleGrid);
//         return dp[m][n] = left + up;
//     }
//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         int m = obstacleGrid.length;
//         int n = obstacleGrid[0].length;
//         dp = new int[m][n];
//         for(int[] rows : dp){
//            Arrays.fill(rows,-1);
//         }
//         return countPath(m-1,n-1,obstacleGrid);
//     }
// }


