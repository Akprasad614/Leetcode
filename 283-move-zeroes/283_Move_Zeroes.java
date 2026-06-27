class Solution {
    public void moveZeroes(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[count]=nums[i];
                count++;
            }
        }
            while(count<nums.length){
                nums[count]=0;
                count++;
            }
        }
        
    }                                                   // BOTH ARE GOOD [ANY ONE]

// class Solution {
//     public void moveZeroes(int[] nums) {
//         int j = 0;
//         for(int i = 0;i<nums.length;i++){
//                 if(nums[i] != 0){
//                 int temp = nums[i];
//                 nums[i] = nums[j];
//                 nums[j] = temp;
//                 j++;
//             }
//         }
//     }
// }