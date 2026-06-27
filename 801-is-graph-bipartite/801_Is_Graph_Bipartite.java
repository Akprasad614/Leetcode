class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i =0;i<n;i++){
            for(int neighbour : graph[i]){
                adj.get(i).add(neighbour);
            }
        }

        int[] color = new int[n];
        Arrays.fill(color,-1);

        for(int i =0;i<n;i++){
            if(color[i] == -1){
                if(!dfs(i,0,adj,color)){
                    return false;
                }
            }
        }
        return true;

    }
    static boolean dfs(int node,int currcolor,List<List<Integer>> adj,int[] color){
        color[node] = currcolor;
        for(int neighbour : adj.get(node)){
            if(color[neighbour] == -1){
                if(!dfs(neighbour,1-currcolor,adj,color)){
                    return false;
                }
            }
            else if(color[neighbour] == currcolor){
                return false;
            }
        }
        return true;
    }
}