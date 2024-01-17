class Solution {
    public int[] findOrder(int V, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        int m = prerequisites.length;
        for (int i = 0; i < m; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] inDegree = new int[V];
        for(int i = 0; i < V;i++) {
            for (int adjNode: adj.get(i)) {
                inDegree[adjNode]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0;i < V;i++){
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        int count = 0;
        int[] topo = new int[V];
        while (!q.isEmpty()) {
            int node = q.peek();
            q.poll();
            topo[count++] = node;
            for (int it: adj.get(node)) {
                inDegree[it]--;
                if (inDegree[it] == 0) {
                    q.offer(it);
                }
            }
        }

        if (count == V) return topo;
        int [] ans = {};
        return ans;
    }
}
