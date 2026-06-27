// class Solution {
//     public List<Integer> findDisappearedNumbers(int[] arr) {
//         int i =0;
//         while(i<arr.length){
//             int correct = arr[i]-1;
//             if(arr[i] != arr[correct]){
//                 int temp = arr[i];
//                 arr[i] = arr[correct];
//                 arr[correct] = temp;
//             }
//             else i++;
//         }
//         List<Integer> ans = new ArrayList<>();
//         for(i = 0;i<arr.length;i++){
//             if(arr[i] != i+1){
//                 ans.add(i+1);
//             }
//         }
//         return ans;
//     }
// }


class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] counts = new int[nums.length + 1];

        for (int n : nums) {
            counts[n]++;
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < nums.length + 1; i++) {
            if (counts[i] == 0) {
                list.add(i);
            }
        }

        return list;
    }
}


