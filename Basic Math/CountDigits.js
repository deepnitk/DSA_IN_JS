public class Solution {
    public static int countDigits(int n){
        int count = 0;
        int num = n;
        while (num != 0) {
            int digit = num % 10;
            if (digit != 0) {
                if (n % digit == 0) count++;
            }
            num = num / 10;
        }
        return count;
    }
}
