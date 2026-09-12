class Solution {
    int[][] dp;
    int profit(int i,int buy,int[] prices,int fee){
        if(i == prices.length){
            return 0;
        }
        if(dp[i][buy] != -1){
            return dp[i][buy];
        }
        if(buy == 0){
            return dp[i][0] = Math.max(-prices[i] + profit(i+1,1,prices,fee),0 + profit(i+1,0,prices,fee));
        }
        return dp[i][1] = Math.max(prices[i] - fee + profit(i+1,0,prices,fee), 0 + profit(i+1,1,prices,fee));

    }
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        dp = new int[n][2];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return profit(0,0,prices,fee);
    }
}