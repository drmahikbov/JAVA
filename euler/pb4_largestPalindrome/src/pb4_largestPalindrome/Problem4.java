package pb4_largestPalindrome;

public class Problem4 {

	public static int getPal(int n) {
		return ((n == Integer.valueOf(new StringBuilder(Integer.toString(n)).reverse().toString())) ? n : 0);
	}

	public static boolean checkMult(int x) {
		
		
		for (int i = 100; i < 999; i++) {
			// Do the math, but one of the divisors is a multiple of 11
			if ((x / i) > 99 && (x / i) < 1000 && (x % i) == 0 && (x % 11) == 0) { 
				return true;
			}
		}
		
		return false;
	}

	public static int findPal() {

		int bignum = 999999;
		int smallnum = 10000;
		for (int i = bignum; i > smallnum; i--) {
			if (checkMult(getPal(i))) {
				return getPal(i);
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println((findPal() == 0) ? "There's been a problem, no palindrome's been found" : findPal());
	}

}
