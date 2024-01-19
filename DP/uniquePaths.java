//recursive approach
class Solution {
    public int uniquePaths(int m, int n) {
        return f(m - 1, n - 1);
    }

    private int f(int row, int col) {
        if (row == 0 && col == 0) {
            return 1;
        }
        int top = 0;
        int left = 0;
        if (row - 1 >= 0 )
            top = f(row - 1, col);
        if (col - 1 >= 0)
            left = f(row, col - 1);
        return top + left;
    }
}
