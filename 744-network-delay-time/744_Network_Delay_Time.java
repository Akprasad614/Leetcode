class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] neigh : times){
            adj.get(neigh[0]).add(new int[]{neigh[2],neigh[1]});
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        pq.offer(new int[]{0,k});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int node = curr[1];
            int weight = curr[0];

            if(weight > dist[node]){
                continue;
            }

            for(int[] edge : adj.get(node)){
                int edgeweight = edge[0];
                int adjnode = edge[1];
                if(weight + edgeweight < dist[adjnode]){
                    dist[adjnode] = weight + edgeweight;
                    pq.offer(new int[]{dist[adjnode],adjnode});
                }
            }
        }

        int maxtime = 0;
        for(int i = 1;i<=n;i++){
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }
            maxtime = Math.max(dist[i],maxtime);
        }

        return maxtime;
    }
}