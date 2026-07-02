class Solution {
    int parent[];
    int size[];
    
    int dr[] = {-1,0,1,0};
    int dc[] = {0,1,0,-1};
    int find(int x){
        if(parent[x] == x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    void union(int x,int y){
        int px = find(x);
        int py = find(y);

        if(px == py){
            return;
        }
        else if(size[px] < size[py]){
            parent[px] = py;
            size[py] += size[px];
        }
        else{
            parent[py] = px;
            size[px] += size[py];
        }
    }
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        parent = new int[n*n];
        size = new int[n*n];

        for(int i=0;i<n*n;i++){
            parent[i] = i;
            size[i] = 1;
        }
        // Step 1 : Build all islands
        for(int r=0;r<n;r++){
            for(int c=0;c<n;c++){
                if(grid[r][c] == 0){
                    continue;
                }
                int node = r*n+c;
                for(int k=0;k<4;k++){
                    int nr = r + dr[k];
                    int nc = c + dc[k];
                    if(nr>=0 && nr<n && nc>=0 && nc<n && grid[nr][nc] == 1){
                        int adjNode = nr*n+nc;
                        union(node,adjNode);
                    }
                }
            }
        }
        // Step 2 : Try converting every 0
        int ans = 0;
        for(int r=0;r<n;r++){
            for(int c=0;c<n;c++){

                if(grid[r][c] == 1){
                    continue;
                }
                Set<Integer> set = new HashSet<>();
                for(int k=0;k<4;k++){
                    int nr = r + dr[k];
                    int nc = c + dc[k];
                    if(nr>=0 && nr<n && nc>=0 && nc<n && grid[nr][nc] == 1){
                        set.add(find(nr*n+nc));
                    }
                }
                int total = 1;
                for(int p : set){
                    total += size[p];
                }
                ans = Math.max(total,ans);
            }
        }
        // Edge case: all cells are already 1

        for(int i=0;i<n*n;i++){
            ans = Math.max(ans,size[find(i)]);
        }
        return ans;
    }
}