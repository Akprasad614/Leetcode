class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        int[] first = new int[n-1];
        int[] second = new int[n-1];

        for(int i =0;i<n-1;i++){
            first[i] = nums[i];
        }
        for(int i =1;i<n;i++){
            second[i-1] = nums[i];
        }
        return Math.max(robhouse(first),robhouse(second));
    }
    int robhouse(int nums[]){
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        int dp[] = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);

        for(int i=2;i<n;i++){
            int pick = nums[i] + dp[i-2];
            int notpick = dp[i-1];
            dp[i] = Math.max(pick,notpick);
        }
        return dp[n-1];
    }
}