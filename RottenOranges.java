class Tuple {
    int row;
    int col;
    int level;
    public Tuple(int _row, int _col, int _level) {
        this.row = _row;
        this.col = _col;
        this.level = _level;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int cntFresh = 0;
        Queue<Tuple> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Tuple(i, j, 0));
                    vis[i][j] = 2; 
                } else {
                    vis[i][j] = 0;
                }
                if (grid[i][j] == 1) {
                    cntFresh++;
                }
            }
        }
        int cnt = 0;
        int tm = 0;
        int dRow[] = {-1, 0, +1, 0};
        int dCol[] = {0, 1, 0, -1};

        while(!q.isEmpty()) {
            Tuple tp = q.peek();
            int row = tp.row;
            int col = tp.col;
            int level = tp.level;
            q.remove();
            tm = Math.max(tm, level);
            for (int i = 0; i < 4; i++) {
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];
                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m 
                    && vis[nRow][nCol] == 0 
                    && grid[nRow][nCol] == 1){
                        vis[nRow][nCol] = 2;
                        q.add(new Tuple(nRow, nCol, level + 1));
                        cnt++;
                    }
            }
        }
        if (cnt != cntFresh) return -1;
            return tm;
    }
}
