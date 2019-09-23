import java.util.*;
import java.io.*;

class Main {  
  public static String ClosestEnemyII(int a) { 
	
	String[] sa = new String[] {	"0200",
									"0020",
									"0100",
									"0002"		};
	
	
	
	String str = "hello";
	
	if(str.charAt(0) == 'h') {
		System.out.println("It works fine");
	}
	
	
	
	
	// Count the amount of 2's
	int count = Arrays.toString(sa).length() - Arrays.toString(sa).replaceAll("2","").length();
	
	// Create an array for the 2's
	int[] twos = new int[count];  
	
	int one = -1;
	for(int i = 0; i < sa.length; i++) {
		
		// Store the position for the one
		// If no 1 has been found, keep looking
		if(one == -1) {
			one = sa[i].indexOf("1");
			// If a 1 has been found, combine both values
			if(one != -1) {
			one += i;
			}
		} 
	}
	
	// We now have a position for 1, let's get all the 2's
	
	int k = 0;
	for(int i = 0; i < sa.length; i++) {
		for(int j = 0; j < sa[0].length(); j++) {
			
			if(sa[i].charAt(j) == '2') {
				twos[k] = i + j;
				k++;
			}
		}
	}
	
	System.out.println(Arrays.toString(twos));
	// We now have all the 2's
	
	
	
	StringBuilder sb = new StringBuilder();
	String onestr = sb.append(one).toString();
    return onestr;
    
  } 
  
  public static void main (String[] args) {  
    // keep this function call here     
    //Scanner s = new Scanner(System.in);
   // System.out.print(ClosestEnemyII(s.nextLine())); 
	 System.out.println("Answer is: " + ClosestEnemyII(1));
  }   
  
}


  