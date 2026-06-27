class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
         // for first n last col

        for(int row =0;row<m;row++){
            if(board[row][0] == 'O'){
                dfs(board,row,0);
            }
            if(board[row][n-1] == 'O'){
                dfs(board,row,n-1);
            }
        }
         // for first n last row

        for(int col =0;col<n;col++){
            if(board[0][col] == 'O'){
                dfs(board,0,col);
            }
            if(board[m-1][col] == 'O'){
                dfs(board,m-1,col);
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j] == 'V'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    static void dfs(char[][] board,int row,int col){

        int m = board.length;
        int n = board[0].length;

        if(row<0 || row>=m || col<0 || col>=n || board[row][col] != 'O'){
            return;
        }

        board[row][col] = 'V';

        dfs(board,row-1,col);
        dfs(board,row+1,col);
        dfs(board,row,col-1);
        dfs(board,row,col+1);
    }
}