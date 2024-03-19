class Solution {
    public int reverse(int x) {
        int res = 0;
        int num = Math.abs(x);
        while (num != 0) {
            int n = num % 10;
            if (res > (Integer.MAX_VALUE - n) / 10) {
                return 0; 
            }
            res = res*10 + n;
            num = num / 10;
        }
        return x < 0 ? (-res) : res;
    }
}
