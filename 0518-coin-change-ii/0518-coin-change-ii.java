class Solution {
    int[][] dp;
    public int change(int amount, int[] coins) {
        int n = coins.length;
        dp = new int[n][amount+1];
        for(int target = 0;target<=amount;target++){
            if(target % coins[0] == 0){
                dp[0][target] = 1;
            }
        }
            for(int i=1;i<n;i++){
                for(int target=0;target<=amount;target++){
                    int notTake = dp[i-1][target];
                    int take = 0;
                    if(target >= coins[i]){
                        take = dp[i][target-coins[i]];
                    } 
                    dp[i][target] = take + notTake;
                }
            }
        return dp[n-1][amount];
    }
}

// class Solution {
//     int[][] dp;
//     int coinCount(int n,int amount,int[] coins){

//         if(n == 0) {
//             return amount % coins[0] == 0 ? 1 : 0;
//         }

//         if(dp[n][amount] != -1){
//             return dp[n][amount];
//         }
//         int notTake = coinCount(n-1,amount,coins);
//         int take = 0;
//         if(amount >= coins[n]){
//             take = coinCount(n,amount-coins[n],coins);
//         }

//         return dp[n][amount] = take + notTake;
//     }
//     public int change(int amount, int[] coins) {
//         dp = new int[coins.length][amount+1];
//         for(int[] rows:dp){
//             Arrays.fill(rows,-1);
//         }
//         return coinCount(coins.length-1,amount,coins);
//     }
// }