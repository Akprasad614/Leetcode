class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int[] prev = new int[m+1];
        prev[0] = 1;
        for(int i=1;i<=m;i++){
            if(p.charAt(i-1) == '*'){
                prev[i] = 1;
            }
            else break;
        }
        for(int i=1;i<=n;i++){
            int[] temp = new int[m+1];;
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?'){
                    temp[j] = prev[j-1];
                }
                else if(p.charAt(j-1) == '*') {
                    int noMatch = temp[j-1];
                    int match = prev[j];
                    temp[j] = Math.max(noMatch, match);
                }
            }
            prev = temp;
        }
        return prev[m] == 1;
    }
}

// class Solution {
//     int[][] dp;
//     int matching(int i,int j,String s,String p){
//         if(i<0 && j<0){
//             return 1;
//         }
//         if(j<0){
//             return 0;
//         }
//         if(i<0){
//             while(j>=0){
//                 if(p.charAt(j) != '*'){
//                     return 0;
//                 }
//                 j--;
//             }
//             return 1;
//         }
//         if(dp[i][j] != -1){
//             return dp[i][j];
//         }
//         if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
//             return dp[i][j] = matching(i-1,j-1,s,p);
//         }
//         else if(p.charAt(j) == '*') {
//             int noMatch = matching(i, j - 1, s, p);
//             int match = matching(i - 1, j, s, p);
//             return dp[i][j] = Math.max(noMatch, match);
//         }
//         return 0;
//     }
//     public boolean isMatch(String s, String p) {
//         int n = s.length();
//         int m = p.length();
//         dp = new int[n][m];
//         for(int[] rows:dp){
//             Arrays.fill(rows,-1);
//         }
//         return matching(n-1,m-1,s,p) == 1;
//     }
// }