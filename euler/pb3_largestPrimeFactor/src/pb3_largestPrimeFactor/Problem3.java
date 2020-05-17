package pb3_largestPrimeFactor;
import java.math.BigInteger;

public class Problem3 {

	
	public static BigInteger primeChecker(BigInteger n) {


		for (BigInteger i = BigInteger.valueOf(2); i.compareTo(n) < 0; i = i.add(BigInteger.ONE)) {
			System.out.println("The value of i is: " + i);
			while (n.mod(i) == BigInteger.ZERO) {
				n = n.divide(i);
				System.out.println("The value of n is:" + n);
			}
		}
		
		return n;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger mynumber = new BigInteger("600851475143");
		System.out.println("Hey there");
		System.out.println(primeChecker(mynumber));
		System.out.println("It's done");
	}

}
