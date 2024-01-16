class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        int[] vis = new int[V];
        int[] pathVis = new int[V];
        int[] checkNodes = new int[V];
        List<Integer> safeNodes = new ArrayList<>();
        for(int i = 0;i < V;i++) {
            if (vis[i] == 0) {
                dfsCheck(i, vis, pathVis, graph, checkNodes);
            }
        }

        for(int i = 0; i < V; i++) {
            if (checkNodes[i] == 1) {
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }

    private boolean dfsCheck(int node, int[] vis, int[] pathVis, int[][] graph, int[] checkNodes) {
        vis[node] = 1;
        pathVis[node] = 1;
        checkNodes[node] = 0;
        for (int it: graph[node]) {
            if (vis[it] == 0) {
                if (dfsCheck(it, vis, pathVis, graph, checkNodes) == true) {
                    return true;
                }
            } else if (pathVis[it] == 1) {
                    return true;
            }
        }
        pathVis[node] = 0;
        checkNodes[node] = 1;
        return false;
    }
}
