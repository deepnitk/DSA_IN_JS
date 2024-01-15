class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] vis = new int[n][m];
        int[] dr = {-1, 0, +1, 0};
        int[] dc = {0, 1, 0, -1};
        for (int i = 0;i < n;i++) {
            if (board[i][0] == 'O'  && vis[i][0] == 0) {
                dfs(i, 0, board, vis, dr, dc);
            }
            if ( board[i][m -1] == 'O' && vis[i][m - 1] == 0) {
                dfs(i, m -1, board, vis, dr, dc);
            }
        }
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O' && vis[0][j] == 0) {
                dfs(0, j, board, vis, dr, dc);
            }
            if (board[n - 1][j] == 'O' && vis[n - 1][j] == 0) {
                dfs(n - 1, j, board, vis, dr, dc);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs( int row, int col, char[][] board, int[][] vis, int[] dr, int[] dc) {
        vis[row][col] = 1;
        int n = board.length;
        int m = board[0].length;
        
        for(int i = 0; i < 4; i++) {
            int nRow = row + dr[i];
            int nCol = col + dc[i];
            if ((nRow >= 0 && nRow < n) 
                && (nCol >= 0 && nCol < m) 
                && vis[nRow][nCol] == 0 
                && board[nRow][nCol] == 'O') {
                    dfs(nRow, nCol, board, vis, dr, dc);
                }
        }
        
    }
}
