//Recursive solution

class Solution {
    public int climbStairs(int n) {
        return f(n);
    }

    private int f (int ind) {
        if (ind <= 1) {
            return 1;
        }
        int oneStep = f(ind - 1);
        int twoStep = f(ind - 2);
        return oneStep + twoStep;
    }
}
