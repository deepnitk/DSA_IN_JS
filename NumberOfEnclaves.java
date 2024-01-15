class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int[] dr = {-1, 0, +1, 0};
        int[] dc = {0, 1, 0, -1};
        int[] notSurrounded = {0};
        int count = 0;
        for (int i = 0;i < n;i++) {
            for (int j = 0;j < m;j++) {
                if(grid[i][j] == 1) {
                    count++;
                }
            }
        }
        for (int i = 0;i < n;i++) {
            if (grid[i][0] == 1  && vis[i][0] == 0) {
                dfs(i, 0, grid, vis, dr, dc, notSurrounded);
            }
            if ( grid[i][m -1] == 1 && vis[i][m - 1] == 0) {
                dfs(i, m -1, grid, vis, dr, dc, notSurrounded);
            }
        }
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1 && vis[0][j] == 0) {
                dfs(0, j, grid, vis, dr, dc, notSurrounded);
            }
            if (grid[n - 1][j] == 1 && vis[n - 1][j] == 0) {
                dfs(n - 1, j, grid, vis, dr, dc, notSurrounded);
            }
        }
        return count - notSurrounded[0];
    }

    private void dfs( int row, int col, int[][] grid, int[][] vis, int[] dr, int[] dc, int[] notSurrounded) {
        notSurrounded[0] = notSurrounded[0] + 1;
        vis[row][col] = 1;
        int n = grid.length;
        int m = grid[0].length;
        
        for(int i = 0; i < 4; i++) {
            int nRow = row + dr[i];
            int nCol = col + dc[i];
            if ((nRow >= 0 && nRow < n) 
                && (nCol >= 0 && nCol < m) 
                && vis[nRow][nCol] == 0 
                && grid[nRow][nCol] == 1) {
                    dfs(nRow, nCol, grid, vis, dr, dc, notSurrounded);
                }
        }
        
    }
}
