class Solution {
    public int strStr(String haystack, String needle) {
        for(int i = 0, j = needle.length(); j<=haystack.length(); i++,j++){
            if(haystack.substring(i,j).equals(needle)){                                 // 0ms  [BEST]
                return i;
            }
        }
        return -1;
    }
}


        //return haystack.indexOf(needle);              0ms


        // int m = haystack.length();
        // int n = needle.length();
        // for(int i = 0; i<= m-n;i++){
        //     int j = 0;
        //     while(j<n && haystack.charAt(i+j) == needle.charAt(j)){              1ms
        //         if(j==n-1){
        //             return i;
        //         }
        //         j++;
        //     }
        // }
        // return -1;