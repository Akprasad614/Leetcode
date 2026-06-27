class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = graph.length;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        int[] outdegree = new int[n];   
        Queue<Integer> q = new LinkedList<>();


        //Start from terminal nodes (outdegree 0), move backward through the reverse graph, and keep deleting outgoing edges. When a node has no outgoing edges left, it becomes safe. 

        for(int i =0;i<n;i++){
            outdegree[i] = graph[i].length;         
            for(int node : graph[i]){
                adj.get(node).add(i);
            }
            if(outdegree[i] == 0){
                q.offer(i);
            }
        
        }

        boolean[] safe = new boolean[n];
        while(!q.isEmpty()){
            int curr = q.poll();
            safe[curr] = true;

            for(int parent : adj.get(curr)){
                outdegree[parent]--;
                if(outdegree[parent] == 0){
                    q.offer(parent);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(safe[i]){
                ans.add(i);
            }
        }
        return ans;

    }
}