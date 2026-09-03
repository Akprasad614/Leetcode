   //    DP

class Solution {
    int[][][] dp;
    int ctr = 0;
    int profit(int i,int status,int cap,int[] prices){
        if(i == prices.length || cap == 2){
            return 0;
        }
        if(dp[status][cap][i] != -1){
            return dp[status][cap][i];
        }
        if(status == 0){
            return dp[0][cap][i] = Math.max(-prices[i] + profit(i+1,1,cap,prices),0 + profit(i+1,0,cap,prices));
        }
        else{
            ctr++;
            return dp[1][cap][i] = Math.max(prices[i] + profit(i+1,0,cap+1,prices),0 + profit(i+1,1,cap,prices));
        }
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[2][2][n];
        for(int[][] rows : dp){
            for(int[] row : rows){
                Arrays.fill(row,-1);
            }
        }
        return profit(0,0,0,prices);
    }
}

// //     GREEDY
// class Solution {         
//     public int maxProfit(int[] prices) {
//         int profit=0;
//         int ctr = 0;
//         for(int i=1;i<prices.length;i++) {
//             if(prices[i]>prices[i-1]) {
//                 profit+=prices[i]-prices[i-1];
//                 ctr++;
//             }
//             if(ctr == 2) break;
//         }
//         return profit;
//     }
// }

