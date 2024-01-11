class Solution {
    public int countComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        boolean vis[] = new boolean[n];
        int count = 0;
        for(int i = 0; i < vis.length; i++) {
            if (!vis[i]) {
                count++;
                dfs(i, vis, adjList);
            }
        }
        return count;
    }

    public void dfs(int node, boolean vis[],  ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;
        for(int it: adj.get(node)) {
            if (!vis[it]) {
                dfs(it, vis, adj);
            }
        }
    }
}
