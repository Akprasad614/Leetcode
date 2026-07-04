import java.util.*;

class Solution {

    ArrayList<Integer>[] adj;
    int[] tin;
    int[] low;
    int[] vis;
    List<List<Integer>> ans;
    int timer = 0;

    private void dfs(int node, int parent) {

        vis[node] = 1;
        tin[node] = low[node] = timer++;

        for (int neighbour : adj[node]) {

            // Ignore the parent edge
            if (neighbour == parent)
                continue;

            // Back edge
            if (vis[neighbour] == 1) {
                low[node] = Math.min(low[node], tin[neighbour]);
            }
            // Tree edge
            else {

                dfs(neighbour, node);

                low[node] = Math.min(low[node], low[neighbour]);

                // Bridge found
                if (low[neighbour] > tin[node]) {
                    ans.add(Arrays.asList(node, neighbour));
                }
            }
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        // Build graph
        for (List<Integer> edge : connections) {
            int u = edge.get(0);
            int v = edge.get(1);

            adj[u].add(v);
            adj[v].add(u);
        }

        tin = new int[n];
        low = new int[n];
        vis = new int[n];
        ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                dfs(i, -1);
            }
        }

        return ans;
    }
}