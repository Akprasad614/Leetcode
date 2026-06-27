class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            adj.get(pre[1]).add(pre[0]);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];
        List<Integer> topo = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            if(!visited[i]){
                if(dfs(i,adj,visited,pathVisited,topo)){
                    return new int[0];
                }
            }
        }
        Collections.reverse(topo);
        int[] ans = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            ans[i] = topo.get(i);
        }
        return ans;
    }
    static boolean dfs(int node,List<List<Integer>> adj,boolean[] visited,boolean[] pathVisited,List<Integer> topo){
        visited[node] = true;
        pathVisited[node] = true;
        for(int neighbour : adj.get(node)){
            if(!visited[neighbour]){
                if(dfs(neighbour,adj,visited,pathVisited,topo)){
                    return true;
                }
            }
            if(pathVisited[neighbour]){
                return true;
            }
        }
        pathVisited[node] = false;
        topo.add(node);
        return false;
    }
}