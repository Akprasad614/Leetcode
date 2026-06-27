class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0;i<m; i++){
            for(int j =0;j<n;j++){
                if(grid[i][j] == 1){
                    fresh++;
                }
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i,j});
                }
            }
        }

        if(fresh == 0) return 0;

        int minutes = 0;
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean rottenThisMinutes = false;

            for(int i=0;i<size; i++){
                int[] cell = queue.poll();
                int r = cell[0];
                int c = cell[1];

                for(int j =0;j<4; j++){
                    int nr = r + dr[j];
                    int nc = c + dc[j];

                    if(nr >= 0 && nr < m && nc >= 0 && 
                    nc < n && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        fresh--;
                        queue.offer(new int[]{nr,nc});
                        rottenThisMinutes = true;
                    }
                }
            }
            if(rottenThisMinutes == true){
                minutes++;
            }
        }
        return fresh == 0 ? minutes : -1;
    }
}