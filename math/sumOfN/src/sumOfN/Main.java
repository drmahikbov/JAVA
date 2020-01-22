package sumOfN;

public class Main {

	public static long fact(int n) {
		return (n == 0 ? 1 : n*fact(n-1));
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 4;
		float sum = 0;
		for(int i = 0; i < n - 1; i++) {
			for(int j = i + 1; j < n; j++) {
				sum += ((float) fact(n))/((n-i)*(n-j));
				System.out.println(i + " " + j);
				//System.out.println(sum);
			}
		}
		
		System.out.println(fact(n));
		System.out.println(sum);
	}

}
