class Solution {
    int[] dp;
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        dp = new int[amount+1];
        for(int target = 0;target<=amount;target++){
            if(target % coins[0] == 0){
                dp[target] = target/coins[0];
            }
            else dp[target] = (int)1e9;
        }
        for(int i=1;i<n;i++){
            int[] temp = new int[amount+1];
            for(int target=0;target<=amount;target++){
                int notpick = dp[target];
                int pick = (int)1e9;
                if(coins[i] <= target){
                    pick = 1 + temp[target-coins[i]];
                }
                temp[target] = Math.min(pick,notpick);
            }
            dp = temp;
        }
        int ans = dp[amount];
        return ans >= 1e9 ? -1 : ans;
    }
}

// class Solution {
//     int[][] dp;
//     public int coinChange(int[] coins, int amount) {
//         int n = coins.length;
//         dp = new int[n][amount+1];
//         for(int target = 0;target<=amount;target++){
//             if(target % coins[0] == 0){
//                 dp[0][target] = target/coins[0];
//             }
//             else dp[0][target] = (int)1e9;
//         }
//         for(int i=1;i<n;i++){
//             for(int target=0;target<=amount;target++){
//                 int notpick = dp[i-1][target];
//                 int pick = (int)1e9;
//                 if(coins[i] <= target){
//                     pick = 1 + dp[i][target-coins[i]];
//                 }
//                 dp[i][target] = Math.min(pick,notpick);
//             }
//         }
//         int ans = dp[n-1][amount];
//         return ans >= 1e9 ? -1 : ans;
//     }
// }

// class Solution {
//     int[][] dp;
//     int coinsNumber(int n,int amount,int[] coins){
//         if(n==0){
//             if(amount % coins[0] == 0) return amount/coins[0];
//             return (int)1e9;
//         }
//         if(dp[n][amount] != -1){
//             return dp[n][amount];
//         }
//         int notpick = coinsNumber(n-1,amount,coins);
//         int pick = (int)1e9;
//         if(coins[n] <= amount){
//             pick = 1 + coinsNumber(n,amount-coins[n],coins);
//         }

//         return dp[n][amount] = Math.min(pick,notpick);
//     }
//     public int coinChange(int[] coins, int amount) {
//         dp = new int[coins.length][amount+1];
//         for(int[] rows: dp){
//             Arrays.fill(rows,-1);
//         }
//         int ans = coinsNumber(coins.length-1,amount,coins);
//         return (ans >= 1e9)? -1 : ans;
//     }
// }