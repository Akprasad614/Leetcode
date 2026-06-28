class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1){
            return -1;
        }
        int[] size = new int[n];
        int[] parent = new int[n];

        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 0;
        }
        for(int[] edge : connections){
            union(parent,size,edge[0],edge[1]);
        }

        int components = 0;
        for(int i=0;i<n;i++){
            if(parent[i] == i){
                components++;
            }
        }
        return components-1;
    }

    // find the parent with compression
    public int find(int[] parent,int node){
        if(parent[node] != node){
            parent[node] = find(parent,parent[node]);
        }
        return parent[node];
    }

    // union by rank
    public void union(int[] parent,int[] size, int u,int v){
        int pu = find(parent,u);
        int pv = find(parent,v);
        if(pu == pv) return;

        if(size[pu] < size[pv]){
            parent[pu] = pv;
            size[pv] += size[pu]; 
        }else{
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }
}