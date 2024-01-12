//BFS solution

class Pair {
    int first;
    int second;
    public Pair(int _first, int _second) {
        this.first = _first;
        this.second = _second;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        bfs(sr, sc, image, image[sr][sc], color);
        return image;
    }
    static boolean isValid(int[][] image, int n, int m, int row, int col, int prevColor, int newColor)
        {
            if(row < 0 || row >= n || col < 0 || col >= m || image[row][col] != prevColor
            || image[row][col] == newColor)
                return false;
            return true;
        }
    private void bfs(int ro, int co, int[][] image, int prevColor, int newColor) {
        image[ro][co] = newColor;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(ro, co));
        int n = image.length;
        int m = image[0].length;

        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();
            
            if (isValid(image, n, m, row - 1, col, prevColor, newColor)) {
                image[row - 1][col] = newColor;
                q.add(new Pair(row - 1, col));
            }
             if (isValid(image, n, m, row + 1, col, prevColor, newColor)) {
                image[row + 1][col] = newColor;
                q.add(new Pair(row + 1, col));
            }
             if (isValid(image, n, m, row, col - 1, prevColor, newColor)) {
                image[row][col - 1] = newColor;
                q.add(new Pair(row, col - 1));
            }
             if (isValid(image, n, m, row, col + 1, prevColor, newColor)) {
                image[row][col + 1] = newColor;
                q.add(new Pair(row, col + 1));
            }
        } 
    }
}
