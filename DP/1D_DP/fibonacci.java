class Solution {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        return f(n);
    }

    private int f(int n) {
        int prev2 = 0;
        int prev = 1;
        for (int i = 2; i <= n; i++) {
            int curri = prev + prev2;
            prev2 = prev;
            prev = curri;
        }
        return prev;
    }
}
