class Solution {
    public int numDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        HashSet<ArrayList<String>> hs = new HashSet<>();
        for (int i = 0;i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && grid[i][j] == 1) {
                    ArrayList<String> vec = new ArrayList<>();
                    dfs(i, j, vis, grid, vec, i, j);
                    hs.add(vec);
                }
            }
        }
        return hs.size();
    }

    private void dfs(int row, int col, int[][] vis, int[][] grid, ArrayList<String> vec, int row0, int col0) {
        vis[row][col] = 1;
        vec.add(toString(row - row0, col -col0));
        int n = grid.length;
        int m = grid[0].length;
        int[] dr = {-1, 0, +1, 0};
        int[] dc = {0, -1, 0, +1};

        for(int i = 0; i < 4; i++) {
            int nRow = row + dr[i];
            int nCol = col + dc[i];
            if ((nRow >= 0 && nRow < n) &&
                (nCol >= 0 && nCol < m) &&
                vis[nRow][nCol] == 0 && grid[nRow][nCol] == 1) {
                    dfs(nRow, nCol, vis, grid, vec, row0, col0);
                }
        }
    }

    private String toString(int r, int c) {
        return Integer.toString(r) + " " + Integer.toString(c);
    }
}
