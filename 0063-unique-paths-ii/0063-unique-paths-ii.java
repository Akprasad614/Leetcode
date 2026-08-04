class Solution {
    int[][] dp;
    int countPath(int m,int n,int[][] obstacleGrid){
        if(m < 0 || n < 0 || obstacleGrid[m][n] == 1){
            return 0;
        }
            
        if(m == 0 && n == 0){
            return 1;
        }
        if(dp[m][n] != -1){
            return dp[m][n];
        }
        int up = countPath(m-1,n,obstacleGrid);
        int left = countPath(m,n-1,obstacleGrid);
        return dp[m][n] = left + up;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        dp = new int[m][n];
        for(int[] rows : dp){
           Arrays.fill(rows,-1);
        }
        return countPath(m-1,n-1,obstacleGrid);
    }
}

