class Solution {
    public int minDistance(String word1, String word2) {
        int n = word2.length();
        int m = word1.length();
        int prev[] = new int[n+1];
        for(int i = 0;i<=n;i++){
            prev[i] = i;
        }
        for(int i=1;i<=m;i++){
            int[] temp = new int[n+1];
            temp[0] = i;
            for(int j=1;j<=n;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    temp[j] = prev[j-1];
                }
                else{
                    temp[j] = 1 + Math.min(temp[j-1],Math.min(prev[j],prev[j-1]));
                }
            }
            prev = temp;
        }
        return prev[n];
    }
}

// class Solution {
//     int [][]dp;
//     int Distance(int i,int j,String w,String s){
//         if(i<0){
//             return j+1;
//         }
//         if(j<0){
//             return i+1;
//         }
//         if(dp[i][j] != -1){
//             return dp[i][j];
//         }
//         if(w.charAt(i) == s.charAt(j)){
//             return dp[i][j] = Distance(i-1,j-1,w,s);
//         }
//         else{
//             return dp[i][j] = 1 + Math.min(Distance(i,j-1,w,s),Math.min(Distance(i-1,j,w,s),Distance(i-1,j-1,w,s)));
//         }
//     }
//     public int minDistance(String word1, String word2) {
//         int n = word1.length();
//         int m = word2.length();
//         dp = new int[n][m];
//         for(int rows[] : dp){
//             Arrays.fill(rows,-1);
//         }
//         return Distance(n-1,m-1,word1,word2);
//     }
// }