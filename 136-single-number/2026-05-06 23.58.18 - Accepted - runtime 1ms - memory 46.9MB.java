class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int n : nums){
            ans ^= n;               // a ^ a = 0.   a ^ 0 = a.   return 0 if both same and with 0 = same no.
        }
        return ans;
    }
}