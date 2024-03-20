public class Solution {
	public static boolean isPrime(int num) {
		//Your code goes here
		int cnt = 0;
		for(int i = 1; i*i <= num; i++) {
			if (num % i == 0) {
				cnt++;
				if (num / i != i) cnt++;
			}
		}
		if (cnt == 2) {
			return true;
		}
		return false;
	}
}
