class Solution {
    public int numEnclaves(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int ctr =0;
         // for first n last col

        for(int row =0;row<m;row++){
                dfs(board,row,0);
                dfs(board,row,n-1);
        }
         // for first n last row

        for(int col =0;col<n;col++){
                dfs(board,0,col);
                dfs(board,m-1,col);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 1){
                    ctr++;
                }
            }
        }
        return ctr;
    }
    static void dfs(int[][] board,int row,int col){

        int m = board.length;
        int n = board[0].length;

        if(row<0 || row>=m || col<0 || col>=n || board[row][col] == 0){
            return;
        }

        board[row][col] = 0;

        dfs(board,row-1,col);
        dfs(board,row+1,col);
        dfs(board,row,col-1);
        dfs(board,row,col+1);
    }
}