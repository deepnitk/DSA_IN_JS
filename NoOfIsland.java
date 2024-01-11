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
