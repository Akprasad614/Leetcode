class Solution {
    int[] dp;
    int robhouse(int[] nums,int n){
        if(n==0){
            return nums[0];
        }
        if(n<1){
            return 0;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        int pick = nums[n] + robhouse(nums,n-2);
        int notpick = 0 + robhouse(nums,n-1);
        return dp[n] = Math.max(pick,notpick);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n];
        Arrays.fill(dp,-1);
        return robhouse(nums,n-1);
    }
}