//Recursive solution

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix[0].length;
        int mini = Integer.MAX_VALUE;
        for(int j = 0; j < m; j++) {
            int ans = f(0, j, matrix);
            mini = Math.min(mini, ans);
        }
        return mini;
    }   

    private int f(int i, int j, int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        if (j < 0 || j >= m)
            return (int) Math.pow(10, 9);
        if (i == n - 1)
            return matrix[n - 1][j];

        int left = matrix[i][j] + f(i + 1, j - 1, matrix);
        int top = matrix[i][j] + f(i + 1, j, matrix);
        int right = matrix[i][j] + f(i + 1, j + 1, matrix);

        return Math.min(left, Math.min(top, right));
    }
}

//Memoization solution
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }
        int mini = Integer.MAX_VALUE;
        for(int j = 0; j < m; j++) {
            int ans = f(0, j, matrix, dp);
            mini = Math.min(mini, ans);
        }
        return mini;
    }   

    private int f(int i, int j, int[][] matrix, int[][] dp) {
        int n = matrix.length;
        int m = matrix[0].length;
        if (j < 0 || j >= m)
            return (int) Math.pow(10, 9);
        if (i == n - 1)
            return matrix[n - 1][j];
            
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int left = matrix[i][j] + f(i + 1, j - 1, matrix, dp);
        int top = matrix[i][j] + f(i + 1, j, matrix, dp);
        int right = matrix[i][j] + f(i + 1, j + 1, matrix, dp);

        return dp[i][j] = Math.min(left, Math.min(top, right));
    }
}
