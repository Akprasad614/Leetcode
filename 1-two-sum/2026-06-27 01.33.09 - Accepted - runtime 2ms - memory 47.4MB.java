class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hash = new HashMap<>();

        for(int i = 0;i<nums.length;i++){
            int compliment = target - nums[i];
            if(hash.containsKey(compliment)){
                return new int[]{hash.get(compliment) , i};         // using hash map best approach
            }
            hash.put(nums[i],i);
        }
        return new int[]{};
    }
}



        // for(int i = 0;i< nums.length-1;i++){
        //     for(int j = 0;j<nums.length;j++){
        //         if(i != j && nums[i] + nums[j] == target){
        //             return new int[]{i,j};
        //         }
        //     }
        // }
        // return null;