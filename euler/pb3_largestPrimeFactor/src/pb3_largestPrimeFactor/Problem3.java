package pb3_largestPrimeFactor;
import java.math.BigInteger;

public class Problem3 {

	
	public static BigInteger primeChecker(BigInteger n) {

		// We start at 3 because 2 is the only 
		// even prime number
		BigInteger sqrtn = n.sqrt();
		for (BigInteger i = BigInteger.valueOf(3); i.compareTo(sqrtn) < 0; i = i.add(BigInteger.TWO)) {
			while (n.mod(i) == BigInteger.ZERO) {
				n = n.divide(i);
			}
			sqrtn = n.sqrt();
		}
		
		return n;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger mynumber = new BigInteger("600851475143");
		System.out.println("The largest prime factor is: " + primeChecker(mynumber));
	}

}
