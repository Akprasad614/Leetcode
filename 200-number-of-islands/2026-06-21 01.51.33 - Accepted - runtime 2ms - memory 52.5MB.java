class Solution {
    public int numIslands(char[][] grid) {
        int ctr = 0;
        int m = grid.length;
        int n = grid[0].length;

        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(grid[i][j] == '1'){
                    dfs(grid,i,j,m,n);
                    ctr++;                      //. DFS. (PREFERRED). EASY
                }
            }
        }  
        return ctr; 
    }
    static void dfs(char[][] grid,int row, int col,int m,int n){

        if(row<0 || row>=m || col<0 || col>=n || grid[row][col] == '0'){
            return;
        }

        grid[row][col] = '0';

        dfs(grid,row-1,col,m,n);
        dfs(grid,row+1,col,m,n);
        dfs(grid,row,col-1,m,n);
        dfs(grid,row,col+1,m,n);
    }
}



                                      //.  BFS  ( COMPLEX ) 
// class Solution {

//     public int numIslands(char[][] grid) {

//         int rows = grid.length;
//         int cols = grid[0].length;

//         int count = 0;

//         int[] rowDirection = {1, -1, 0, 0};
//         int[] colDirection = {0, 0, 1, -1};

//         for (int row = 0; row < rows; row++) {
//             for (int col = 0; col < cols; col++) {

//                 if (grid[row][col] == '1') {

//                     count++;

//                     Queue<int[]> queue = new LinkedList<>();
//                     queue.offer(new int[]{row, col});

//                     grid[row][col] = '0';

//                     while (!queue.isEmpty()) {

//                         int[] currentCell = queue.poll();

//                         int currentRow = currentCell[0];
//                         int currentCol = currentCell[1];

//                         for (int direction = 0; direction < 4; direction++) {

//                             int newRow = currentRow + rowDirection[direction];
//                             int newCol = currentCol + colDirection[direction];

//                             if (newRow >= 0 &&
//                                 newRow < rows &&
//                                 newCol >= 0 &&
//                                 newCol < cols &&
//                                 grid[newRow][newCol] == '1') {

//                                 grid[newRow][newCol] = '0';

//                                 queue.offer(new int[]{newRow, newCol});
//                             }
//                         }
//                     }
//                 }
//             }
//         }

//         return count;
//     }
// }