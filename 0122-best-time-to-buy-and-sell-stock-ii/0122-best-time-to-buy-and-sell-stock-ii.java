//     GREEDY
class Solution {         
    public int maxProfit(int[] prices) {
        int profit=0;
        for(int i=1;i<prices.length;i++) {
            if(prices[i]>prices[i-1]) {
                profit+=prices[i]-prices[i-1];
            }
        }
        return profit;
    }
}

//        DP

// class Solution {
//     int[][] dp;
//     int profit(int i,int status,int[] prices){
//         if(i == prices.length){
//             return 0;
//         }
//         if(dp[status][i] != -1){
//             return dp[status][i];
//         }
//         if(status == 0){
//             return dp[0][i] = Math.max(-prices[i] + profit(i+1,1,prices),0 + profit(i+1,0,prices));
//         }
//         else{
//             return dp[1][i] = Math.max(prices[i] + profit(i+1,0,prices),0 + profit(i+1,1,prices));
//         }
//     }
//     public int maxProfit(int[] prices) {
//         int n = prices.length;
//         dp = new int[2][n];
//         for(int[] row : dp){
//             Arrays.fill(row,-1);
//         }
//         return profit(0,0,prices);
//     }
// }