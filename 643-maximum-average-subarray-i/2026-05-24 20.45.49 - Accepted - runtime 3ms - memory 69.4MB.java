class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for(int i =0;i< k;i++){
            sum += nums[i];
        }

        int maxSum = sum;
        for(int i = k; i<nums.length; i++){
            sum = sum - nums[i-k] + nums[i];
            maxSum = Math.max(maxSum,sum); 
        }
        return (double)maxSum / k;
    }
}

// class Solution {
//     public double findMaxAverage(int[] nums, int k) {
//         double ans = -Double.MAX_VALUE;
//         for(int i=0;i <= nums.length-k; i++){
//             int sum = 0;
//             for(int j = i; j < k+i ; j++){
//                 sum += nums[j]; 
//             }
//             ans = Math.max(ans,(double)sum/k);
//         }
//         return ans;
//     } 
// }