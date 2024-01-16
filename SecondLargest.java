//Brute force


import java.util.Arrays;
public class Solution {
    public static int[] getSecondOrderElements(int n, int []a) {
        // Write your code here.
        Arrays.sort(a);
        int[] res = {a[a.length - 2], a[1]};
        return res;
    }
}

//Better approach


import java.util.Arrays;
public class Solution {
    public static int[] getSecondOrderElements(int n, int []a) {
        // Write your code here.

        int largest = a[0];
        int smallest = a[0];
        for (int i = 0; i < n; i++) {
            if (a[i] > largest) {
                largest = a[i];
            }
             if (a[i] < smallest) {
                smallest = a[i];
            }
        }
        int secLargest = -1;
        int secSmallest = Integer.MAX_VALUE;
        for(int i = 0; i< n; i++) {
            if (a[i] > secLargest && a[i] != largest) {
                secLargest = a[i];
            }
            if (a[i] < secSmallest && a[i] != smallest) {
                secSmallest = a[i];
            }
        }
        int[]res = {secLargest, secSmallest};
        return res;
    }
}
