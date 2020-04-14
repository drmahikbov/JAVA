//import java.util.*; 
//import java.io.*;

public class Numbers {

	 public static void main (String[] args) {
	
		  //  Scanner s = new Scanner(System.in);
		    System.out.print(check(4320));
		 
		
	
	int[] numbers = new int[4321];
	for(int i = 0, j = 0; i < 4321; i++){
			if(check(i)) {
				
				numbers[j] = i;
				System.out.println(numbers[j]);
				j++;
			} else {
			//	numbers[i] = 77777;
			}

		
	}
	System.out.print("It is this long: " + numbers.length);
}

public static boolean check(long n) {
	String REGEX = ".*[0].*";
	String s = Long.toString(n);
	// Lookout for any number which contains a 0 or at least one digit between 5 and 9
	if(s.matches(".*[5-9].*") || s.matches(REGEX) ){
		return false;
	}
	else return true;
}

}