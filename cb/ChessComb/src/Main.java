import java.util.*; 
//import java.io.*;


class Main {  
	  public static String ChessboardTraveling(String str) { 
	  
		
		  char[] c = str.toCharArray();
		  int[] numbers = new int[str.length()];
		  int h1, h2, l1, l2, n, m;
		  long fn = 1, fm = 1, fmn = 1;
		  long a;

		  for(int i = 0; i < str.length(); i++) {
		     if(c[i] >= 48 && c[i] <= 57) {
		    	 numbers[i] = c[i] - 48;
		     } else {
		    	 numbers[i] = 0;
		     } 
		  }
	    
	    h1 = numbers[1];
		l1 = numbers[3];
		h2 = numbers[6];
		l2 = numbers[8];
		
		n = h2 - h1;
		m = l2 - l1;
		
	    fn = fact(n); 
	    fm = fact(m);
		fmn = fact(m + n); 
	    
		a = fmn / (fn * fm);
		
	       
	    return Integer.toString((int)a);
	    
	  } 
	  
	  public static void main (String[] args) {  
	    // keep this function call here     
	    Scanner s = new Scanner(System.in);
		System.out.print(ChessboardTraveling(s.nextLine())); 
		s.close();
	  }   
	  
	  public static long fact(int number) {
	        long result = 1;

	        for (int factor = 2; factor <= number; factor++) {
	            result *= factor;
	        }

	        return result;
	  }
	  

	  
	}
