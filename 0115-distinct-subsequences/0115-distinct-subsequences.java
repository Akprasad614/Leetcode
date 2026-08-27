class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] prev = new int[m+1];
        prev[0] = 1;
        for(int i=1;i<=n;i++){
            int[] temp = new int[m+1];
            temp[0] = 1;
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    temp[j] = prev[j-1] + prev[j];
                }
                else{
                    temp[j] = prev[j];
                }
            }
            prev = temp;
        }
        return prev[m];
    }
}

// class Solution {
//     int [][]dp;
//     int distinct(int i,int j,String s,String t){
//         if(j<0){
//             return 1;
//         }
//         if(i<0){
//             return 0;
//         }
//         if(dp[i][j] != -1){
//             return dp[i][j];
//         }
//         if(s.charAt(i) == t.charAt(j)){
//             return dp[i][j] = distinct(i-1,j-1,s,t) + distinct(i-1,j,s,t);
//         }
//         else{
//             return dp[i][j] = distinct(i-1,j,s,t);
//         }
//     }
//     public int numDistinct(String s, String t) {
//         int n = s.length();
//         int m = t.length();
//         dp = new int[n][m];
//         for(int rows[] : dp){
//             Arrays.fill(rows,-1);
//         }
//         return distinct(n-1,m-1,s,t);
//     }
// }