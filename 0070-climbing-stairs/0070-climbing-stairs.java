class Solution {
    int[] dp;
    int climb(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        dp[n] = climb(n-1) + climb(n-2);
        return dp[n];
    }
    public int climbStairs(int n) {
        dp = new int[n+1];
        return climb(n);
    }
}