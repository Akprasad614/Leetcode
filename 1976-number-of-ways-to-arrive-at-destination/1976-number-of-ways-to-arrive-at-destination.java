class Solution {
    public int countPaths(int n, int[][] roads) {
        long MOD = 1_000_000_007L;        
        List<List<int[]>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] road : roads){
            adj.get(road[0]).add(new int[]{road[1], road[2]});
            adj.get(road[1]).add(new int[]{road[0], road[2]});
        }

        long[] dist = new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0] = 0;

        long[] ways = new long[n];
        ways[0] = 1;

        //{distance, node}
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b) -> Long.compare(a[0],b[0]));
        pq.offer(new long[]{0,0});

        while(!pq.isEmpty()){
            long[] curr = pq.poll();
            long d = curr[0];
            int node = (int)curr[1];

            if(d>dist[node]){
                continue;
            }

            for(int[] edge : adj.get(node)){
                int adjnode = edge[0];
                int newdist = edge[1];

                if(d + newdist < dist[adjnode]){
                    dist[adjnode] = d+newdist;
                    pq.offer(new long[]{dist[adjnode],adjnode});
                    ways[adjnode] = ways[node];
                }
                else if(d + newdist == dist[adjnode]){
                    ways[adjnode] = (ways[adjnode]+ ways[node]) % MOD;
                }
            }
        }
        return (int)(ways[n-1] % MOD);
    }
}