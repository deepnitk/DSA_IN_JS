class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int m = graph[0].length;
        
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (check(i, color, graph, n) == false) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean check(int start, int[] color, int[][] graph, int V) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        color[start] = 0;

        while (!q.isEmpty()) {
            int node = q.peek();
            q.poll();
            for(int adjNode : graph[node]) {
                if (color[adjNode] == -1) {
                    color[adjNode] = 1 - color[node];
                    q.add(adjNode);
                } else if (color[adjNode] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }
}
