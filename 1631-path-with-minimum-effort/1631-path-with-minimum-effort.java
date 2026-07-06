class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        int[][] dist = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        pq.offer(new int[]{0,0,0});

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int d = cur[0];
            int r = cur[1];
            int c = cur[2];

            if(r==m-1 && c==n-1) return d;

            for(int i = 0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr>=0 && nr<m && nc>=0 && nc<n){
                    int newdiff = Math.max(Math.abs(heights[nr][nc] - heights[r][c]),d);
                    if(newdiff < dist[nr][nc]){
                        dist[nr][nc] = newdiff;
                        pq.offer(new int[]{newdiff,nr,nc});
                    }
                }
            }
        }
        return 0;
    }
}