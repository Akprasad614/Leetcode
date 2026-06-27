class Solution {
    public int search(int[] nums, int target) {
        int pivot = pivot(nums,0,nums.length-1);
        if(pivot == -1){
           return binarySearch(nums,0,nums.length-1,target);
        }
        if(nums[pivot] == target){
          return pivot;
        }
        if(target >= nums[0]){
           return binarySearch(nums,0,pivot-1,target);
        }
        return binarySearch(nums,pivot+1,nums.length-1,target);
    }
          int binarySearch(int nums[],int start,int end,int target){
            while(start<=end){
                int mid = start + (end-start)/2;
                if(target == nums[mid]){
                    return mid;
                }
                if(target > nums[mid]){
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
            return -1;
        }
      int pivot(int nums[],int start,int end){
        while(start<=end){
            int mid = start + (end-start)/2;
            if( mid < end && nums[mid] > nums[mid+1]){
                return mid;
            }
            if( mid > start && nums[mid] < nums[mid-1]){
                return mid-1;
            }
            if(nums[start] > nums[mid]){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return -1;
    }
}

// int pivot = pivotnum(nums,0,nums.length-1);
//         if(pivot == -1)
//         {
//             return binarySearch(nums,target,0,nums.length-1);
//         }
//         if(target==nums[pivot])
//         {
//             return pivot;
//         }
//         if(target>=nums[0])
//         {
//         return binarySearch(nums,target,0,pivot-1);
//         }
//     return binarySearch(nums,target,pivot+1,nums.length-1);
//     }
//     int binarySearch(int nums[],int target,int start,int end)
//     {
//         while(start<=end)
//         {
//         int mid=start+(end-start)/2;
//             if(target==nums[mid])
//             return mid;
//             if(target>nums[mid])
//             start=mid+1;
//             else
//             end=mid-1;
//         }
//         return -1;
//     }
//     int pivotnum(int [] nums,int start,int end)
//     {
//         while(start<=end)
//         {
//         int mid=start+(end-start)/2;
//              if(mid<end && nums[mid]>nums[mid+1])
//              {
//                 return mid;
//              }
//              if(mid >start && nums[mid]<nums[mid-1])
//              {
//                 return mid-1;
//              }
//              if(nums[start] >= nums[mid])
//              {
//                 end = mid-1;
//              }else{
//                 start = mid+1;
//              }

//         }
//         return -1;
//     }