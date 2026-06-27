class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] flight : flights){
            adj.get(flight[0]).add(new int[]{flight[1],flight[2]});
        }
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;

        // {stops, node, cost}
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,src,0});

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int stops = curr[0];
            int node = curr[1];
            int cost = curr[2];

            if(stops > k){
                continue;
            }

            for(int[] edge : adj.get(node)){
                int adjnode = edge[0];
                int price = edge[1];
                if(cost + price < dist[adjnode]){
                    dist[adjnode] = cost + price;
                    queue.offer(new int[]{stops+1,adjnode,dist[adjnode]});
                }
            }
        }
        return dist[dst] == Integer.MAX_VALUE? -1 : dist[dst];
    }
}