class Solution {
    int[][] dp;
    int profit(int i,int buy,int[] prices){
        if(i >= prices.length){
            return 0;
        }
        if(dp[i][buy] != -1){
            return dp[i][buy];
        }
        if(buy == 0){
            return dp[i][buy] = Math.max(-prices[i] + profit(i+1,1,prices),profit(i+1,0,prices));
        }
        else{
            return dp[i][buy] = Math.max(prices[i] + profit(i+2,0,prices),profit(i+1,1,prices));
        }
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n][2];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return profit(0,0,prices);
    }
}