//DFS Solution...

class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int noOfIsland = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1') {
                    noOfIsland++;
                    dfs(grid, row, col, rows, cols);
                }
            }
        }
        return noOfIsland;
    }

    private void dfs(char[][] grid, int row, int col, int rows, int cols) {
        if (grid[row][col] == '0' || grid[row][col] == '2') {
            return;
        }

        grid[row][col] = '2';

        if (row - 1 >= 0) {
            dfs(grid, row - 1, col, rows, cols);
        }
        if (row + 1 < rows) {
            dfs(grid, row + 1, col, rows, cols);
        }
        if (col - 1 >= 0) {
            dfs(grid, row, col - 1, rows, cols);
        }
        if (col + 1 < cols) {
            dfs(grid, row, col + 1, rows, cols);
        }
    }
}

//BFS Solution
// TC: O(n*m)
// SC: O(n*m) + O(n*m) 
class Pair {
    int first;
    int second;
    public Pair(int _first, int _second) {
        this.first = _first;
        this.second = _second;
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int noOfIsland = 0;
        int[][] vis = new int[n][m];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (vis[row][col] == 0 && grid[row][col] == '1') {
                    noOfIsland++;
                    bfs(row, col, vis, grid);
                }
            }
        }
        return noOfIsland;
    }

    private void bfs(int ro, int co, int[][] vis, char[][] grid) {
        vis[ro][co] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(ro, co));
        int n = grid.length;
        int m = grid[0].length;

        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();

            if(row - 1 >= 0 && grid[row - 1][col] == '1' && vis[row - 1][col] == 0) {
                vis[row - 1][col] = 1;
                q.add(new Pair(row - 1, col));
            }
            if(row + 1 < n && grid[row + 1][col] == '1' && vis[row + 1][col] == 0) {
                vis[row + 1][col] = 1;
                q.add(new Pair(row + 1, col));
            }
            if(col - 1 >= 0 && grid[row][col - 1] == '1' && vis[row][col - 1] == 0) {
                vis[row][col - 1] = 1;
                q.add(new Pair(row, col - 1));
            }
            if(col + 1 < m && grid[row][col + 1] == '1' && vis[row][col + 1] == 0) {
                vis[row][col + 1] = 1;
                q.add(new Pair(row, col + 1));
            }
        }
    }

}
