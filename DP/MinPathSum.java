// Recursive solution

class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        return minPathSumUtil(n - 1, m - 1, grid);
    }

    private int minPathSumUtil(int row, int col, int[][] grid) {
        if (row == 0 && col == 0) {
            return grid[0][0];
        }
        if (row  < 0 || col < 0) {
            return (int) Math.pow(10, 9);
        }

        int up = grid[row][col] + minPathSumUtil(row - 1, col, grid);
        int left = grid[row][col] + minPathSumUtil(row, col - 1, grid);

         return Math.min(up, left);  
    }
}
