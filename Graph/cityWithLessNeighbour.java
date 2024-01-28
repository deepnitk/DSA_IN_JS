class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] d = new int[n][n];
        for(int i = 0; i < n ; i++) {
            for(int j = 0; j < n; j++) {
                d[i][j] = Integer.MAX_VALUE;
            }
        }
        inr m = edges.length;
        for(int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            d[u][v] = wt;
            d[v][u] = wt;
        }
        for (int i = 0; i < n ; i++) {
            d[i][i] = 0;
        }

        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (d[i][via] == Integer.MAX_VALUE || d[via][j] == Integer.MAX_VALUE) continue;
                    d[i][j] = Math.min(d[i][j], d[i][via] + d[via][j]);
                }
            }
        }

        int cntCity = n;
        int cityNo = -1;
        for (int city = 0; city < n; city++) {
            int cnt = 0;
            for (int adjCity = 0; adjCity < n; adjCity++) {
                if (d[city][adjCity] <= distanceThreshold)
                    cnt++;
            }

            if (cnt <= cntCity) {
                cntCity = cnt;
                cityNo = city;
            }
        }
        return cityNo;


    }
}
