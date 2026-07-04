import java.util.*;

class Solution {

    int timer = 0;

    private void dfs(int node, int parent,
                     List<List<Integer>> adj,
                     boolean[] visited,
                     int[] tin,
                     int[] low,
                     List<List<Integer>> ans) {

        visited[node] = true;

        tin[node] = low[node] = timer++;

        for (int neighbour : adj.get(node)) {

            // Ignore the edge back to parent
            if (neighbour == parent)
                continue;

            // Back Edge
            if (visited[neighbour]) {

                low[node] = Math.min(low[node], tin[neighbour]);

            } else {

                // Tree Edge
                dfs(neighbour, node, adj, visited, tin, low, ans);

                // Update lowest reachable time
                low[node] = Math.min(low[node], low[neighbour]);

                // Bridge found
                if (low[neighbour] > tin[node]) {
                    ans.add(Arrays.asList(node, neighbour));
                }
            }
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph
        for (List<Integer> edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        int[] tin = new int[n];
        int[] low = new int[n];

        List<List<Integer>> ans = new ArrayList<>();

        // Handle disconnected graph
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, -1, adj, visited, tin, low, ans);
            }
        }

        return ans;
    }
}