class DisjointSet {
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    
    public DisjointSet(int n) {
        for(int i = 0; i < n; i++) {
            size.add(0);
            parent.add(i);
        }
    }
    
    public int findUpar(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUpar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }
    
    public void unionBySize(int u, int v) {
        int ulp_u = findUpar(u);
        int ulp_v = findUpar(v);
        
        if (ulp_u == ulp_v) {
            return;
        }
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
};

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        return findCircleNumUtil(isConnected, n);
        
    }

    private int findCircleNumUtil(int[][] adjList, int V) {
        DisjointSet ds = new DisjointSet(V);
        for(int i = 0 ;i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (adjList[i][j] == 1) {
                    ds.unionBySize(i, j);
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < V; i++) {
            if (ds.parent.get(i) == i) {
                cnt++;
            }
        }
        return cnt;
    }
}
