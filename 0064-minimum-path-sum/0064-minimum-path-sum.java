class Solution {
    int[][] dp;
    int countPath(int m,int n,int[][] grid){
        if(m == 0 && n== 0){
            return grid[0][0];
        }
        if(m<0 || n<0){
            return (int)1e9;
        }
        if(dp[m][n] != -1){
            return dp[m][n];        
        }
        int up = grid[m][n] + countPath(m-1,n,grid);
        int left = grid[m][n] + countPath(m,n-1,grid);
        return dp[m][n] = Math.min(left,up);
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return countPath(m-1,n-1,grid);
    }
}