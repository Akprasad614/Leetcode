class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int min = prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]>min){
                profit = Math.max(profit,prices[i]-min);
            }
            else min = prices[i];
        }
        return profit;
    }
}
// class Solution {
//     public int maxProfit(int[] prices) {
//         int min = prices[0];
//         int profit = 0;
//         for(int i=1;i<prices.length;i++){
//             int diff = prices[i] - min;
//             profit = Math.max(profit,diff);
//             min = Math.min(prices[i],min);
//         }
//         return profit;
//     }
// }