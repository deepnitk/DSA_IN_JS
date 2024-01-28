class Tuple {
    int dist;
    int row;
    int col;
    Tuple(int _dist, int _row, int _col) {
        this.dist = _dist;
        this.row = _row;
        this.col = _col;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(1, 0, 0));

        int n = grid.length;
        int m = grid[0].length;
        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1) {
            return -1;
        }
        if (n == 1 && m == 1) {
            return 1;
        }
        int[][] dist = new int[n][m];
        for(int i = 0;i<n;i++) {
            for(int j =0;j<m;j++) {
                dist[i][j] = (int)(1e9); 
            }
        }
        dist[0][0] = 0;

        while (!q.isEmpty()) {
            int currDist = q.peek().dist;
            int currRow = q.peek().row;
            int currCol = q.peek().col;
            q.remove();

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i == 0 && j ==0) {
                        continue;
                    }
                    int nRow = currRow + i;
                    int nCol = currCol + j;
                    if ((nRow >= 0 && nRow < n && nCol >= 0 && nCol < m) &&
                        grid[nRow][nCol] == 0 &&
                        dist[nRow][nCol] > currDist + 1) {
                            dist[nRow][nCol] = currDist + 1;
                            if(nRow == n - 1 && nCol == m - 1) {
                                return currDist + 1;
                            }
                            q.offer(new Tuple(currDist + 1, nRow, nCol));
                        }
                }
            }
        }
        return -1;
    }
}
