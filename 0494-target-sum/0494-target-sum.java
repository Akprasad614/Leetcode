class Solution {
    int[][] dp;
    int targetSum(int n,int target,int[] nums){
        if(n == 0) {
            if(target == 0) {
                return nums[0] == 0 ? 2 : 1;
            }
        return target == nums[0] ? 1 : 0;
        }
        
        if(dp[n][target] != -1){
            return dp[n][target];
        }
        int notpick = targetSum(n-1,target,nums);
        int pick = 0;
        if(nums[n] <= target){
            pick = targetSum(n-1,target-nums[n],nums);
        }
        return dp[n][target] = pick + notpick;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }

        if(Math.abs(target) > sum || (sum + target) % 2 != 0) {
            return 0;
        }

        int newtarget = (sum+target)/2;
        dp = new int[nums.length][newtarget+1];

        for(int[] rows: dp){
            Arrays.fill(rows,-1);
        }
        return targetSum(nums.length-1,newtarget,nums);
    }
}

