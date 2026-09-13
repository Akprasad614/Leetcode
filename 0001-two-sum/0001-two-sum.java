class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            int num=nums[i];
            int rem=target-num;
            if(map.containsKey(rem)) return new int[]{i,map.get(rem)};
            else map.put(num,i);
        }
        return new int[]{};

        }
        
    }