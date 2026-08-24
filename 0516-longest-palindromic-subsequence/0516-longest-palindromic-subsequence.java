class Solution {

    public int longestPalindromeSubseq(String s) {

        int n = s.length();
        String rev = new StringBuilder(s).reverse().toString();

        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];

        for(int i = 1; i <= n; i++) {

            for(int j = 1; j <= n; j++) {

                if(s.charAt(i - 1) == rev.charAt(j - 1)) {

                    curr[j] = 1 + prev[j - 1];

                } else {

                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }

            prev = curr;
            curr = new int[n + 1];
        }

        return prev[n];
    }
}
// class Solution {
//     int dp[][];
//     public int longestPalindromeSubseq(String s) {
//         int n = s.length();
//         String rev = new StringBuilder(s).reverse().toString();
//         dp = new int[n+1][n+1];
//         for(int i =1;i<=n;i++){
//             for(int j=1;j<=n;j++){
//                 if(s.charAt(i-1) == rev.charAt(j-1)){
//                 dp[i][j] = 1 + dp[i-1][j-1];
//                 }
//                 else{
//                     dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
//                 }
//             }
//         }
//         return dp[n][n];

//     }
// }

// class Solution {
//     int dp[][];
//     int lcs(int i,int j,String s,String rev){
//         if(i<0 || j<0){
//             return 0;
//         }
//         if(dp[i][j] != -1){
//             return dp[i][j];
//         }
//         if(s.charAt(i) == rev.charAt(j)){
//             return dp[i][j] = 1 + lcs(i-1,j-1,s,rev);
//         }
//         return dp[i][j] = Math.max(lcs(i-1,j,s,rev),lcs(i,j-1,s,rev));
//     }
//     public int longestPalindromeSubseq(String s) {
//         String rev = new StringBuilder(s).reverse().toString();
//         int n = s.length();
//         dp = new int[n][n];
//         for(int[] rows:dp){
//             Arrays.fill(rows,-1);
//         }
//         return lcs(n-1,n-1,s,rev);
//     }
// }