//Recursive solution
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        return f(0, 0, triangle);
    }

    private int f(int i, int j, List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(n - 1).size();
        if (i == n - 1) {
            return Math.min(triangle.get(i).get(j), triangle.get(i).get(j));
        }
        int top = triangle.get(i).get(j) + f(i + 1, j, triangle);
        int right = triangle.get(i).get(j) + f(i + 1, j + 1, triangle);

        return Math.min(top, right);
    }
}

//Memoization solution

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(n - 1).size();
        int[][] dp = new int[n][m];
        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return f(0, 0, triangle, dp);
    }

    private int f(int i, int j, List<List<Integer>> triangle, int[][] dp) {
        int n = triangle.size();
        int m = triangle.get(n - 1).size();
        if (i == n - 1) {
            return Math.min(triangle.get(i).get(j), triangle.get(i).get(j));
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int top = triangle.get(i).get(j) + f(i + 1, j, triangle, dp);
        int right = triangle.get(i).get(j) + f(i + 1, j + 1, triangle, dp);

        return dp[i][j] = Math.min(top, right);
    }
}
