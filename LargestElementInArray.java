import java.util.* ;
import java.io.*; 

public class Solution {

    static int largestElement(int[] arr, int n) {
        // Write your code here.
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (maxi < arr[i]) {
                maxi = arr[i];
            }
        }
        return maxi;

    }
}
