class Solution {
    int[][][] dp;
    int profit(int i,int status,int cap,int[] prices){
        if(i == prices.length || cap == 0){
            return 0;
        }
        if(dp[status][cap][i] != -1){
            return dp[status][cap][i];
        }
        if(status == 0){
            return dp[0][cap][i] = Math.max(-prices[i] + profit(i+1,1,cap,prices),0 + profit(i+1,0,cap,prices));
        }
        else{
            return dp[1][cap][i] = Math.max(prices[i] + profit(i+1,0,cap-1,prices),0 + profit(i+1,1,cap,prices));
        }
    }
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        dp = new int[2][k+1][n]; 
        for(int[][] rows : dp){
            for(int[] row : rows){
                Arrays.fill(row,-1);
            }
        }
        return profit(0,0,k,prices);
    }
} 