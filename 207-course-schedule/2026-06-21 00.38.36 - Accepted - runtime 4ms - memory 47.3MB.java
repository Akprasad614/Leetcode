class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i< numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            adj.get(pre[1]).add(pre[0]);
        }
        boolean[] pathVisited = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];

        for(int i = 0;i<numCourses; i++){
            if(!visited[i]){
                if(dfs(i,adj,visited,pathVisited)){
                    return false;
                }
            }
        }
        return true;
    }
    static boolean dfs(int node,List<List<Integer>> adj,boolean[] visited,boolean[] pathVisited){
        visited[node] = true;
        pathVisited[node] = true;

        for(int neighbour : adj.get(node)){
            if(!visited[neighbour]){
                if(dfs(neighbour,adj,visited,pathVisited)){
                    return true;
                }
            }
            else if(pathVisited[neighbour]){
                return true;
            }
        }
        pathVisited[node] = false;
        return false;
    }
}