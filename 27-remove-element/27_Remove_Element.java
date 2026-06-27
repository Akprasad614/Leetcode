class Solution {
    public int removeElement(int[] nums, int target) 
    {
        int ctr = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != target){
                nums[ctr++] = nums[i];
            }
        }
        return ctr;
    }
}// done