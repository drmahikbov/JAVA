import java.util.Scanner;

public class Main {

	public static long FirstFactorial(int n) {
		return (n == 1) ? 1 : n*FirstFactorial(n-1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println(FirstFactorial(s.nextInt()));
	}

}
