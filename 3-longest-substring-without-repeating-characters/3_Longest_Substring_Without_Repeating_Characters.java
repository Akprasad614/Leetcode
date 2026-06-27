class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int left = 0;
        
        for(int right = 0;right<s.length(); right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;                                 // Sliding window O(n)
            }

            set.add(s.charAt(right));
            max = Math.max(max,right-left+1);
        }
        return max;
    }
}


// class Solution {
// int ans =0;
//     public int lengthOfLongestSubstring(String s) {
//         for(int i = 0;i<s.length();i++){
//             HashSet<Character> set = new HashSet<>();
//             int ctr =0;
//             for(int j=i;j<s.length();j++){
//                 if(set.contains(s.charAt(j))){              brute force nxn
//                     break;
//                 }
//                 set.add(s.charAt(j));
//                 ctr++;
//             }
//             ans = Math.max(ans,ctr);
//         }
//         return ans;
//     }
// }