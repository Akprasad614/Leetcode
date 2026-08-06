class Solution {
    int[][] dp;
    int countPath(int m,List<List<Integer>> triangle){
        dp[0][0] = triangle.get(0).get(0);

        for(int i=1;i<m;i++){
            for(int j=0;j<=i;j++){
                int d = (int)1e9;
                int dg = (int)1e9;
                if(j<i)  d = dp[i-1][j] + triangle.get(i).get(j);
                if(j>0)  dg = dp[i-1][j-1] + triangle.get(i).get(j);

                dp[i][j] = Math.min(d,dg);
            }
        }
        int ans = Integer.MAX_VALUE;

        for(int j = 0; j < m; j++){

            ans = Math.min(ans, dp[m-1][j]);
        }

        return ans; 
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        dp = new int[m][m];
        return countPath(m,triangle);
    }
}
