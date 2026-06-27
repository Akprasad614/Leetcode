class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0;i<m;i++){
            for(int j =0;j<n;j++){
                if(mat[i][j] == 0){
                    queue.offer(new int[]{i,j});
                }
                else{
                    mat[i][j] = -1;
                }
            }
        }
                                            // we are using 0 as strarting point and assigning every ipcommnig 1 as its distance and later after using that distance we are assinging the upcoming 1's
        int[] dr = {0,0,-1,1};
        int[] dc = {-1,1,0,0};
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            for(int i =0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr>=0 && nr<m && nc>=0 && nc<n && mat[nr][nc] == -1){
                    mat[nr][nc] = mat[r][c] + 1;
                    queue.offer(new int[]{nr,nc});
                }
            }
        }
        return mat;

    }
}

