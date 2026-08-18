class Solution {
    int[][] dp;
    int coinsNumber(int n,int amount,int[] coins){
        if(n==0){
            if(amount % coins[0] == 0) return amount/coins[0];
            return (int)1e9;
        }
        if(dp[n][amount] != -1){
            return dp[n][amount];
        }
        int notpick = coinsNumber(n-1,amount,coins);
        int pick = (int)1e9;
        if(coins[n] <= amount){
            pick = 1 + coinsNumber(n,amount-coins[n],coins);
        }

        return dp[n][amount] = Math.min(pick,notpick);
    }
    public int coinChange(int[] coins, int amount) {
        dp = new int[coins.length][amount+1];
        for(int[] rows: dp){
            Arrays.fill(rows,-1);
        }
        int ans = coinsNumber(coins.length-1,amount,coins);
        return (ans >= 1e9)? -1 : ans;
    }
}