class Solution {
    Boolean[][] dp;
    boolean subsetSum(int index,int target,int[] nums){
        if(target == 0){
            return true;
        }
        if(index == nums.length){
            return false;
        }
        if(dp[index][target] != null){
            return dp[index][target];
        }
        if(nums[index] == target){
            return true;
        }
        // take
        boolean take = false;
        if(nums[index] < target){
            take = subsetSum(index+1,target-nums[index],nums);
        }
        
        // not take
        boolean notTake = subsetSum(index+1,target,nums);

        return dp[index][target] = take || notTake;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        if(sum % 2 != 0){
            return false;
        }
        dp = new Boolean[nums.length][sum/2 + 1];
        return subsetSum(0,sum/2,nums);
    }
}