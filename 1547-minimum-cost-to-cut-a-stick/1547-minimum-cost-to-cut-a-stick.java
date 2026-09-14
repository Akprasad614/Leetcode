class Solution {
    int[][] dp;
    int cost(int i,int j,List<Integer> arr){
        if(i>j) return 0;
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int mini = Integer.MAX_VALUE;
        for(int ind = i;ind <= j;ind++){
            int cost = arr.get(j+1) - arr.get(i-1) + cost(i,ind-1,arr) + cost(ind+1,j,arr);
            mini = Math.min(cost,mini);
        }
        return dp[i][j] = mini;
    }
    public int minCost(int n, int[] cuts) {
        int c = cuts.length;
        List<Integer> arr = new ArrayList<>();
        dp = new int[c+1][c+1];
        for(int cut : cuts){
            arr.add(cut);
        }
        for(int[] rows : dp){
            Arrays.fill(rows,-1);
        }
        arr.add(0,0);
        arr.add(n);
        Collections.sort(arr);
        return cost(1,c,arr);
    }
}