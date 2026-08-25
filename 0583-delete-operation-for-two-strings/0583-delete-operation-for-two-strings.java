class Solution {
    int dp[][];
    int lcs(int i,int j,String s,String rev){
        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s.charAt(i) == rev.charAt(j)){
            return dp[i][j] = 1 + lcs(i-1,j-1,s,rev);
        }
        else {
            return dp[i][j] = Math.max(lcs(i-1,j,s,rev),lcs(i,j-1,s,rev));
        }
    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        dp = new int[n][m];
        for(int[] rows : dp){
            Arrays.fill(rows,-1);
        }
        return Math.abs(word1.length() + word2.length() - (2 * lcs(n-1,m-1,word1,word2)));
    }
}

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
//         else {
//             return dp[i][j] = Math.max(lcs(i-1,j,s,rev),lcs(i,j-1,s,rev));
//         }
//     }
//     public int minInsertions(String s) {
//         int n = s.length();
//         dp = new int[n][n];
//         for(int[] rows : dp){
//             Arrays.fill(rows,-1);
//         }
//         String rev = new StringBuilder(s).reverse().toString();
//         return s.length() - lcs(n-1,n-1,s,rev);
//     }
// }