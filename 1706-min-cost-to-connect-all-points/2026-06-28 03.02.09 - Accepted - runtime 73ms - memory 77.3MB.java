class Solution { // no use of adj list so no more time for adj [LESS TIME]
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        boolean[] visited = new boolean[n];
        pq.offer(new int[]{0,0});
        int sum = 0;
        int count =0;

        while(!pq.isEmpty() && count<n){
            int[] curr = pq.poll();
            int node = curr[1];
            int w = curr[0];

            if(visited[node]) continue;

            visited[node] = true;
            count++;
            sum += w;
            for(int next = 0;next<n ; next++){
                if(!visited[next]){
                    int weight = Math.abs(points[node][0] - points[next][0])+
                    Math.abs(points[node][1] - points[next][1]);
                    pq.offer(new int[]{weight,next});
                }
            }
        }
        return sum;
    }
}


//.  EASY TO SOLVE BUT TAKES MORE TIME IN BUILDING ADJ LIST

// class Solution {
//     public int minCostConnectPoints(int[][] points) {
//         int n = points.length;
//         List<List<int[]>> adj = new ArrayList<>();
//         for(int i =0;i<n; i++){
//             adj.add(new ArrayList<>());
//         }
//         for(int i=0;i<n;i++){
//             for(int j=i+1;j<n;j++){
//                 int weight = Math.abs(points[i][0] - points[j][0])+
//                 Math.abs(points[i][1] - points[j][1]);
//                 adj.get(i).add(new int[]{j,weight});
//                 adj.get(j).add(new int[]{i,weight});
//             }
//         }

//         PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
//         boolean[] visited = new boolean[n];
//         pq.offer(new int[]{0,0});
//         int sum = 0;
//         while(!pq.isEmpty()){
//             int[] curr = pq.poll();
//             int node = curr[1];
//             int w = curr[0];

//             if(visited[node]) continue;
//             visited[node] = true;
//             sum += w;
//             for(int[] edge : adj.get(node)){
//                 int adjnode = edge[0];
//                 int adjweight = edge[1];
//                 if(!visited[adjnode]){
//                     pq.offer(new int[]{adjweight,adjnode});
//                 }
//             }
//         }
//         return sum;
//     }
// }