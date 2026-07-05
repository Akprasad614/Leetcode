class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        int[] visited = new int[n];
        int ans = -1;
        for(int i=0;i<n;i++){
            if(visited[i] == 1){
                continue;
            }

            Map<Integer,Integer> map = new HashMap<>();
            int node = i;
            int step =0;
            while(node != -1){
                if(map.containsKey(node)){
                    ans = Math.max(ans,step-map.get(node));
                    break;
                }
                if(visited[node] == 1){
                    break;
                }
                map.put(node,step);
                visited[node] = 1;
                step++;
                node = edges[node];
            }
        }
        return ans;
    }
}