class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int[] prev = new int[n+1];
        String rev = new StringBuilder(s).reverse().toString();
        for(int i=1;i<= n;i++){
            int[] temp = new int[n+1];
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1) == rev.charAt(j-1)){
                    temp[j] = 1+prev[j-1];
                }
                else{
                    temp[j] = Math.max(prev[j],temp[j-1]);
                }
            }
            prev = temp;
        }
        return s.length() - prev[n];
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