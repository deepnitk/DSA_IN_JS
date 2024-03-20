import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int nCopy = n;
		int noOfDigit = (int)Math.log10(n) + 1;
		int ans = 0;
		while (n != 0) {
			int last = n % 10;
			ans  += (int)Math.pow(last, noOfDigit);
			n = n / 10;
		}
		if (ans == nCopy) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}

	}
}
