class Solution {
    public int minimumDifference(int[] nums, int k) {
        int ans = Integer.MAX_VALUE;

        Arrays.sort(nums);
        for(int i=0; i <= nums.length-k;i++){
            int diff = nums[i + k -1] - nums[i];
            ans = Math.min(ans,diff);
        }
        return ans;
    }
}//643,3