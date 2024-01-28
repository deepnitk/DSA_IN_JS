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
    public int minimumEffortPath(int[][] heights) {
        // PriorityQueue<Tuple> pq = new LinkedList<>((x, y) -> x.dist - y.dist);
        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>((x, y) -> x.dist - y.dist);
        pq.offer(new Tuple(0, 0, 0));

        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];
        for(int[] row: dist) {
            Arrays.fill(row, (int)(1e9));
        }
        dist[0][0] = 0;
        
        while(!pq.isEmpty()) {
            int currDist = pq.peek().dist;
            int currRow = pq.peek().row;
            int currCol = pq.peek().col;
            pq.remove();
            if (currRow == n -1 && currCol == m - 1) {
                        return currDist;
                    }
            int[] dr = {-1, 0, 1, 0};
            int[] dc = {0, 1, 0, -1};
            
            for(int i = 0; i < 4; i++) {
                int nRow = currRow + dr[i];
                int nCol = currCol + dc[i];
                if ((nRow >= 0 && nRow < n && nCol >= 0 && nCol < m)) {
                    int newDist = Math.max(Math.abs(heights[nRow][nCol] - heights[currRow][currCol]), currDist);
                    
                    if(newDist < dist[nRow][nCol]) {
                        dist[nRow][nCol] = newDist;
                        pq.offer(new Tuple(newDist, nRow, nCol));
                    }
                } 
            }
        }
        return dist[n-1][m-1];
    }
}
