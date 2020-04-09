import java.util.Arrays;
import java.util.Scanner;

public class QuestionMark {

	
	// This method checks whether the required sum is met by thw digits of the string

	public static boolean checkSum(String clean_string, int[] position_store, int zero, int one, int sum, int question_marks_amount) {
		
		// Suppose it is false
		boolean has_sum = false;
		StringBuilder sb = new StringBuilder(clean_string);
		
		String sub = sb.substring(position_store[zero]+1, position_store[one]);
		//System.out.println("The subbed string is: " + sub);
		
			for (int j = 0; j < sub.length(); j++) {
				for (int j2 = j+1; j2 < sub.length(); j2++) {
					//System.out.println(Character.getNumericValue(sub.charAt(j)) + Character.getNumericValue(sub.charAt(j2)) );
					if (Character.getNumericValue(sub.charAt(j)) + Character.getNumericValue(sub.charAt(j2)) == sum) {
						has_sum = true;
					}
				}
			}
		
			
		if(has_sum != false && one < question_marks_amount-1 && sub.length()>1) {
			checkSum(clean_string, position_store, zero+1, one+1, sum, question_marks_amount);
		}
		
		
		
		return has_sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		String string = sc.nextLine();
		
		// First thing, clean the string
		//String string = "aa6?91?";
		int question_marks_amount = string.replaceAll("[^\\?]", "").length();
		String clean_string = string.replaceAll("[^\\?\\d]", "");
		
		//System.out.println("clean string is: " + clean_string + " and there is as many '?': " + question_marks_amount);
		
		// Create an array to store the position of each question mark
		int[] position_store = new int[question_marks_amount];
		
		for(int i = 0,j = 0; i < clean_string.length(); i++) {
			//System.out.println("The number in array is: " + clean_string.charAt(i));
			if(clean_string.charAt(i) == '?') {
				position_store[j] = i;
				j++;
			} else {
				// do nothing...
			}
		}
		
		//System.out.println(Arrays.toString(position_store));
		
		// The array must be accessible by the method that checks the sum
		if(question_marks_amount < 2) {
			System.out.println(false);
		} else {	
		boolean string_has_the_sum = checkSum(clean_string, position_store, 0, 1, 10, question_marks_amount);
		System.out.println(string_has_the_sum);
		}
	}

}
