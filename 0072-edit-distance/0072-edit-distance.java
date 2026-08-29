class Solution {
    int [][]dp;
    int Distance(int i,int j,String w,String s){
        if(i<0){
            return j+1;
        }
        if(j<0){
            return i+1;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(w.charAt(i) == s.charAt(j)){
            return dp[i][j] = Distance(i-1,j-1,w,s);
        }
        else{
            return dp[i][j] = 1 + Math.min(Distance(i,j-1,w,s),Math.min(Distance(i-1,j,w,s),Distance(i-1,j-1,w,s)));
        }
    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        dp = new int[n][m];
        for(int rows[] : dp){
            Arrays.fill(rows,-1);
        }
        return Distance(n-1,m-1,word1,word2);
    }
}