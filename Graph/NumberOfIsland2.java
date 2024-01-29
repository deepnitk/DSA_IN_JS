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
    private boolean isValid(int adjr, int adjc, int m, int n) {
        return adjr >= 0 && adjr < m && adjc >= 0 && adjc < n;
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        DisjointSet ds = new DisjointSet(m * n);
        int[][] vis = new int[m][n];
        int cnt = 0;

        int len =  positions.length;
        for (int i = 0; i < len; i++) {
            int u = positions[i][0];
            int v = positions[i][1];
            if (vis[u][v] == 1) {
                ans.add(cnt);
                continue;
            }
            vis[u][v] = 1;
            cnt++;
            int dr[] = { -1, 0, 1, 0};
            int dc[] = {0, 1, 0, -1};
            for (int ind = 0; ind < 4; ind++) {
                int adjr = u + dr[ind];
                int adjc = v + dc[ind];
                if (isValid(adjr, adjc, m, n)) {
                    if (vis[adjr][adjc] == 1) {
                        int nodeNo = u * m + v;
                        int adjNodeNo = adjr * m + adjc;
                        if (ds.findUpar(nodeNo) != ds.findUpar(adjNodeNo)) {
                            cnt--;
                            ds.unionBySize(nodeNo, adjNodeNo);
                        }
                    }
                }

            }
            ans.add(cnt);
        }
        return ans;
    }
}
