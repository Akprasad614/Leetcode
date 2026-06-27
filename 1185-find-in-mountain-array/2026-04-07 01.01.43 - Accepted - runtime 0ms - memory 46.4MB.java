/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
         int start = 0;
        int end = mountainArr.length() - 1;
        while(start < end){
            int mid = start + (end-start)/2;
            if(mountainArr.get(mid) > mountainArr.get(mid+1)){
                end = mid;
            }
            else{
                start = mid+1;
            }
        }
        int res = binarySearch(mountainArr,target,0,start,true);
        if(res !=-1){
            return res;
        }
        return binarySearch(mountainArr,target,start+1,mountainArr.length()-1,false);
    }
    public int binarySearch(MountainArray mountainArr,int target,int start,int end,boolean asc){
        while(start <= end){
            int mid = start+(end-start)/2;
            if(mountainArr.get(mid) == target){
                return mid;
            }
            if(asc){
                if(mountainArr.get(mid) > target){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
            else{
                if(mountainArr.get(mid) > target){
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
        }
        return -1;
    }
}