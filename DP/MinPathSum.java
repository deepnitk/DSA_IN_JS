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

//Memoization solution

class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return minPathSumUtil(n - 1, m - 1, grid, dp);
    }

    private int minPathSumUtil(int row, int col, int[][] grid, int[][] dp) {
        if (row == 0 && col == 0) {
            return grid[0][0];
        }
        if (row  < 0 || col < 0) {
            return (int) Math.pow(10, 9);
        }
        if (dp[row][col] != -1) {
            return dp[row][col];
        }
        int up = grid[row][col] + minPathSumUtil(row - 1, col, grid, dp);
        int left = grid[row][col] + minPathSumUtil(row, col - 1, grid, dp);

         return dp[row][col] = Math.min(up, left);  
    }
}
