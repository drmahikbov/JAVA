package pb2_fiboEvenNumbers;

public class Problem2 {

	public static int fibo(long k) {
		return ((k == 0) ? 0 : (k == 1) ? 1 : fibo(k - 1) + fibo(k - 2));
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long mynum = 3524578;
		long sum = 0;
		for(long i = 0; fibo(i) <= mynum; i++) {
			if (fibo(i) % 2 == 0) {
				sum+= fibo(i);
			}
		}
		System.out.println(sum);
	}

}
