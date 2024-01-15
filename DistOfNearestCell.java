class Pair {
    int x;
    int y;
    int z;
    public Pair(int _x, int _y, int _z) {
        this.x = _x;
        this.y = _y;
        this.z = _z;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] vis = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    vis[i][j] = 0;
                    ans[i][j] = 0;
                    q.offer(new Pair(i, j, 0));
                } else {
                    vis[i][j] = 1;
                }
            }
        }
        bfs(vis, mat, ans, q);
        return ans;
    }

    private void bfs(int[][] vis, int[][] mat, int[][] ans, Queue<Pair> q){
        int n = mat.length;
        int m = mat[0].length;
        while(!q.isEmpty()) {
            int ro = q.peek().x;
            int co = q.peek().y;
            int level = q.peek().z;
            q.poll();
            
            int[] dr = {-1, 0, +1, 0};
            int[] dc = {0, +1, 0, -1};

            for(int i = 0;i<4;i++) {
	            int nRow = ro + dr[i]; 
	            int nCol = co + dc[i]; 
                if ((nRow >= 0 && nRow < n) && (nCol >= 0 && nCol < m) 
                    && vis[nRow][nCol] == 1 
                    && mat[nRow][nCol] != 0) {
                        vis[nRow][nCol] = 0;
                        ans[nRow][nCol] = level + 1;
                        q.offer(new Pair(nRow, nCol, level + 1));
                }
            }
        }
        return;
    }
}
