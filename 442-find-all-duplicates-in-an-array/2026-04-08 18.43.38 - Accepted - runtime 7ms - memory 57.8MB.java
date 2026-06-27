class Solution {
    public List<Integer> findDuplicates(int[] arr) {
        int i = 0;
        while(i<arr.length){
            if(arr[i] != i+1){
                int correct = arr[i]-1;
                if(arr[i] == arr[correct]){
                    i++;
                }
                else{
                    int temp = arr[i];
                    arr[i] = arr[correct];
                    arr[correct] = temp;
                }
            }
            else i++;
        }
        List<Integer> ans = new ArrayList<>();
        for(i=0;i<arr.length;i++){
            if(arr[i] != i+1){
                ans.add(arr[i]);
            }
        }
        return ans;
        }
        
}
       
       
    //     int i=0;
    //     while(i < arr.length)
    //     {
    //         if(arr[i] != i+1) 
    //         {
    //             int correct = arr[i]-1;  // correct palce nikale 
    //             if(arr[i] == arr[correct])  
    //             {
    //                 i++;
    //             }
    //             else
    //             {
    //             int temp=arr[i];
    //             arr[i]=arr[correct];
    //             arr[correct]=temp;
    //             }
    //         }
    //         else i++;
    //     }
    //     List<Integer> ans = new ArrayList<>();
    //     for(i=0;i<arr.length;i++)
    //     {
    //         if(arr[i] != i+1)
    //         {
    //             ans.add(arr[i]);
    //         }
    //     }
    //     return ans;
    // }